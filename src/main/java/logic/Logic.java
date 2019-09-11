package logic;

import java.util.Arrays;

public class Logic {

	private static char turn = 'X';
	private static int countTurn;
	public static final int WIN  = 1;
	public static final int DRAW = 0;

	private static final char[] F = {
			 ' ', ' ', ' ',
			 ' ', ' ', ' ',
			 ' ', ' ', ' '
		 };
	private static boolean searchWinnerOnField(char[] validationArea, char inputTern) {
		for (int i = 0;i < validationArea.length;i += 2 ) {
			if (inputTern == validationArea[i] && inputTern == validationArea[i+1]) {
				return true;
			}
		}
		return false;
	}
	private static boolean checkWin(int key) {
		switch (key) {
			case 8:
				char[] c8 = {F[6],F[7],F[5],F[2],F[4],F[0]};
				return searchWinnerOnField(c8, F[key]);
			case 7:
				char[] c7 = {F[1],F[4],F[6],F[8]};
				return searchWinnerOnField(c7, F[key]);
			case 6:
				char[] c6 = {F[7],F[8],F[4],F[2],F[0],F[3]};
				return searchWinnerOnField(c6, F[key]);
			case 5:
				char[] c5 = {F[2],F[8],F[3],F[4]};
				return searchWinnerOnField(c5, F[key]);
			case 4:
				char[] c4 = {F[1],F[7],F[5],F[3],F[6],F[2],F[0],F[8]};
				return searchWinnerOnField(c4, F[key]);
			case 3:
				char[] c3 = {F[0],F[6],F[4],F[5]};
				return searchWinnerOnField(c3, F[key]);
			case 2:
				char[] c2 = {F[5],F[8],F[4],F[6],F[0],F[1]};
				return searchWinnerOnField(c2, F[key]);
			case 1:
				char[] c1 = {F[4],F[7],F[0],F[2]};
				return searchWinnerOnField(c1, F[key]);
			case 0:
				char[] c0 = {F[1],F[2],F[3],F[6],F[4],F[8]};
				return searchWinnerOnField(c0, F[key]);
		}
		return false;
	}
	public static int tern(int i) {
		F[i] = turn;
		if (countTurn == 8) {
            if (checkWin(i)) {
                return WIN;
            }
			return DRAW;
		}
		countTurn++;
		if (checkWin(i)) return WIN;
		if (turn == 'X') turn = 'O';
		else turn = 'X';
		return -1;
	}
	public static void restart() {
		countTurn = 0;
		Arrays.fill(F, ' ');
		turn = 'X';
	}
	public static char getTurn() {
		return turn;
	}
}
