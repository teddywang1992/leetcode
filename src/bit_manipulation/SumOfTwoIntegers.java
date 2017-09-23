package bit_manipulation;

import java.util.*;

/*
然后我们进一步分析，如果得到上面的第一第二种情况，我们在二进制下来看，不考虑进位的加，0+0=0
0+1=1, 1+0=1， 1+1=0，这就是异或的运算规则，如果只考虑进位的加0+0=0, 0+1=0, 1+0=0, 1+1=1，而这其
实这就是与的运算，而第三步在将两者相加时，我们再递归调用这个算法，终止条件是当进位为0时，我们直接
返回第一步的结果
 */
public class SumOfTwoIntegers {
    public static Map<Integer, List<Integer>> createAdjacencyLists(List<String> employees, List<String> friendships) {
        // IMPLEMENTATION GOES HERE
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (String s : employees) {
            int cur = s.charAt(0) - '0';
            map.put(cur, new ArrayList<>());
        }

        for (String s : friendships) {
            int me = s.charAt(0) - '0';
            int friend = s.charAt(2) - '0';

            map.get(me).add(friend);
            map.get(friend).add(me);
        }

        return map;
    }

    /* START TEST CASES
     * You can add test cases in the three functions below: employeesInputs(),
     * friendshipsInputs(), and expectedOutputs(). Each test case input/expected output
     * should correspond to the same index in the respective lists returned.
     */
    public static List<List<String>> employeesInputs() {
        List<List<String>> inputs = new ArrayList<>();

        inputs.add(Arrays.asList(
                "1,Richard,Engineering",
                "2,Erlich,HR",
                "3,Monica,Business",
                "4,Dinesh,Engineering",
                "6,Carla,Engineering",
                "9,Laurie,Directors"
        ));

        return inputs;
    }

    public static List<List<String>> friendshipsInputs() {
        List<List<String>> inputs = new ArrayList<>();

        inputs.add(Arrays.asList(
                "1,2",
                "1,3",
                "1,6",
                "2,4"
        ));

        return inputs;
    }

    public static List<Map<Integer, List<Integer>>> expectedOutputs() {
        List<Map<Integer, List<Integer>>> expected = new ArrayList<>();

        Map<Integer, List<Integer>> output = new HashMap<>();
        output.put(1, Arrays.asList(2, 3, 6));
        output.put(2, Arrays.asList(1, 4));
        output.put(3, Arrays.asList(1));
        output.put(4, Arrays.asList(2));
        output.put(6, Arrays.asList(1));
        output.put(9, new ArrayList<Integer>());
        expected.add(output);

        return expected;
    }
    // END TEST CASES

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        List<List<String>> employeesInputs = employeesInputs();
        List<List<String>> friendshipsInputs = friendshipsInputs();
        List<Map<Integer, List<Integer>>> expectedOutputs = expectedOutputs();

        for (int i = 0; i < employeesInputs.size(); i++) {
            try {
                Map<Integer, List<Integer>> result = createAdjacencyLists(employeesInputs.get(i), friendshipsInputs.get(i));
                Map<Integer, List<Integer>> expected = expectedOutputs.get(i);

                if (result.equals(expected)) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                }
            } catch (Exception e) {
                System.out.println("Fail");
                System.out.println(e);
            }
        }
    }
}
