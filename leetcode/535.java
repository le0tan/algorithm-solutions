import java.util.*;
public class Codec {
    Map<String, String> m = new HashMap<String, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String temp = String.valueOf(UUID.randomUUID());
        while(m.get(temp) != null) {
            temp = String.valueOf(UUID.randomUUID());
        }
        m.put(temp, longUrl);
        return temp;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return m.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
