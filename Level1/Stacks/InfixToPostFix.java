package Level1.Stacks;

import java.util.Stack;

public class InfixToPostFix {
    public static void getPostfixExp(String str){
        Stack<String> postfixStack=new Stack<>();
        Stack<Character> operatorStack=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch=='('){
                operatorStack.push(ch);
            } else if (Character.isDigit(ch) || Character.isLetter(ch)) {
                postfixStack.push(ch+ "");
            } else if (ch==')') {
                while(operatorStack.peek()!='('){
                    char optr=operatorStack.pop();
                    String v2=postfixStack.pop();
                    String v1=postfixStack.pop();
                    String res=v1+v2+optr;
                    postfixStack.push(res);
                }
                operatorStack.pop();
            } else if (ch =='+' || ch=='-' || ch=='*' || ch=='/') {
                while (operatorStack.size()>0 && operatorStack.peek()!='(' && OperatorPrecedence(ch)<=OperatorPrecedence(operatorStack.peek())){
                    char optr=operatorStack.pop();
                    String v2=postfixStack.pop();
                    String v1=postfixStack.pop();
                    String res=v1+v2+optr;
                    postfixStack.push(res);
                }

                operatorStack.push(ch);
            }
        }
        while(operatorStack.size()!=0){
            char optr=operatorStack.pop();
            String v2=postfixStack.pop();
            String v1=postfixStack.pop();
            String res=v1+v2+optr;
            postfixStack.push(res);
        }

        System.out.println(postfixStack.peek());
    }

    public static int OperatorPrecedence(char optr){
        switch (optr) {
            case '+', '-':
                return 1;

            case '*', '/':
                return 2;

            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        String str="(a+b)*2-3"; //infix expression
        getPostfixExp(str);
    }
}
