package systemDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyUrl {
    private Map<String, String> long2short;
    private Map<String, String> short2long;

    public TinyUrl() {
        long2short = new HashMap<>();
        short2long = new HashMap<>();
    }

    public String long2Short(String url) {
        if (long2short.containsKey(url)) {
            return long2short.get(url);
        }

        while (true) {
            String shortUrl = generate(url);
            if (!short2long.containsKey(shortUrl)) {
                short2long.put(shortUrl, url);
                long2short.put(url, shortUrl);
                return shortUrl;
            }
        }
    }

    public String short2long(String shortUrl) {
        if (short2long.containsKey(shortUrl)) {
            return short2long.get(shortUrl);
        }
        return null;
    }

    private String generate(String url) {
        String sample = "0123456789" +
                "abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String shortUrl = "http://tiny.url/";

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(62);
            shortUrl = shortUrl + sample.charAt(index);
        }

        return shortUrl;
    }
}
