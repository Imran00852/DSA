package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void toh(int n,int t1,int t2,int t3){
        if(n==0){
            return;
        }
        //faith-->toh function knows how to print instructions to move 2 disks from
        //tower1(t1) to tower3 using t2
        toh(n-1,t1,t3,t2);

        //now we'll move one remaining disk from t1 to t2 by our own.
        System.out.println(n+ "[" +t1+ "->"+t2+"]");

        //now using our faith we'll move 2 disks from t3 to t2 and complete the process
        toh(n-1,t3,t2,t1);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int totalDisks=sc.nextInt();
        int tower1=sc.nextInt();
        int tower2=sc.nextInt();
        int tower3=sc.nextInt();

        toh(totalDisks,tower1,tower2,tower3); //tower 1 se tower 2 jaana hai using tower 3 and following the rules

        //rules
        //1) you can move 1 disk at a time
        //2) you cannot put bigger disk on a smaller disk
        //3) you can move the disk that is on top
    }
}
