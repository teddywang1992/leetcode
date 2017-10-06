package databricks;

import java.util.ArrayList;
import java.util.List;

public class SQL {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        getQueries("select name from courseinfo;; select *88 from \"; \" ; ");

        System.out.println(list);
        System.out.println(list.size());
    }

    private static void getQueries(String s) {
        int start = 0;
        int end = 0;
        boolean unpairedQuotation = false;
        boolean unpairedSingleQuotation = false;

        while (end < s.length()) {
            if(s.charAt(end) == '\\'){
                end += 2;
            }
            if (s.charAt(end) == '"') {
                unpairedQuotation = !unpairedQuotation;
            }
            else if (s.charAt(end) == '\'') {
                unpairedSingleQuotation = !unpairedSingleQuotation;
            }
            else if (s.charAt(end) == ';' && !unpairedQuotation  && !unpairedSingleQuotation && end > start && s.charAt(end - 1) != '\\') {
                String query = s.substring(start, end).trim();
                if(query.length() > 0) {
                    list.add(query);
                }
                start = end + 1;
            }
            end++;
        }
    }
}