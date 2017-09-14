package dataStructure;

import java.util.*;

public class InsertDeleteGetRandomO1 {
}
/*be careful when put key value pair to hashmap.
because when we want to delete node in list.
we need to get the list.size() - 1, so when we put the key value pair we need to put list.size() - 1;
*/

class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> hashmap;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        hashmap = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hashmap.containsKey(val)) {
            return false;
        }

        list.add(val);
        hashmap.put(val, list.size() - 1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hashmap.containsKey(val)) {
            return false;
        }

        int value = hashmap.get(val);
        if (value < list.size() - 1) {
            int lastOne = list.get(list.size() - 1);
            list.set(value, lastOne);
            hashmap.put(lastOne, value);
        }

        hashmap.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */