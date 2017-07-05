import java.util.Scanner;

public class KnightAndKing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = { // nl
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, // nl
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, // nl
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, // nl
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, // nl
				{ ' ', ' ', 'K', ' ', ' ', ' ', ' ', ' ' }, // nl
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, // nl
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, // nl
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' } // nl
		};
		int i;
		int j;
		System.out.println("Enter Y :: ");
		i = sc.nextInt();
		System.out.println("Enter X :: ");
		j = sc.nextInt();

		boolean isReach = method(arr, i, j);

		if (isReach) {
			System.out.println("Reach king");
		} else {
			System.out.println("Can't reach king");
		}
		sc.close();
	}

	static boolean method(char[][] arr, int i, int j) {
		if ((i - 1) >= 0) {
			if (arr[i - 1][j] != 'x' && arr[i - 1][j] != 'K') {
				if ((i - 2) >= 0) {
					if (arr[i - 2][j] != 'x' && arr[i - 2][j] != 'K') {
						if ((j + 1) < arr[i - 2].length) {
							if (arr[i - 2][j + 1] != 'x') {
								if (arr[i - 2][j + 1] == 'K') {
									return true;
								} else {
									return method(arr, i - 2, j + 1);
								}
							} else {
								return false;
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
