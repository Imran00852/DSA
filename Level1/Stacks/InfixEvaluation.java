package Level1.Stacks;

import java.util.Stack;

public class InfixEvaluation {
    //precedence
    public static int Precedence(char optr){
        if(optr=='+' || optr=='-'){
            return 1;
        }else {
            return 2;
        }
    }
    //operation
    public static int Operation(int v1,int v2, char optr){
        if(optr=='+'){
            return v1+v2;
        }else if (optr=='-'){
            return v1-v2;
        } else if (optr=='/') {
            return v1/v2;
        }else {
            return v1*v2;
        }
    }
    public static void infixEvaluation(String str){
        Stack<Integer> operand=new Stack<>();
        Stack<Character> operator=new Stack<>();
        
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            
            if(ch=='('){
                 operator.push(ch);
            } else if (Character.isDigit(ch)) {
                operand.push(ch-'0');
            } else if (ch==')') {
                while(operator.peek()!='('){
                    char optr=operator.pop();
                    int v2=operand.pop();
                    int v1=operand.pop();
                    int res=Operation(v1,v2,optr);
                    operand.push(res);
                }
                operator.pop();
            } else if (ch=='+' || ch=='-' || ch=='/' || ch=='*') {
                while (operator.size()>0 && operator.peek()!='(' && Precedence(ch)<=Precedence(operator.peek())){
                    char optr=operator.pop();
                    int v2=operand.pop();
                    int v1=operand.pop();
                    int res=Operation(v1,v2,optr);
                    operand.push(res);
                }
                operator.push(ch);
            }
        }
        while(operator.size()!=0){
            char optr=operator.pop();
            int v2=operand.pop();
            int v1=operand.pop();
            int res=Operation(v1,v2,optr);
            operand.push(res);
        }
        System.out.println(operand.peek());
    }
    public static void main(String[] args) {
        String str="2+3/4-(5*6)";
        infixEvaluation(str);
    }
}
