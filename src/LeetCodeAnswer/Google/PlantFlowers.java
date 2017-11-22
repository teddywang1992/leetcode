package LeetCodeAnswer.Google;

import java.util.TreeSet;

public class PlantFlowers {
	public int findDay(int[] P, int K) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < P.length; i++) {
			set.add(P[i]);
			Integer lower = set.lower(P[i]);
			if (lower == null) lower = 0;
			if (P[i] - lower  - 1 == K) return i + 1;
			Integer higher = set.higher(P[i]);
			if (higher == null) higher = P.length + 1;
			if (higher - P[i] - 1== K) return i + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		PlantFlowers plantFlowers = new PlantFlowers();
		int[] p = new int[]{2,1};
		System.out.println(plantFlowers.findDay(p, 1));
	}
}
