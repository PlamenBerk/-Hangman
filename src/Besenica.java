import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Besenica {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] countries = { "Dania", "Russia", "Canada" };

		boolean isVictory = true;

		// for loop for game
		for (;;) {
			//emptyGalloping for new game
			char[][] emptyArr = { // nl
					{ ' ', '_', '_', '_', '_' }, // nl
					{ ' ', '|', ' ', ' ', '|' }, // nl
					{ ' ', ' ', ' ', ' ', '|' }, // nl
					{ ' ', ' ', ' ', ' ', '|' }, // nl
					{ ' ', ' ', ' ', ' ', '|' } // nl
			};
			// get random country
			String random = (countries[new Random().nextInt(countries.length)]);
			String country = random.toLowerCase();

			int mistakes = 0;
			int left = 6;

			// temp char array for true symbols
			char[] temp = new char[country.length()];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = '*';
			}
			System.out.println(Arrays.toString(temp));

			while (true) {
				int fromIndex = 0;
				System.out.println("Enter letter :: ");
				char ch = sc.next().charAt(0);

				// check if char contains in word and fill in temp
				if (country.indexOf(ch) != -1) {
					while (fromIndex != -1) {
						fromIndex = country.indexOf(ch, fromIndex);
						if (country.indexOf(ch, fromIndex) != -1 && fromIndex != -1) {
							temp[fromIndex] = ch;
							fromIndex += 1;
						}
					}
					printWord(temp);
				} else {
					mistakes++;
					left--;
					printArr(emptyArr, mistakes);
					System.out.println(left + " chances left!");
					printWord(temp);
				}

				// check if all is filled
				boolean isFill = chechFill(temp);

				// if all is filled... win and continue with for(;;)
				if (isFill) {
					isVictory = true;
					break;
				}

				// if chances = 0
				if (left == 0) {
					isVictory = false;
					break;
				}
			}

			if (!isVictory) {
				System.out.println("!!! GAME OVER !!!");
				System.out.println();
				System.out.println("Play again? (y/n)");
				char playAgain = sc.next().charAt(0);
				if (playAgain == 'y') {
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					continue;
				} else {
					break;
				}
			} else {
				System.out.println("!!! YOU WIN !!!");
				System.out.println();
				System.out.println("Play again? (y/n)");
				char playAgain = sc.next().charAt(0);
				if (playAgain == 'y') {
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					continue;
				} else {
					break;
				}
			}
		}
		sc.close();
	}

	private static boolean chechFill(char[] temp) {
		boolean isFill = true;
		for (int j = 0; j < temp.length; j++) {
			if (temp[j] == '*') {
				isFill = false;
			}
		}
		return isFill;
	}

	static void printArr(char[][] emptyArr, int mistakes) {
		if (mistakes == 1) {
			emptyArr[2][1] = 'O';
			printGalloping(emptyArr);
		} else if (mistakes == 2) {
			emptyArr[2][1] = 'O';
			emptyArr[3][1] = '|';
			printGalloping(emptyArr);
		} else if (mistakes == 3) {
			emptyArr[2][1] = 'O';
			emptyArr[3][1] = '|';
			emptyArr[3][0] = '/';
			printGalloping(emptyArr);
		} else if (mistakes == 4) {
			emptyArr[2][1] = 'O';
			emptyArr[3][1] = '|';
			emptyArr[3][0] = '/';
			emptyArr[3][2] = '\\';
			printGalloping(emptyArr);
		} else if (mistakes == 5) {
			emptyArr[2][1] = 'O';
			emptyArr[3][1] = '|';
			emptyArr[3][0] = '/';
			emptyArr[3][2] = '\\';
			emptyArr[4][0] = '/';
			printGalloping(emptyArr);
		} else if (mistakes == 6) {
			emptyArr[2][1] = 'O';
			emptyArr[3][1] = '|';
			emptyArr[3][0] = '/';
			emptyArr[3][2] = '\\';
			emptyArr[4][0] = '/';
			emptyArr[4][2] = '\\';
			printGalloping(emptyArr);
		}
	}

	private static void printGalloping(char[][] emptyArr) {
		for (int i = 0; i < emptyArr.length; i++) {
			for (int j = 0; j < emptyArr[i].length; j++) {
				System.out.print(emptyArr[i][j]);
			}
			System.out.println();
		}
	}

	static void printWord(char[] temp) {
		System.out.println(Arrays.toString(temp));
	}

}
