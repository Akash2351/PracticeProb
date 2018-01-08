package akash;

import java.util.HashMap;

/**
 * Created by akash on 04-01-2018.
 */
public class EncodeDecodeTinyUrl {

    HashMap<String, String> keyIndex = new HashMap<>();
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyvz1234567890";
    static final String BASEURL = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int idx = (int) Math.random() * chars.length();
                sb.append(chars.charAt(idx));
            }
            key = sb.toString();
        } while (keyIndex.containsKey(key));
        keyIndex.put(key, longUrl);
        return BASEURL + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return keyIndex.get(shortUrl.replace(BASEURL, ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
