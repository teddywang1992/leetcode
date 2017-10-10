package ebay;

public class MovingAverageFromDataStream {
    int[] nums;
    int count = 0;
    int size = 0;
    double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        nums = new int[size];
    }

    public double next(int val) {
        if (count < size) {
            sum += val;
            nums[count] = val;
            count++;
            return (double) sum / count;
        } else {
            sum = sum - nums[count % size] + val;
            nums[count % size] = val;
            count++;
            return (double) sum / size;
        }
    }
}
