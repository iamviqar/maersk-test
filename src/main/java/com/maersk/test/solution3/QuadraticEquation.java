package com.maersk.test.solution3;

public class QuadraticEquation {
	public static Roots findRoots(double a, double b, double c) {
		double root1, root2;
		double determinant = b * b - 4 * a * c;
		// condition for real and different roots
		if (determinant > 0) {
			root1 = (-b + Math.sqrt(determinant)) / (2 * a);
			root2 = (-b - Math.sqrt(determinant)) / (2 * a);
		}
		// Condition for real and equal roots
		else if (determinant == 0) {
			root1 = root2 = -b / (2 * a);
		} // If roots are not real
		else {
			double realPart = -b / (2 * a);
			double imaginaryPart = Math.sqrt(-determinant) / (2 * a);
			root1 = realPart + imaginaryPart;
			root2 = realPart - imaginaryPart;
		}

		return new Roots(root1, root2);
	}

	public static void main(String[] args) {
		Roots roots = findRoots(2, 10, 8);
		System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
	}

}
