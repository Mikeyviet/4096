// Write a program like the 4096-tile game that prints out new board given an existing board and a 
// direction to shift to. The rules are as follows: 
// • One can only swipe left, right, up, and down 
// • The game is set on a 4 x 4 tile board 
// • Each tile will have the one of the following values: *, 2, 4, 8, 16, 32, 64, 128, 256, 
// 512, 1024, 2048, and 4096 
// • When one swipes in a direction all the tiles will shift in that direction if the tile in front of it is of 
// the same value or it is a space denoted by an *. 
// • If the swiped tiles are the same value, they will combine into one tile of the value of one of the 
// tiles times 2. 
// • Each row and column are independent of each other  
// • A tile can only be combined once in a turn. For example, 2 2 2 2 yields * * 4 4 instead of * * 
// * 8 
// Input from a datafile. The first line of the data files contains a single integer n that indicates the number 
// of data sets that follow.  Each data set will contain a 4x4 4096 board followed by a direction to shift the 
// board. Each tile of the board is separated by a space.  For each board, output to the screen the board 
// after it has been shifted by the requested direction.  Let the user input the file name from the keyboard. 
// Use any appropriate data structure.  Refer to the sample output below. 

import java.io.*;
import java.util.*;

public class Game4096MN{

    public static void main(String[] args) throws IOException{

        int gameCount = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the file name: ");
        String fileName = input.nextLine();
        System.out.println();
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        int n = inputFile.nextInt();
        inputFile.nextLine();
        for(int i = 0; i < n; i++){
            String[][] board = new String[4][4];
            for(int j = 0; j < 4; j++){
                String[] row = inputFile.nextLine().split(" ");
                for(int k = 0; k < 4; k++){
                    board[j][k] = row[k];
                }
            }
            String direction = inputFile.nextLine();
            if(direction.equals("left")){
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 4; k++){
                        if(board[j][k].equals("*")){
                            for(int l = k + 1; l < 4; l++){
                                if(!board[j][l].equals("*")){
                                    board[j][k] = board[j][l];
                                    board[j][l] = "*";
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 3; k++){
                        if(board[j][k].equals(board[j][k + 1]) && !board[j][k].equals("*")){
                            board[j][k] = Integer.toString(Integer.parseInt(board[j][k]) * 2);
                            board[j][k + 1] = "*";
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 4; k++){
                        if(board[j][k].equals("*")){
                            for(int l = k + 1; l < 4; l++){
                                if(!board[j][l].equals("*")){
                                    board[j][k] = board[j][l];
                                    board[j][l] = "*";
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else if(direction.equals("right")){
                for(int j = 0; j < 4; j++){
                    for(int k = 3; k >= 0; k--){
                        if(board[j][k].equals("*")){
                            for(int l = k - 1; l >= 0; l--){
                                if(!board[j][l].equals("*")){
                                    board[j][k] = board[j][l];
                                    board[j][l] = "*";
                                    break;
                                }
                            }
                        }
                    }

                }
                for(int j = 0; j < 4; j++){
                    for(int k = 3; k > 0; k--){
                        if(board[j][k].equals(board[j][k - 1]) && !board[j][k].equals("*")){
                            board[j][k] = Integer.toString(Integer.parseInt(board[j][k]) * 2);
                            board[j][k - 1] = "*";
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    for(int k = 3; k >= 0; k--){
                        if(board[j][k].equals("*")){
                            for(int l = k - 1; l >= 0; l--){
                                if(!board[j][l].equals("*")){
                                    board[j][k] = board[j][l];
                                    board[j][l] = "*";
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else if(direction.equals("up")){
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 4; k++){
                        if(board[k][j].equals("*")){
                            for(int l = k + 1; l < 4; l++){
                                if(!board[l][j].equals("*")){
                                    board[k][j] = board[l][j];
                                    board[l][j] = "*";
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 3; k++){
                        if(board[k][j].equals(board[k + 1][j]) && !board[k][j].equals("*")){
                            board[k][j] = Integer.toString(Integer.parseInt(board[k][j]) * 2);
                            board[k + 1][j] = "*";
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    for(int k = 0; k < 4; k++){
                        if(board[k][j].equals("*")){
                            for(int l = k + 1; l < 4; l++){
                                if(!board[l][j].equals("*")){
                                    board[k][j] = board[l][j];
                                    board[l][j] = "*";
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else if(direction.equals("down")){
                for(int j = 0; j < 4; j++){
                    for(int k = 3; k >= 0; k--){
                        if(board[k][j].equals("*")){
                            for(int l = k - 1; l >= 0; l--){
                                if(!board[l][j].equals("*")){
                                    board[k][j] = board[l][j];
                                    board[l][j] = "*";
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    for(int k = 3; k > 0; k--){
                        if(board[k][j].equals(board[k - 1][j]) && !board[k][j].equals("*")){
                            board[k][j] = Integer.toString(Integer.parseInt(board[k][j]) * 2);
                            board[k - 1][j] = "*";
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    for(int k = 3; k >= 0; k--){
                        if(board[k][j].equals("*")){
                            for(int l = k - 1; l >= 0; l--){
                                if(!board[l][j].equals("*")){
                                    board[k][j] = board[l][j];
                                    board[l][j] = "*";
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        
       
        System.out.println("Board " + gameCount++ + ":\n");

        for(int l = 0; l < 4; l++){
            for(int j = 0; j < 4; j++){
                System.out.print(board[l][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
}