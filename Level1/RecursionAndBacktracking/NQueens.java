package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class NQueens {
    public static boolean isItTheRightPlaceForQueen(int chess[][],int row, int col){
        //vertical
        for(int i=row-1,j=col;i>=0;i--){
            if(chess[i][j]==1){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(chess[i][j]==1){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0&&j<chess.length;i--,j++){
            if(chess[i][j]==1){
                return false;
            }
        }

        return true;
    }
    public static void printNQueen(int chess[][],int row,String ans){
        if(row== chess.length){
            System.out.println(ans);
            return;
        }
        for(int col=0;col<chess.length;col++){
            if(isItTheRightPlaceForQueen(chess,row,col)==true){
                chess[row][col]=1;
                printNQueen(chess,row+1,ans+row+col+" ");
                chess[row][col]=0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[][] chess=new int[n][n];
        printNQueen(chess,0,"");
    }
}
