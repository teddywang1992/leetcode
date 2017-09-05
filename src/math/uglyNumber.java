package math;

public class uglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(1));
    }
    private static boolean isUgly(int num) {
        if (num <= 0)  return false;
        if (num == 1)  return true;

        while (num >= 2 && num % 2 == 0)  num = num / 2;
        while (num >= 3 && num % 3 == 0)  num = num / 3;
        while (num >= 5 && num % 5 == 0)  num = num / 5;

        return num == 1;
    }
}
