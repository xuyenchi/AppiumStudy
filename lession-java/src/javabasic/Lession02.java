package javabasic;

public class Lession02 {
	public static void main(String[] args) {
		print_Noel_Tree(9);
		find_Fair(8);
	}

	public static void print_Noel_Tree(int quantity) {
		for (int i = quantity; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

	public static void find_Fair(int target) {
		int[] myArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < myArr.length; i++) {
			for (int j = i + 1; j < myArr.length; j++) {
				if (myArr[i] + myArr[j] == target)
					System.out.printf("[%d,%d]\n", i, j);

			}
		}
	}
}
