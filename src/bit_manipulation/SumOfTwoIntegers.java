package bit_manipulation;
/*
然后我们进一步分析，如果得到上面的第一第二种情况，我们在二进制下来看，不考虑进位的加，0+0=0
0+1=1, 1+0=1， 1+1=0，这就是异或的运算规则，如果只考虑进位的加0+0=0, 0+1=0, 1+0=0, 1+1=1，而这其
实这就是与的运算，而第三步在将两者相加时，我们再递归调用这个算法，终止条件是当进位为0时，我们直接
返回第一步的结果
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }

        int sum = a ^ b;
        int carry = (a & b) << 1;

        return getSum(sum, carry);
    }
}
