package systemDesign;

public class mainClass {
    public static void main(String[] args) {
        TinyUrl obj = new TinyUrl();
        String url1 = "https://www.jiuzhang.com/solution/tiny-url/";
        String url2 = "https://leetcode.com/problems/design-tinyurl/description/";

        String short1 = obj.long2Short(url1);
        String short2 = obj.long2Short(url2);
        System.out.println(short1);
        System.out.println(short2);

        String url3 = obj.short2long(short1);
        System.out.println(url3);
    }
}
