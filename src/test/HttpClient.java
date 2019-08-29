package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Author: Akash Anjanappa
 * Date: 03/02/2018
 * */
public class HttpClient {

    private static final String POST_URL = "http://localhost:8080";
    private static final String POST_BODY = "This the data send from client...";
    private static final String GET_URL = "http://localhost:8080";

    public static void main(String[] args) {
        try {
            sendHead();
            sendPOST();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendHead() throws IOException {
        System.out.println("Sending HEAD request...");
        sendRequest(GET_URL, "HEAD", null);
        System.out.println("Completed HEAD request...");
    }


    public static void sendPOST() throws IOException {
        System.out.println("Sending POST request...");
        sendRequest(POST_URL, "POST", POST_BODY);
        System.out.println("Completed POST request...");
    }

    private static void sendRequest(String URL, String method, String data) throws IOException {
        URL obj = new URL(URL);
        HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
        httpConnection.setRequestMethod(method);

        if (method.equals("POST")) {
            httpConnection.setRequestProperty("Accept", "text/html");
            httpConnection.setRequestProperty("Content-Type", "text/html");

            httpConnection.setDoOutput(true);
            OutputStream os = httpConnection.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            os.close();
        }

        int responseCode = httpConnection.getResponseCode();
        System.out.println(method + " Response Code : " + responseCode);
        System.out.println("Response Headers:");
        System.out.println(httpConnection.getHeaderFields().toString());
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    httpConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println("Response Body:");
            System.out.println(response.toString());
        } else {
            System.out.println("Http response not OK!! cannot read content");
        }
    }
}
