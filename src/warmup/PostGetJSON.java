package warmup;

import org.json.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostGetJSON {
    public static void main(String[] args) throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("http://jsonplaceholder.typicode.com/users");
        System.out.println(json.toString());
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    static int maximumDifference(int nodes, int[] a, int[] b) {
        int result = Integer.MIN_VALUE;
        int[] father = new int[nodes + 1];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            union(a[i], b[i], father);
        }
        for (int i = 1; i < father.length; i++) {
            result = Math.max(result, i - find(i, father));
        }
        return result;
    }

    public static int find(int x, int[] father) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x], father);
        return father[x];
    }

    public static void union(int a, int b, int[] father) {
        int root_a = find(a, father);
        int root_b = find(b, father);
        if (root_a != root_b) {
            if (root_a > root_b) {
                father[root_a] = root_b;
            } else {
                father[root_b] = root_a;
            }
        }
    }

    static int newmaximumDifference(int g_nodes, int[] g_from, int[] g_to) {
        if (g_nodes == 0) return 0;
        int flag[] = new int[g_nodes];
        int res = 0;
        for (int i = 0; i < flag.length; i++) {
            flag[i] = i;
        }

        for (int i = 0; i < g_from.length; i++) {
            int fromNode = g_from[i];
            int toNode = g_to[i];
            int min = Math.min(flag[fromNode - 1], flag[toNode - 1]);
            int max = Math.max(flag[fromNode - 1], flag[toNode - 1]);

            for (int j = 0; j < flag.length; j++) {
                if (flag[j] == max) {
                    flag[j] = min;
                }
            }
        }

        for (int i = 0; i < flag.length; i++) {
            res = Math.max(res, Math.abs(flag[i] - i));
        }

        return res;
    }
}
