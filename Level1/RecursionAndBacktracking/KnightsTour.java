package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class KnightsTour {
    public static void printKnightsTour(int [][] chess,int row,int col,int move){
        if(row<0 || col<0 || row>=chess.length || col>=chess.length || chess[row][col]>0){
            return;
        } else if (move==chess.length*chess.length) {
            chess[row][col]=move;
            displayChess(chess);
            chess[row][col]=0;
            return;
        }
        chess[row][col]=move;
        printKnightsTour(chess,row-2,col+1,move+1);
        printKnightsTour(chess,row-1,col+2,move+1);
        printKnightsTour(chess,row+1,col+2,move+1);
        printKnightsTour(chess,row+2,col+1,move+1);
        printKnightsTour(chess,row+2,col-1,move+1);
        printKnightsTour(chess,row+1,col-2,move+1);
        printKnightsTour(chess,row-1,col-2,move+1);
        printKnightsTour(chess,row-2,col-1,move+1);
        chess[row][col]=0;
    }

    public static void displayChess(int chess[][]){
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess[0].length;j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[][] chess=new int[n][n];
        printKnightsTour(chess,1,3,1);
    }

}
