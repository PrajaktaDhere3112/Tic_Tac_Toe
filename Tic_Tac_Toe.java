package Tic_Tac_Toe;

import java.util.Scanner;
import java.util.Stack;

public class Tic_Tac_Toe {

	private static int size = 3;
	private static char[][] board = new char[size][size];
	private static boolean PlayerX;
	private static Stack<int[]> moves = new Stack<>();

	public static void printBoard() {
		System.out.println("-----------------");
		for (int i = 0; i < size; i++) {
			System.out.print("| ");
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println("\n-----------------");
		}
	}

	public static boolean isValidMove(int row, int col) {
		return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ';
	}

	public static void resetBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = ' ';
			}
		}
		PlayerX = true;
		moves.clear();
	}

	public static boolean checkWinner() {

		char player = PlayerX ? 'X' : 'O';

		for (int i = 0; i < size; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
				return true;
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
				return true;
		}
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
			return true;
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
			return true;

		return false;
	}

	public static void removeLastMoveUntilPlayble() {

		while (moves.size() < 2) {

			return;

		}
		int[] lastMove = moves.pop();
		board[lastMove[0]][lastMove[1]] = ' ';

		int[] secLastMove = moves.pop();
		board[secLastMove[0]][secLastMove[1]] = ' ';

		if (checkWinner()) {

			printBoard();
			System.out.println("🎉 Player " + (PlayerX ? "X" : "O") + " wins! 🎉");
			System.exit(0);

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			resetBoard();
			boolean gameover = false;

			while (!gameover) {
				printBoard();
				int row, col;

				while (true) {
					System.out.println("Player " + (PlayerX ? "X" : "O") + "'s turn. Enter row and column (0-2): ");
					row = sc.nextInt();
					col = sc.nextInt();

					if (isValidMove(row, col)) {
						break;
					} else {
						System.out.println("Invalid move! Try again.");
					}
				}

				board[row][col] = PlayerX ? 'X' : 'O';
				moves.push(new int[] { row, col });

				if (checkWinner()) {
					printBoard();
					System.out.println("🎉 Player " + (PlayerX ? "X" : "O") + " wins! 🎉");
					gameover = true;
					break;
				}

				if (moves.size() == size * size) {
					System.out.println("No winner yet. Removing the last move and retrying.");
					removeLastMoveUntilPlayble();
				}

				PlayerX = !PlayerX;
			}

			System.out.println("Play again? (yes/no):");
			if (!sc.next().equalsIgnoreCase("yes")) {
				System.out.println("Thanks for playing! 🎮");
				break;
			}
		}
		sc.close();
	}
}
