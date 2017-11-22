package interview;

public class IndeedPhone {
    public static String insert(String sentence, String keyword){
        if(keyword == null || keyword.length() == 0){
            return new String(sentence);
        }


        String newWord = "<b>" + keyword + "</b>";
        int anchor = 0, len = keyword.length();
        StringBuilder sb = new StringBuilder();
        while(sentence.indexOf(keyword, anchor) >= 0){
            int start = sentence.indexOf(keyword, anchor);
            int end = start + len - 1; // 0 + 3 = 3   5
            int nextIndex = end + 1; // 4       9
            boolean isMatch = (start == 0 || !Character.isLetterOrDigit(sentence.charAt(start - 1))) && (nextIndex >= sentence.length() || !Character.isLetterOrDigit(sentence.charAt(nextIndex)));
            if(isMatch){
                sb.append(sentence.substring(anchor, start)); //add the chars before the match
                sb.append(newWord);
            }
            else{
                sb.append(sentence.substring(anchor, nextIndex));
            }
            anchor = nextIndex;
        }

        sb.append(sentence.substring(anchor));

        return sb.toString();
    }

    public static void main(String[] s) {
        String result = insert("allsfall xyz", "all");
        System.out.println(result);
    }
}
