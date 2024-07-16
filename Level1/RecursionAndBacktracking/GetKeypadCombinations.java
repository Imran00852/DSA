package Level1.RecursionAndBacktracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class GetKeypadCombinations {
    //global array
    static String codes[]={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> getKeypadComb(String str){
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0); //5-->string
        String ros=str.substring(1); //73
        ArrayList<String> for73=getKeypadComb(ros); //[tg,th,ti,ug,uh,ui]
        ArrayList<String> res=new ArrayList<>();

        String codeFor5=codes[ch-'0'];
        for(int i=0;i<codeFor5.length();i++){
            char ch5=codeFor5.charAt(i);
            for(String val:for73){
                res.add(ch5+val);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        ArrayList<String> res=getKeypadComb(str);
        System.out.println(res);
    }
}
