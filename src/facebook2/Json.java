package facebook2;

import java.util.HashMap;
//2. 就是按格式打印json，之前用过json不记得了格式细节了，店面小哥说无所谓，就打印就可以了
//    http://jsonprettyprint.com/
//    类似这种的， 输入[1,2,3, {"id": 1, "name": "wang", "tag":[1,"home",2], "price":234}]
//    要求打出来这个
//[  1,  2,  3,  {    "id": 1,    "name": "wang",    "tag": [      1,      "home",      2    ],    "price": 234  }]
//    因为对格式不熟悉，也没敢用recursive就直接iterative写了，感觉不太好，准备了这么久好多高级算法也学了，题也做了好多，可是需要种新题目
//    还是蒙。求问大家如何用递归比较好，现在直到｛｝是json object就是key value pair, key是string, value是啥都行（数组，数字，json obj,
// ...）[]是json array里面也啥都可以，如何有效的用递归呢？是遇到[递归还是遇到｛递归呢，目测没发现这两种情况在打印上有区别
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199846&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

public class Json {
    private HashMap<Character, Character> parentheses = new HashMap<>();
    public Json() {
        this.parentheses.put('{', '}');
        this.parentheses.put('[', ']');
    }
    public void parser(String json) {
        json = json.trim();
        if (json.charAt(0) == '{') {
            int index = findParentheses(json, '{');
            System.out.println("{");
            parseHelper(json.substring(1, index), true, "    ");
            System.out.print("}\n");
        }
        else if (json.charAt(0) == '[') {
            int index = findParentheses(json, '[');
            System.out.println("[");
            parseHelper(json.substring(1, index), false, "    ");
            System.out.print("]\n");
        }
        else {
            throw new IllegalArgumentException("Invalid json\n");
        }
    }

    private void parseHelper(String json, boolean isObj, String gap) {
        while (json.length() != 0) {
            json = json.trim();
            System.out.print(gap);

            if (isObj) {
                if (json.charAt(0) != '\"') {
                    throw new IllegalArgumentException("Invalid json.\n");
                }
                //find the attribute's name
                int first = findString(json);
                System.out.print(json.substring(0, first + 1));
                // check if the next char is ":"
                json = json.substring(first + 1).trim();
                if (json.charAt(0) != ':') {
                    throw new IllegalArgumentException("Invalid json.\n");
                }
                System.out.print(":");
                json = json.substring(1).trim();
            }
            // parse the value of the attribute
            int lastIndex = parseElement(json, gap);
            // check after the value if there is a "," or it is the end
            json = json.substring(lastIndex + 1).trim();
            if (json.length() > 0) {
                if (json.charAt(0) != ',') {
                    throw new IllegalArgumentException("Invalid json.\n");
                }
                System.out.print(",");
                json = json.substring(1).trim();
            }
            System.out.print("\n");
        }
    }

    private int parseElement(String element, String gap) {
        int lastIndex = -1;
        switch (element.charAt(0)) {
            case '\"': // if it is a string
                lastIndex = findString(element);
                System.out.print(element.substring(0, lastIndex + 1));
                break;
            case '{': // if it is a json object
                lastIndex = findParentheses(element, '{');
                System.out.print("{\n");
                parseHelper(element.substring(1, lastIndex), true, gap + "    ");
                System.out.print(gap + "}");
                break;
            case '[': // if it is a json array
                lastIndex = findParentheses(element, '[');
                System.out.print("[\n");
                parseHelper(element.substring(1, lastIndex), false, gap + "    ");
                System.out.print(gap + "]");
                break;
            default: //if it is a number
                lastIndex = findNumber(element);
                System.out.print(element.substring(0, lastIndex + 1));
                break;
        }
        return lastIndex;
    }

    private int findParentheses(String str, char parenthese) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == parenthese) {
                count++;
            }
            else if (str.charAt(i) == parentheses.get(parenthese)) {
                count--;
            }
            if (count < 0) {
                throw new IllegalArgumentException("Invalid Json\n");
            }
            else if (count == 0) {
                return i;
            }
        }
        if (count != 0) {
            throw new IllegalArgumentException("Invalid Json\n");
        }
        return str.length() - 1;
    }

    private int findString(String element) {
        for (int i = 1; i < element.length(); i++) {
            if (element.charAt(i) == '\"') {
                return i;
            }
        }
        return -1;
    }

    private int findNumber(String element) {
        for (int i = 0; i < element.length(); i++) {
            if (!Character.isDigit(element.charAt(i))) {
                return i - 1;
            }
        }
        return element.length() - 1;
    }
}
