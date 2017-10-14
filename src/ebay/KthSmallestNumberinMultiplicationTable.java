package ebay;

public class KthSmallestNumberinMultiplicationTable {
    public static void main(String[] args) {
//        System.out.println(findKthNumber(38,40,955));
        System.out.println(enough(437,38,40));//437
    }
    public static int findKthNumber(int m, int n, int k) {
        int start = 1;
        int end = m * n;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (enough(mid,m,n) == k) {
                System.out.println("dddR");
                return mid;
            }
            else if (enough(mid,m,n) > k) end = mid;
            else if (enough(mid,m,n) < k) start = mid;
        }
        System.out.println(start);
        System.out.println(end);
        if (enough(start, m, n) == k) return start;
        if (enough(end, m, n) == k) return end;
        return 0;
    }

    private static int enough(int target, int m, int n) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += Math.min(n, target / (i + 1));
        }

        return sum;
    }
}
