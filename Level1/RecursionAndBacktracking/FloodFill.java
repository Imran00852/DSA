package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class FloodFill {
    public static void getFloodFillPaths(int row, int col,int maze[][],String ans,boolean visited[][]){
        if(row<0 || col<0 || row==maze.length || col==maze[0].length || maze[row][col]==1 || visited[row][col]==true){
            return;
        }

        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.println(ans);
            return;
        }



        visited[row][col]=true;
        getFloodFillPaths(row-1,col,maze,ans+"t",visited);
        getFloodFillPaths(row,col-1,maze,ans+"l",visited);
        getFloodFillPaths(row+1,col,maze,ans+"d",visited);
        getFloodFillPaths(row,col+1,maze,ans+"r",visited);
        visited[row][col]=false;
    }
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int m=sc.nextInt();
//
//        int [][] maze=new int[n][m];
//        for(int i=0;i< maze.length;i++){
//            for(int j=0;j<maze[0].length;j++){
//                maze[i][j]=sc.nextInt();
//            }
//        }

        int maze[][]={{0,1,0,0,0,0,0},
                      {0,1,0,1,1,1,0},
                      {0,0,0,0,0,0,0},
                      {1,0,1,1,0,1,1},
                      {1,0,1,1,0,1,1},
                      {1,0,0,0,0,0,0}};
        boolean visited[][]= new boolean[6][7];

        getFloodFillPaths(0,0,maze,"",visited);
    }

    //input
   /* 0100000
      0101110
      0000000
      1011011
      1011011
      1000000
   */
}
