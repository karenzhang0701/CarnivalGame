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

    public void computerTurn(char[][] board, int r, int c) {
        int n = (int) (Math.random() * 5);
        boolean played = false;
        int row = 0;
        int col = 0;

        //block if 2 x's in a row in a diagonal
        if (board[1][1] == 'x') {
            if (board[0][0] == 'x' && board[2][2] == '-') {
                board[2][2] = 'o';
                played = true;
            } else if (board[0][2] == 'x' && board[2][0] == '-') {
                board[2][0] = 'o';
                played = true;
            } else if (board[2][0] == 'x' && board[0][2] == '-') {
                board[0][2] = 'o';
                played = true;
            } else if (board[2][2] == 'x' && board[0][0] == '-') {
                board[0][0] = 'o';
                played = true;
            }
        }

        // block any 2 x's in a row
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++) {
                // check 2 x's in a row horizontally
                if (!played) {
                    if (j < 2 && board[i][j + 1] == 'x' && board[i][j] == 'x') {
                        if (j == 0 && board[i][2] == '-') {
                            board[i][2] = 'o';
                            played = true;
                        } else if (board[i][0] == '-') {
                            board[i][0] = 'o';
                            played = true;
                        }
                    }
                    // check 2 x's in a row vertically
                    else if (board[0][j] == 'x' && board[1][j] == 'x' && board[2][j] == '-') {
                        board[2][j] = 'o';
                        played = true;
                    } else if (board[1][j] == 'x' && board[2][j] == 'x' && board[0][j] == '-') {
                        board[0][j] = 'o';
                        played = true;
                    }
                }
            }
        }

        if (!played) {
            // block left
            if (n == 1 && c - 1 >= 0 && board[r][c - 1] == '-') {
                board[r][c - 1] = 'o';
            }
            // block right
            else if (n == 2 && c + 1 <= 2 && board[r][c + 1] == '-') {
                board[r][c + 1] = 'o';
                played = true;
            }
            // block down
            else if (n == 3 && r - 1 >= 0 && board[r - 1][c] == '-') {
                board[r - 1][c] = 'o';
                played = true;
            }
            // block up
            else if (n == 4 && r + 1 <= 2 && board[r + 1][c] == '-') {
                board[r + 1][c] = 'o';
                played = true;
            } else {
                while (board[row][col] != '-') {
                    row = (int) (Math.random() * 3);
                    col = (int) (Math.random() * 3);
                }
                board[row][col] = 'o';
            }
        }
    }

    public char wonGame(char[][] board) {
        int i;
        for (i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            } // test if 1 row has been filled with x or o

            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i];
            } // column
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        } // diagonal 1
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return board[0][2];
        } // diagonal 2
        return ' ';
    }

    public String start() {
        char[][] board1 = { { 'o', 'o', 'x' }, { 'o', 'x', 'x' }, { '-', 'x', 'x' } };
        System.out.println(wonGame(board1));
        boolean player1 = true;
        int row = 0;
        int col = 0;
        int wins = 0;
        System.out.println("You will play 3 rounds of tic tac toe against the computer." + "\n"
                + "If you win 2 rounds, you win a bracelet. If you win 3 rounds, you win a balloon. A win does not include a tie."
                + "\n");

        for (int i = 1; i < 4; i++) {
            char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
            player1 = true;
            System.out.println("Round " + i);

            while (endOfGame(board) == false) {
                System.out.println(" ");
                drawBoard(board);
                char c;

                if (player1) {
                    System.out.println("Player's turn (x): ");
                    c = 'x';
                    System.out.print("row: ");
                    row = in.nextInt() - 1;
                    System.out.print("column: ");
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
                    computerTurn(board, row, col);
                    player1 = true;
                }

                if (wonGame(board) == 'x') {
                    System.out.println('\n'); // test if player 1 won with x
                    drawBoard(board);
                    System.out.println("You win!");
                    wins++;
                    break;
                } else if (wonGame(board) == 'o') {
                    System.out.println('\n'); // test if player 2 won with o
                    drawBoard(board);
                    System.out.println("Computer wins!");
                    break;
                }
                if (endOfGame(board) == true) {
                    System.out.println('\n');
                    drawBoard(board);
                    System.out.println("It's a tie!");
                    break;
                }
            }
        }
        System.out.println("You won " + wins + " rounds");
        if (wins == 2) {
            super.changePrizeNum("bracelet");
            System.out.println("You win a bracelet!");
            return "bracelet";
        } else if (wins == 3) {
            super.changePrizeNum("balloon");
            System.out.println("You win a balloon!");
            return "balloon";
        }
        return "";
    }
}
