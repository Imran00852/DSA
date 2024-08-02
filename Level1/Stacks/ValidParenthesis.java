package Level1.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
    public static boolean validParenthesis(String str){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(ch==')'){
                if(st.size()==0){
                    System.out.println("invalid parenthesis");
                    return false;
                } else if (st.peek()!='(') {
                    System.out.println("invalid parenthesis");
                    return false;
                }else {
                    st.pop();
                }
            } else if (ch=='}') {
                if(st.size()==0){
                    System.out.println("invalid parenthesis");
                    return false;
                } else if (st.peek()!='{') {
                    System.out.println("invalid parenthesis");
                    return false;
                }else {
                    st.pop();
                }
            } else if (ch==']') {
                if(st.size()==0){
                    System.out.println("invalid parenthesis");
                    return false;
                } else if (st.peek()!='[') {
                    System.out.println("invalid parenthesis");
                    return false;
                }else {
                    st.pop();
                }
            }
        }

        if(st.size()==0){
            System.out.println("Valid parentheseis");
            return true;
        }else {
            System.out.println("invalid parentheseis");
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(validParenthesis(str));
    }
}
