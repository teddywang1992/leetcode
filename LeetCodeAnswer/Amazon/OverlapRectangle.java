package Amazon;

public class OverlapRectangle {
	// Overlap Rectangle
	// Rect 1: top-left(A, B), bottom-right(C, D)
	// Rect 2: top-left(E, F), bottom-right(G, H)
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int innerL = Math.max(A, E);
		int innerR = Math.max(innerL, Math.min(C, G));
		int innerT = Math.max(B, F);
		int innerB = Math.max(innerT, Math.min(D, H));
		return (C - A) * (B - D) - (innerR - innerL) * (innerT - innerB)
				+ (G - E) * (F - H);
	}

	// 给两个长方形的topLeft和bottomRight坐标, 判断这两个长方形是否重叠
	//
	// Rectangle Overlap。
	// 这题和leetcode 算相交面积的区别：它帮你定义好两个类，一个叫Point，一个叫Rectangle，
	// Rectangle包括左上右下两个Point, Point包括x, y的值， 这种细节并不影响程序，总之一句判断直接通过了全部20多个case.
	public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
		// If one rectangle is on left side of other
		if (l1.x > r2.x || l2.x > r1.x)
			return false;

		// If one rectangle is above other
		if (l1.y < r2.y || l2.y < r1.y)
			return false;

		return true;
	}
}
