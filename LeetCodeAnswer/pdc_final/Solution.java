package pdc_final;

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
			k = k.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(z[i]));
		}
		
		int k_final = 1 + k.mod(BigInteger.valueOf(25)).intValue();
		for (int i = 0; i < messageChar.length; i++) {
			char c = (char) (messageChar[i] - k_final);
			messageChar[i] = (char) (c < 'A' ? c + 26 : c);
		}
		
		int triangleLength = (int) Math.sqrt((2 * messageChar.length - 1));
		char[][] matrix = new char[triangleLength][triangleLength];
		int index = 0;
		for (int i = 0; i < triangleLength; i++) {
			for (int j = 0; j < i + 1; j++) {
				matrix[i][j] = messageChar[index++];
			}
		}
		StringBuilder sb = new StringBuilder();
		int index_x = 0, index_y = 0;
		int count = 0;
		int ILength = messageChar.length;
		int side = 1;
		while (count < ILength) {
			if (side % 3 == 1) {
				for (int i = 0; i < triangleLength - side + 1; i++) {
					sb.append(matrix[index_y++][index_x]);
					count++;
					if (i == triangleLength - side) {
						index_y--;
						index_x++;
					}
				}
			} else if (side % 3 == 2) {
				for (int i = 0; i < triangleLength - side + 1; i++) {
					sb.append(matrix[index_y][index_x++]);
					count++;
					if (i == triangleLength - side) {
						index_x -= 2;
						index_y--;
					}
				}
			} else {
				for (int i = 0; i < triangleLength - side + 1; i++) {
					sb.append(matrix[index_y--][index_x--]);
					count++;
					if (i == triangleLength - side) {
						index_x++;
						index_y += 2;
					}
				}
			}
			side++;
		}

		return sb.toString();
	}
	
//	private String spiral(char[] messageChar) {
//		int triangleLength = (int) Math.sqrt((2 * messageChar.length - 1));
//		char[][] matrix = new char[triangleLength][triangleLength];
//		int index = 0;
//		for (int i = 0; i < triangleLength; i++) {
//			for (int j = 0; j < i + 1; j++) {
//				matrix[i][j] = messageChar[index++];
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		int index_x = 0, index_y = 0;
//		int count = 0;
//		int ILength = messageChar.length;
//		int side = 1;
//		while (count < ILength) {
//			if (side % 3 == 1) {
//				for (int i = 0; i < triangleLength - side + 1; i++) {
//					sb.append(matrix[index_y++][index_x]);
//					count++;
//					if (i == triangleLength - side) {
//						index_y--;
//						index_x++;
//					}
//				}
//			} else if (side % 3 == 2) {
//				for (int i = 0; i < triangleLength - side + 1; i++) {
//					sb.append(matrix[index_y][index_x++]);
//					count++;
//					if (i == triangleLength - side) {
//						index_x -= 2;
//						index_y--;
//					}
//				}
//			} else {
//				for (int i = 0; i < triangleLength - side + 1; i++) {
//					sb.append(matrix[index_y--][index_x--]);
//					count++;
//					if (i == triangleLength - side) {
//						index_x++;
//						index_y += 2;
//					}
//				}
//			}
//			side++;
//		}
//
//		return sb.toString();
//	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.decode("4024123659485622445001958636275419709073611535463684596712464059093821","JGNNFTNQYQ"));
	}
}