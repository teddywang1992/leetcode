package No223_RectangleArea;

public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int areaA = (C - A) * (D - B);
		int areaB = (G - E) * (H - F);
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int bottom = Math.max(F, B);
		int top = Math.min(D, H);

		int overlap = 0;
		if (right > left && top > bottom)
			overlap = (right - left) * (top - bottom);
		return areaA + areaB - overlap;
	}

	public static void main(String[] args) {
		RectangleArea rectangleArea = new RectangleArea();
		System.out.println(rectangleArea.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));

	}

}
