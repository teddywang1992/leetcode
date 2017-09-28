package array;
/*
下面这种方法是网上比较流行的一种方法，设定候选人res为0，原理是先遍历一遍，对于遍历到的人i，若候选人res认识i，则将候选人res设为i，
完成一遍遍历后，我们来检测候选人res是否真正是名人，我们如果判断不是名人，则返回-1，如果并没有冲突，返回res
 */
public class FindTheCelebrity {
//    public int findCelebrity(int n) {
//        int result = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (knows(result, i)) result = i;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (result != i && (knows(result, i) || !knows(i, result))) return -1;
//        }
//
//        return result;
//    }
}
