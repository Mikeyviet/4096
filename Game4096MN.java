
/*********************************************************************
 * @author Michael Nguyen
 * @course COSC 2436
 * @Program Set 4
 * @Problem 1
 * @name Game4096MN.java
 * @description This program is a game of 4096. The program will ask for 
 *      filename to open and read the game board. The program will then
 *      read in the board that also has the direction of the move. The
 *      program will then move the tiles in the direction specified and
 *      add the tiles together if they are the same. The program will 
 *      then print out the new board.
 *********************************************************************/

import java.io.*;
import java.util.*;

public class Game4096MN {

    public static void main(String[] args) throws IOException {

        // variable to hold the number of the board for printing label
        int gameCount = 1;

        // create a scanner to read in the file
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the file name: ");
        String fileName = input.nextLine();
        System.out.println();
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        int n = inputFile.nextInt();
        inputFile.nextLine();

        // create a 2D array to hold the board
        for (int i = 0; i < n; i++) {
            String[][] board = new String[4][4];
            for (int j = 0; j < 4; j++) {
                String[] row = inputFile.nextLine().split(" ");
                for (int k = 0; k < 4; k++) {
                    board[j][k] = row[k];

                }// end for(int k = 0; k < 4; k++)

            }// end for(int j = 0; j < 4; j++)

            // read in the direction of the move
            String direction = inputFile.nextLine();
            // shift the tiles in the direction specified and add the tiles
            if (direction.equals("left")) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (board[j][k].equals("*")) {
                            for (int l = k + 1; l < 4; l++) {
                                if (!board[j][l].equals("*")) {
                                    board[j][k] = board[j][l];
                                    board[j][l] = "*";
                                    break;
                                }// end if(!board[j][l].equals("*"))
                            }// end for(int l = k + 1; l < 4; l++)
                        }// end if(board[j][k].equals("*"))
                    }// end for(int k = 0; k < 4; k++)
                }//end for(int j = 0; j < 4; j++)
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 3; k++) {
                        // add the tiles together if they are the same
                        if (board[j][k].equals(board[j][k + 1]) && !board[j][k].equals("*")) {
                            board[j][k] = Integer.toString(Integer.parseInt(board[j][k]) * 2);
                            board[j][k + 1] = "*";
                        }// end if(board[j][k].equals(board[j][k + 1]) && !board[j][k].equals("*"))
                    }// end for(int k = 0; k < 3; k++)
                }// end for(int j = 0; j < 4; j++)
                for (int j = 0; j < 4; j++) {
                    // shift the tiles again after adding the tiles together
                    for (int k = 0; k < 4; k++) {
                        if (board[j][k].equals("*")) {
                            for (int l = k + 1; l < 4; l++) {
                                if (!board[j][l].equals("*")) {
                                    board[j][k] = board[j][l];
                                    board[j][l] = "*";
                                    break;
                                }// end if(!board[j][l].equals("*"))
                            }// end for(int l = k + 1; l < 4; l++)
                        }// end if(board[j][k].equals("*"))
                    }// end for(int k = 0; k < 4; k++)
                }// end for(int j = 0; j < 4; j++)
            } else if (direction.equals("right")) {
                // shift the tiles in the direction specified and add the tiles
                for (int j = 0; j < 4; j++) {
                    for (int k = 3; k >= 0; k--) {
                        if (board[j][k].equals("*")) {
                            for (int l = k - 1; l >= 0; l--) {
                                if (!board[j][l].equals("*")) {
                                    board[j][k] = board[j][l];
                                    board[j][l] = "*";
                                    break;
                                }// end if(!board[j][l].equals("*"))
                            }// end for(int l = k - 1; l >= 0; l--)
                        }// end if(board[j][k].equals("*"))
                    }// end for(int k = 3; k >= 0; k--)
                }// end for(int j = 0; j < 4; j++)
                for (int j = 0; j < 4; j++) {
                    // add the tiles together if they are the same
                    for (int k = 3; k > 0; k--) {
                        if (board[j][k].equals(board[j][k - 1]) && !board[j][k].equals("*")) {
                            board[j][k] = Integer.toString(Integer.parseInt(board[j][k]) * 2);
                            board[j][k - 1] = "*";
                        }// end if(board[j][k].equals(board[j][k - 1]) && !board[j][k].equals("*"))
                    }// end for(int k = 3; k > 0; k--)
                }// end for(int j = 0; j < 4; j++)
                for (int j = 0; j < 4; j++) {
                    // shift the tiles again after adding the tiles together
                    for (int k = 3; k >= 0; k--) {
                        if (board[j][k].equals("*")) {
                            for (int l = k - 1; l >= 0; l--) {
                                if (!board[j][l].equals("*")) {
                                    board[j][k] = board[j][l];
                                    board[j][l] = "*";
                                    break;
                                }// end if(!board[j][l].equals("*"))
                            }// end for(int l = k - 1; l >= 0; l--)
                        }// end if(board[j][k].equals("*"))
                    }// end for(int k = 3; k >= 0; k--)
                }// end for(int j = 0; j < 4; j++)
            } else if (direction.equals("up")) {
                // shift the tiles in the direction specified and add the tiles
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (board[k][j].equals("*")) {
                            for (int l = k + 1; l < 4; l++) {
                                if (!board[l][j].equals("*")) {
                                    board[k][j] = board[l][j];
                                    board[l][j] = "*";
                                    break;
                                }// end if(!board[l][j].equals("*"))
                            }//end for(int l = k + 1; l < 4; l++)
                        }// end if(board[k][j].equals("*"))
                    }// end for(int k = 0; k < 4; k++)
                }// end for(int j = 0; j < 4; j++)
                for (int j = 0; j < 4; j++) {
                    // add the tiles together if they are the same
                    for (int k = 0; k < 3; k++) {
                        if (board[k][j].equals(board[k + 1][j]) && !board[k][j].equals("*")) {
                            board[k][j] = Integer.toString(Integer.parseInt(board[k][j]) * 2);
                            board[k + 1][j] = "*";
                        }// end if(board[k][j].equals(board[k + 1][j]) && !board[k][j].equals("*"))
                    }// end for(int k = 0; k < 3; k++)
                }// end for(int j = 0; j < 4; j++)
                for (int j = 0; j < 4; j++) {
                    // shift the tiles again after adding the tiles together
                    for (int k = 0; k < 4; k++) {
                        if (board[k][j].equals("*")) {
                            for (int l = k + 1; l < 4; l++) {
                                if (!board[l][j].equals("*")) {
                                    board[k][j] = board[l][j];
                                    board[l][j] = "*";
                                    break;
                                }// end if(!board[l][j].equals("*"))
                            }// end for(int l = k + 1; l < 4; l++)
                        }// end if(board[k][j].equals("*"))
                    }// end for(int k = 0; k < 4; k++)
                }// end for(int j = 0; j < 4; j++)
            } else if (direction.equals("down")) {
                // shift the tiles in the direction specified and add the tiles
                for (int j = 0; j < 4; j++) {
                    for (int k = 3; k >= 0; k--) {
                        if (board[k][j].equals("*")) {
                            for (int l = k - 1; l >= 0; l--) {
                                if (!board[l][j].equals("*")) {
                                    board[k][j] = board[l][j];
                                    board[l][j] = "*";
                                    break;
                                }// end if(!board[l][j].equals("*"))
                            }// end for(int l = k - 1; l >= 0; l--)
                        }// end if(board[k][j].equals("*"))
                    }// end for(int k = 3; k >= 0; k--)
                }// end for(int j = 0; j < 4; j++)
                for (int j = 0; j < 4; j++) {
                    // add the tiles together if they are the same
                    for (int k = 3; k > 0; k--) {
                        if (board[k][j].equals(board[k - 1][j]) && !board[k][j].equals("*")) {
                            board[k][j] = Integer.toString(Integer.parseInt(board[k][j]) * 2);
                            board[k - 1][j] = "*";
                        }// end if(board[k][j].equals(board[k - 1][j]) && !board[k][j].equals("*"))
                    }// end for(int k = 3; k > 0; k--)
                }// end for(int j = 0; j < 4; j++)
                for (int j = 0; j < 4; j++) {
                    // shift the tiles again after adding the tiles together
                    for (int k = 3; k >= 0; k--) {
                        if (board[k][j].equals("*")) {
                            for (int l = k - 1; l >= 0; l--) {
                                if (!board[l][j].equals("*")) {
                                    board[k][j] = board[l][j];
                                    board[l][j] = "*";
                                    break;
                                }// end if(!board[l][j].equals("*"))
                            }// end for(int l = k - 1; l >= 0; l--)
                        }// end if(board[k][j].equals("*"))
                    }// end for(int k = 3; k >= 0; k--)
                }// end for(int j = 0; j < 4; j++)

            }// end if(direction.equals("left"))
            
            // print out board number
            System.out.println("Board " + gameCount++ + ":\n");

            // print out the board
            for (int l = 0; l < 4; l++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(board[l][j] + " ");
                }// end for(int j = 0; j < 4; j++)
                System.out.println();
            }// end for(int l = 0; l < 4; l++)
            System.out.println();
        }// end for(int i = 0; i < n; i++)

    }// end public static void main(String[] args)
    
}// end public class Game4096MN