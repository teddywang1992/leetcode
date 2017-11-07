package facebook1;

public class Powxn {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        else if (n < 0) return 1 / (x * myPow(x, - n - 1));
        else return (n % 2 == 0 ? 1 : x) * myPow(x * x, n / 2);
    }
}
