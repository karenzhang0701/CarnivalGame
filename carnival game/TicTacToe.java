import java.util.Scanner;

public class TicTacToe extends GameBooth {
    Scanner in = new Scanner(System.in);

    public TicTacToe() {
        super(2.0, "bracelet", "balloon", "Tic Tac Toe");
    }

    public void drawBoard(char[][] board) {
        int i;
        int j;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j % 2 == 0 && j != 0) {
                    System.out.println(" ");
                }
            }
        }
    }

    public boolean endOfGame(char[][] board) {
        int i;
        int j;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char wonGame(char[][] board) {
        int i;
        int j;
        for (i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            } // test if 1 row has been filled with x or o

            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i];
            } // column

            else if (board[0][i] == board[1][1] && board[1][1] == board[2][2] && board[0][i] != '-') {
                return board[0][i];
            } // diagonal 1

            else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
                return board[0][2];
            } // diagonal 2
        }
        return ' ';
    }

    public String start() {
        boolean player1 = true;
        char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        int row = 0;
        int col = 0;

        while (endOfGame(board) == false) {
            System.out.println(" ");
            drawBoard(board);

            char c;
            if (player1) {
                System.out.println("Player 1's turn (x): ");
                c = 'x';
                System.out.println("row: ");
                row = in.nextInt() - 1;
                System.out.println("column: ");
                col = in.nextInt() - 1;

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("out of bounds, try again!");
                } // test if out of bounds
                else if (board[row][col] != '-') {
                    System.out.println("this spot is taken, try again!");
                } // test if the spot is empty
                else {
                    board[row][col] = c; // add x to the index in array
                    player1 = false; // change to false so player 2 goes
                }
            }

            else {
                System.out.println("Computer's turn (o): ");
                c = 'o';
                while (board[row][col] != '-') {
                    row = (int) (Math.random() * 3);
                    col = (int) (Math.random() * 3);
                }
                board[row][col] = c;
                player1 = true;

                //computer strategy: block left and right, block up or down, block diagonals
            }

            if (endOfGame(board) == true) {
                System.out.println('\n');
                drawBoard(board);
                System.out.println("It's a tie!");
                break;
            }

            if (wonGame(board) == 'x') {
                System.out.println('\n'); // test if player 1 won with x
                drawBoard(board);
                System.out.println ("You win!");
                break;
            } else if (wonGame(board) == 'o') {
                System.out.println('\n'); // test if player 2 won with o
                drawBoard(board);
                System.out.println ("Computer wins!");
                break;
            }
        }
        return "";
    }
}
