package pdc;

import java.math.BigInteger;

public class Solution {
	
	public String decode(String key, String message) {
		String xString = "26362928081002303087713271852220986810381868672656104434480496829300700800354435353790711445136516282";
		char[] xChar = xString.toCharArray();
		char[] yChar = key.toCharArray();
		
		char[] messageChar = message.toCharArray();

		int xLength = xChar.length;
		int yLength = yChar.length;
		int[] z = new int[yLength];
		
		for (int j = 0; j < yLength; j++) {
			z[j] = (Character.getNumericValue(xChar[j]) + Character.getNumericValue(yChar[j])) % 10; 
		}
		
		for (int i = 1; i < xLength - yLength + 1; i++) {
			for (int j = 0; j < yLength; j++) {
				z[j] = (Character.getNumericValue(xChar[i + j]) + z[j]) % 10;
			}
		}
		BigInteger k = BigInteger.valueOf(0);
		for (int i = 0; i < yLength; i++) {
			k = k.multiply(BigInteger.valueOf(10));
			k = k.add(BigInteger.valueOf(z[i]));
		}

		k = k.mod(BigInteger.valueOf(25));
		int k_final = 1 + k.intValue();
		
		for (int i = 0; i < messageChar.length; i++) {
			char c = (char) (messageChar[i] + k_final);
			if (c > 'Z') c = (char) (c - 26);
			messageChar[i] = c;
		}
		
		return spiral(messageChar);
	}
	
	private String spiral(char[] IChar) {
		int triangleLength = (int) Math.sqrt((2 * IChar.length - 1));
		char[][] result = new char[triangleLength][triangleLength];
		int i = 0;
		while (i < IChar.length) {
			int side = findSide(i, triangleLength);
			if (side % 3 == 1) {
				for (int j = 0; j < triangleLength - side + 1; j++) {
					result[2 * side /3 + j][side / 3] = IChar[i++];
				}
			} else if (side % 3 == 2) {
				for (int j = 0; j < triangleLength - side + 1; j++) {
					result[triangleLength - 1 - side / 3][side / 3 + 1 + j] = IChar[i++];
				}
			} else {
				for (int j = 0; j < triangleLength - side + 1; j++) {
					result[triangleLength - side / 3 - 1 - j][triangleLength - 2 * side / 3 - j] = IChar[i++];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < triangleLength; k++) {
			for (int j = 0; j < k + 1; j++) {
				sb.append(result[k][j]);
			}
		}
		return sb.toString();
	}
	private int findSide(int pos, int length) {
		int count = 0;
		while (pos >= length - count) {
			pos = pos - (length - count);
			count++;
		}
		return count + 1;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.decode("4024123659485622445001958636275419709073611535463684596712464059093821","JGNNFTNQYQ"));
//		System.out.println(solution.spiral("HELLDRLOWO".toCharArray()));
	}
}
