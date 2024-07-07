package Matrices;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        int r1=sc.nextInt();
//        int c1=sc.nextInt();
//
//        int one[][]=new int[r1][c1];
//        for(int i=0;i<one.length;i++){
//            for(int j=0;j<one[0].length;j++){
//                one[i][j]=sc.nextInt();
//            }
//        }
//
//        int r2=sc.nextInt();
//        int c2 =sc.nextInt();
//
//        int two[][]=new int[r2][c2];
//        for(int i=0;i<two.length;i++){
//            for(int j=0;j<two[0].length;j++){
//                two[i][j]=sc.nextInt();
//            }
//        }

        int one[][]={{2,4,3},
                     {2,1,5}};

        int two[][]={{1,2,3,5},
                     {6,4,2,1},
                     {3,2,5,4}};

        int prd[][]=new int[2][4];
        for(int i=0;i< prd.length;i++){
            for(int j=0;j<prd[0].length;j++){
                for(int k=0;k<3;k++){
                    prd[i][j]+=one[i][k]*two[k][j];
                }
            }
        }

        for(int i=0;i< prd.length;i++){
            for(int j=0;j<prd[0].length;j++){
                System.out.print(prd[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
