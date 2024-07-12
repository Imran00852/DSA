package Level1.Arrays;

import java.util.Scanner;

public class SubsetsOfAnArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        String[] arr= new String[n];
        for (int i=0;i< arr.length;i++){
            arr[i]=sc.nextLine();
        }

        int limit=(int)Math.pow(2, arr.length);
        for (int i=0;i<limit;i++){


            //make binary and if 0(print dash), if 1(print string)
            String subsets="";
            int temp=i;
            for (int j=arr.length-1;j>=0;j--){
                int r=temp%2;
                temp=temp/2;

                if(r==0){
                    subsets="-"+subsets;
                } else{
                    subsets=arr[j]+subsets;
                }
            }
            System.out.println(subsets);
        }
    }
}
