package array;

/*
下面这种解法是根据大神jinzhou的帖子，优点是代码更容易读懂，而且变量命名很reasonable，前半部分都是一样的，求出最多的次数mx，
还有同时出现mx次的不同任务的个数mxCnt。这个解法的思想是先算出所有空出来的位置，然后计算出所有需要填入的task的个数，如果超出了空位的个数，
就需要最后再补上相应的个数。注意这里如果有多个任务出现次数相同，那么将其整体放一起，就像上面的第二个例子中的CE一样，
那么此时每个part中的空位个数就是n - (mxCnt - 1)，那么空位的总数就是part的总数乘以每个part中空位的个数了，
那么我们此时除去已经放入part中的，还剩下的task的个数就是task的总个数减去mx * mxCnt，然后此时和之前求出的空位数相比较，
如果空位数要大于剩余的task数，那么则说明还需补充多余的空位，否则就直接返回task的总数即可，参见代码如下：
*/

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        int maxCount = 0;
        int[] count = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
            if (max == count[tasks[i] - 'A']) {
                maxCount++;
            }

            if (max < count[tasks[i] - 'A']) {
                max = count[tasks[i] - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partSize = n - (maxCount - 1);
        int emptySize = partCount * partSize;
        int leftTask = tasks.length - maxCount * max;
        int idles = Math.max(0, emptySize - leftTask);

        return idles + tasks.length;
    }
}
