package Matrices;

import java.util.Scanner;

import static Arrays.RotateAnArray.reverse;

public class ShellRotate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int arr[][]=new int[n][m];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int s=sc.nextInt();
        int r=sc.nextInt();

        rotateShell(arr,s,r);
        Display(arr);
    }
    public static void rotateShell(int arr[][],int s, int r){
        int oned[]=shellToOned(arr,s);
        Rotate(oned,r);
        onedToShell(arr,s,oned);
    }
    public static void onedToShell(int arr[][],int s,int oned[]){
        int minr=s-1;
        int minc=s-1;
        int maxr= arr.length-s;
        int maxc=arr[0].length-s;

        //lw
        int idx=0;
        for(int i=minr,j=minc;i<=maxr;i++){
            arr[i][j]=oned[idx];
            idx++;
        }
        //bw
        for(int i=maxr,j=minc+1;j<=maxc;j++){
            arr[i][j]=oned[idx];
            idx++;
        }
        //rw
        for(int i=maxr-1,j=maxc;i>=minr;i--){
            arr[i][j]=oned[idx];
            idx++;
        }
        //tw
        for(int i=minr,j=maxc-1;j>=minc+1;j--){
            arr[i][j]=oned[idx];
            idx++;
        }
    }
    public static int[] shellToOned(int arr[][],int s){
        int minr=s-1;
        int minc=s-1;
        int maxr= arr.length-s;
        int maxc=arr[0].length-s;

        int size=/*lw*/(maxr-minr+1) +/*bw*/(maxc-minc+1)+/*rw*/(maxr-minr+1)+/*tw*/(maxc-minc+1) - 4;

        int oned[]=new int[size];

        //lw
        int idx=0;
        for(int i=minr,j=minc;i<=maxr;i++){
            oned[idx]=arr[i][j];
            idx++;
        }
        //bw
        for(int i=maxr,j=minc+1;j<=maxc;j++){
            oned[idx]=arr[i][j];
            idx++;
        }
        //rw
        for(int i=maxr-1,j=maxc;i>=minr;i--){
            oned[idx]=arr[i][j];
            idx++;
        }
        //tw
        for(int i=minr,j=maxc-1;j>=minc+1;j--){
            oned[idx]=arr[i][j];
            idx++;
        }

        return oned;
    }
    public static void Rotate(int arr[],int k){
        k=k%arr.length;
        if(k<0){
            k=k+arr.length;
        }
        reverse(arr,0,arr.length-k-1);
        reverse(arr,arr.length-k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }

    public static void Display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
