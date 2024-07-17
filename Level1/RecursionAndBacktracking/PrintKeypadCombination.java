package Level1.RecursionAndBacktracking;

import java.util.Scanner;

public class PrintKeypadCombination {
    static String codes[]={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKeypadComb(String str,String ans){

        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);//6
        String ros=str.substring(1); //67

        //get code
        String codesforch=codes[ch-'0'];
        for(int i=0;i<codesforch.length();i++){
            char ch1=codesforch.charAt(i);

            printKeypadComb(ros,ans+ch1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printKeypadComb(str, "");
    }
}
