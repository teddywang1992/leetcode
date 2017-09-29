package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeTinyURL {
    List<String> url = new ArrayList<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        url.add(longUrl);
        return String.valueOf(url.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index < url.size()) ? url.get(index) : "";
    }
}
