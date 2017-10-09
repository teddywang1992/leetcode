package ebay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] keyBoard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < keyBoard.length; i++) {
            for (int j = 0; j < keyBoard[i].length(); j++) {
                map.put(keyBoard[i].charAt(j), i);
            }
        }

        for (int i = 0; i < words.length; i++) {
            int flag = map.get(words[i].toLowerCase().charAt(0));
            for (int j = 0; j < words[i].length(); j++) {
                if (flag != map.get(words[i].toLowerCase().charAt(j))) {
                    flag = -1;
                    break;
                }
            }

            if (flag != -1) result.add(words[i]);
        }

        return result.toArray(new String[0]);
    }
}
