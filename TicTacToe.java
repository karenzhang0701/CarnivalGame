import java.util.Scanner;

public class TicTacToe extends GameBooth {
    Scanner in = new Scanner(System.in);

    public TicTacToe() {
        //call gamebooth constructor
        super(2.0, "bracelet", "balloon", "Tic Tac Toe");
    }
    
    public void drawBoard(char[][] board) {
        //print board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j % 2 == 0 && j != 0) {
                    System.out.println(" ");
                }
            }
        }
    }

    public boolean endOfGame(char[][] board) {
        //determine if all spots in the board have been filled
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void computerTurn(char[][] board, int r, int c) {
        /* computer's strategy: first block any 2 x's in a row across, down or diagonal
         * otherwise, a random block is made based on the player's last move at board[r][c]
         */
        int n = (int) (Math.random() * 5);
        boolean played = false; //determine if a move has been made
        int row = 0;
        int col = 0;

        //block if there are 2 x's together in a diagonal
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

        // block any 2 x's in a row across or down
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++) {
                // check any 2 x's in a row horizontally, if so then fill the remaining 3rd spot
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
                    // check any 2 x's in a row vertically
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

        // block player's previous move, the computer's move is generated based on a random number that corresponds to a type of block
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
            } 
            // if none of the moves work, a random move is played
            else {
                while (board[row][col] != '-') { //generate random indexes until it finds an empty position
                    row = (int) (Math.random() * 3);
                    col = (int) (Math.random() * 3);
                }
                board[row][col] = 'o';
            }
        }
    }

    public char wonGame(char[][] board) {
        /* check if a player has won the game
        if one player won, returns their symbol (x or o) */

        //loop to check all 3 rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            } // test if a row has been filled with x or o

            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i];
            } // test if a column has been filled with x or o
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        } // check diagonal 1
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return board[0][2];
        } // check diagonal 2
        return ' ';
    }

    //plays game and returns prize won
    @Override
    public String start() {
        boolean player1 = true; //used to determine whose turn it is
        int row = 0;
        int col = 0;
        int wins = 0; //tracks # of rounds user has won
        System.out.println("You will play 3 rounds of tic tac toe against the computer." + "\n"
                + "If you win 2 rounds, you win a bracelet. If you win 3 rounds, you win a balloon. A win does not include a tie."
                + "\n");

        for (int i = 1; i < 4; i++) {
            char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } }; //sets board to empty each round
            player1 = true;
            System.out.println("Round " + i);

            //loop until the board is filled or one player has won
            while (!endOfGame(board)) {
                System.out.println(" ");
                drawBoard(board); //print board
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
                        board[row][col] = c; // add 'x' to the position in array
                        player1 = false; // change to false so computer goes
                    }
                }

                else {
                    System.out.println("Computer's turn (o): ");
                    c = 'o';
                    computerTurn(board, row, col); /* computer's move: calls void method to update values in board 
                    and passes in row and col of player's previous move, used to decide its move */
                    player1 = true;
                }

                if (wonGame(board) == 'x') {
                    System.out.println('\n'); // test if player 1 won with x
                    drawBoard(board);
                    System.out.println("You win!");
                    wins++;
                    break;
                } else if (wonGame(board) == 'o') {
                    System.out.println('\n'); // test if computer won with o
                    drawBoard(board);
                    System.out.println("Computer wins!");
                    break;
                }
                //if neither player won and the board is filled, it's a tie
                if (endOfGame(board)) {
                    System.out.println('\n');
                    drawBoard(board);
                    System.out.println("It's a tie!");
                    break;
                }
            }
        }
        System.out.println("\n" + "Game Over! You won " + wins + " rounds");
        //update booth's prize numbers based on the prize won and return prize
        if (wins == 2) {
            super.changePrizeNum("bracelet");
            System.out.println("You win a bracelet!");
            return "bracelet";
        } else if (wins == 3) {
            super.changePrizeNum("balloon");
            System.out.println("You win a balloon!");
            return "balloon";
        } else {
            System.out.println ("You didn't win anything :(");
        }
        return "";
    }
}
