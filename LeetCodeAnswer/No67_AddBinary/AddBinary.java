package No67_AddBinary;

public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) {
				sum += a.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += b.charAt(j--) - '0';
			}

			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		System.out.println(addBinary.addBinary("1", "1110"));
	}

}
