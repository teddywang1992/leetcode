package databricks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SQL {
    static List<String> list = new ArrayList<>();
    private static String string;

    public static void main(String[] args) {
        File file = new File("/Users/teddywang/Desktop/sqls");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                string = tempString;
                line++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getQueries(string);
        System.out.println(list);
        System.out.println(list.size());
    }

    private static void getQueries(String s) {
        int start = 0;
        int end = 0;
        boolean colonSeen = false;

        while (end < s.length()) {
            if (s.charAt(end) == '\\') {
                end += 2;
                System.out.println(end);
            }

            if (s.charAt(end) == '"') {
                colonSeen = colonSeen ? false : true;
            }

            if (s.charAt(end) == ';' && !colonSeen && end > 0 && s.charAt(end - 1) != '\\') {
                list.add(s.substring(start, end).trim());
                start = end + 1;
            }
            end++;
        }
    }

    private void validQuery(String s){
        int idx = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == '\\'){
                idx += 2;
                continue;
            }

            if(s.charAt(idx) == '\'' || s.charAt(idx) == '"'){
                int j = idx + 1;
                while(j < s.length() && s.charAt(j) != s.charAt(idx)){
                    j += (s.charAt(j) == '\\' ? 2 : 1);
                }
                idx = j + 1;
                continue;
            }

            if(s.charAt(idx) == ';'){
                String tmp = s.substring(0, idx);
                list.add(tmp.trim());
            }

            s = s.substring(idx, s.length());
            idx = 0;
            continue;
        }
    }
}
