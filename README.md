Tic Tac Toe - Java Console Game

Overview

This is a simple Tic Tac Toe game implemented in Java. It is a two-player game played on a 3x3 board, where players take turns marking spaces with 'X' or 'O'. The game includes a fairness mechanism: if the board is full, the last two moves are removed to ensure continuous gameplay.

Features

Turn-based gameplay: Players take turns playing as 'X' and 'O'.

Board validation: Prevents players from placing marks on already occupied cells.

Winner Detection: Checks for horizontal, vertical, and diagonal wins.

Automatic Move Removal: If the board is full, the last two moves are removed to allow continued play.

Replay Option: Players can choose to play again after a game ends.

How to Play

The game starts with an empty 3x3 board.

Players take turns entering a row and column (0-2) to place their mark ('X' or 'O').

The game checks for a winner after each move.

If the board is full and no winner is found, the last two moves are removed to continue playing.

The game continues until a player wins or the players choose to stop.

Installation and Execution

Prerequisites

Java JDK 8 or higher

Steps to Run

Download the source code

Compile the program:

javac Tic_Tac_Toe.java

Run the game:

java Tic_Tac_Toe

Code Explanation

Board Management: A char[][] array represents the board.

Stack Usage: A Stack<int[]> stores previous moves for undoing them if necessary.

Gameplay Loop: Players input moves in a loop, and the board is updated dynamically.

Checking for Win: The checkWinner() function verifies if a player has won.

Removing Moves: The removeMovesUntilPlayable() function removes two moves if the board is full.

Future Enhancements

Implement a GUI using Java Swing for a graphical interface.

Add AI support for single-player mode.

Create a Web-based version using ReactJS & Spring Boot.

Author

Prajakta Dhere

License

This project is open-source and available for personal and educational use.
