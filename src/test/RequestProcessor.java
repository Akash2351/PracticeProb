package test;

import java.io.*;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Author: Akash Anjanappa
 * Date: 03/02/2018
 * */

public class RequestProcessor implements Runnable {

    private final static Logger logger = Logger.getLogger(
            RequestProcessor.class.getCanonicalName());

    private File rootDirectory;
    private String indexFileName = "index.html";
    private Socket connection;

    public RequestProcessor(File rootDirectory,
                            String indexFileName, Socket connection) {

        if (rootDirectory.isFile()) {
            throw new IllegalArgumentException(
                    "rootDirectory must be a directory, not a file");
        }
        try {
            rootDirectory = rootDirectory.getCanonicalFile();
        } catch (IOException ex) {
        }
        this.rootDirectory = rootDirectory;

        if (indexFileName != null) this.indexFileName = indexFileName;
        this.connection = connection;
    }


    private void sendHeader(Writer out, String responseCode,
                            String contentType, int length)
            throws IOException {
        out.write(responseCode + "\r\n");
        Date now = new Date();
        out.write("Date: " + now + "\r\n");
        out.write("Server: JHTTP 2.0\r\n");
        out.write("Content-length: " + length + "\r\n");
        out.write("Content-type: " + contentType + "\r\n\r\n");
        out.flush();

    }

    public void run() {
        // TODO Auto-generated method stub
        // for security checks
        String root = rootDirectory.getPath();
        try {
            OutputStream raw = new BufferedOutputStream(
                    connection.getOutputStream()
            );
            Writer out = new OutputStreamWriter(raw);
            Reader in = new InputStreamReader(
                    new BufferedInputStream(
                            connection.getInputStream()
                    ), "US-ASCII"
            );
            StringBuilder requestLine = new StringBuilder();
            while (true) {
                int c = in.read();
                if (c == '\r' || c == '\n') break;
                requestLine.append((char) c);
            }

            String get = requestLine.toString();

            logger.info(connection.getRemoteSocketAddress() + " " + get);

            String[] tokens = get.split("\\s+");
            String method = tokens[0];
            String version = "";
            if (method.equals("GET")) {
                String fileName = tokens[1];
                if (fileName.endsWith("/")) fileName += indexFileName;
                String contentType =
                        URLConnection.getFileNameMap().getContentTypeFor(fileName);
                if (tokens.length > 2) {
                    version = tokens[2];
                }

                File theFile = new File(rootDirectory,
                        fileName.substring(1, fileName.length()));

                if (theFile.canRead()
                        // Don't let clients outside the document root
                        && theFile.getCanonicalPath().startsWith(root)) {
                    byte[] theData = Files.readAllBytes(theFile.toPath());
                    if (version.startsWith("HTTP/")) { // send a MIME header
                        sendHeader(out, "HTTP/1.0 200 OK", contentType, theData.length);
                    }

                    // send the file; it may be an image or other binary data
                    // so use the underlying output stream
                    // instead of the writer
                    raw.write(theData);
                    raw.flush();
                } else { // can't find the file
                    String body = new StringBuilder("<HTML>\r\n")
                            .append("<HEAD><TITLE>File Not Found</TITLE>\r\n")
                            .append("</HEAD>\r\n")
                            .append("<BODY>")
                            .append("<H1>HTTP Error 404: File Not Found</H1>\r\n")
                            .append("</BODY></HTML>\r\n").toString();
                    if (version.startsWith("HTTP/")) { // send a MIME header
                        sendHeader(out, "HTTP/1.0 404 File Not Found",
                                "text/html; charset=utf-8", body.length());
                    }
                    out.write(body);
                    out.flush();
                }
            } else if (method.equals("HEAD")) {
                if (tokens.length > 2) {
                    version = tokens[2];
                }
                File indexFile = new File(rootDirectory, indexFileName);
                System.out.println("Received HEAD request");
                if (indexFile.canRead()) {
                    byte[] fileData = Files.readAllBytes(indexFile.toPath());
                    String contentType =
                            URLConnection.getFileNameMap().getContentTypeFor(indexFileName);
                    if (version.startsWith("HTTP/")) { // send a  header
                        sendHeader(out, "HTTP/1.0 200 OK", contentType, fileData.length);
                    }
                } else {
                    //index file not present...sent response with content length 0
                    if (version.startsWith("HTTP/")) { // send a header
                        sendHeader(out, "HTTP/1.0 200 OK", "text/html; charset=utf-8", 0);
                    }
                }
            } else if (method.equals("POST")) {
                int postDataLength = 0;
                //get the body length...
                while (true) {
                    int c = in.read();
                    requestLine.append((char) c);
                    if (requestLine.toString().contains("Content-Length:")) {
                        String lenStr = "";
                        while (true) {
                            char temp = (char) in.read();
                            if (temp != '\n') {
                                lenStr += temp;
                            } else {
                                break;
                            }
                        }
                        lenStr = lenStr.trim();
                        postDataLength = Integer.parseInt(lenStr);
                        break;
                    }
                }
                //read the body content:
                char[] postdata = new char[postDataLength + 2];

                in.read(postdata, 0, postDataLength + 2);

                String data = new String(postdata);
                String response = "<html>" +
                        "<head>" +
                        "<title>Post Response from JHHTP server</title>" +
                        "</head>" +
                        "<body>" +
                        "<p> Body Content: " + data + "</p>" +
                        "</body>" +
                        "</html>";
                String header = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: " + response.length();
                String endOfLine = "\r\n\r\n";
                System.out.println("Received POST request");
                System.out.println("Sending response to client:" + header + response);
                out.write(header + response.length() + endOfLine + response);
                out.flush();
                out.close();

            } else { // method does not equal "GET"
                //for other method requests...
                String body = new StringBuilder("<HTML>\r\n")
                        .append("<HEAD><TITLE>Not Implemented</TITLE>\r\n")
                        .append("</HEAD>\r\n")
                        .append("<BODY>")
                        .append("<H1>HTTP Error 501: Not Implemented</H1>\r\n")
                        .append("</BODY></HTML>\r\n").toString();
                if (version.startsWith("HTTP/")) { // send a MIME header
                    sendHeader(out, "HTTP/1.0 501 Not Implemented",
                            "text/html; charset=utf-8", body.length());
                }
                out.write(body);
                out.flush();
            }
        } catch (IOException ex) {
            logger.log(Level.WARNING,
                    "Error talking to " + connection.getRemoteSocketAddress(), ex);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (IOException ex) {
            }
        }
    }
}
