package ebay;

public class HouseRobber {
    public int rob(int[] num) {
        int n = num.length;
        int a = 0;
        int b = 0;

        for (int i=0; i<n; i++)
        {
            if (i%2==0)
            {
                a = Math.max(a+num[i], b);
            }
            else
            {
                b = Math.max(a, b+num[i]);
            }
        }

        return Math.max(a, b);
    }
}
