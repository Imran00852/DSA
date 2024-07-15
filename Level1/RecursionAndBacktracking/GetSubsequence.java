package Level1.RecursionAndBacktracking;

import java.util.ArrayList;

public class GetSubsequence {
    public static ArrayList<String> getSS(String str){
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0); //a
        String ros=str.substring(1);//bc
        ArrayList<String> forBc=getSS(ros); //[--,-c,b-,bc]
        ArrayList<String> res=new ArrayList<>();
        for(String val:forBc){
            res.add("" + val);
        }
        for(String val:forBc){
            res.add(ch + val);
        }

        return res;

    }
    public static void main(String[] args) {
        String str="abc";

        ArrayList<String> res=getSS(str);
        System.out.println(res);
    }
}
