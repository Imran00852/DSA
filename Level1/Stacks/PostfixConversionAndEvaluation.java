package Level1.Stacks;

import java.util.Stack;

import static Level1.Stacks.InfixEvaluation.Operation;

public class PostfixConversionAndEvaluation {
    public static void coversionAndEvaluation(String str){
        Stack<Integer> operation=new Stack<>();
        Stack<String> prefixStack=new Stack<>();
        Stack<String> infixStack=new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            
            if(Character.isDigit(ch)){
                operation.push(ch-'0');
                prefixStack.push(ch+ "");
                infixStack.push(ch+ "");
            } else if (ch=='+' || ch=='-' || ch=='/' || ch=='*') {
                //operation
                int v2=operation.pop();
                int v1=operation.pop();
                int res=Operation(v1,v2,ch);
                operation.push(res);

                //infix
                String Iv2=infixStack.pop();
                String Iv1=infixStack.pop();
                String Ires="("+Iv1+ch+Iv2+")";
                infixStack.push(Ires);

                //prefix
                String Pv2=prefixStack.pop();
                String Pv1=prefixStack.pop();
                String Pres=ch+Pv1+Pv2;
                prefixStack.push(Pres);
            }
        }
        System.out.println(operation.peek());
        System.out.println(infixStack.peek());
        System.out.println(prefixStack.peek());
    }
    public static void main(String[] args) {
        String str="264*8/+3-";
        coversionAndEvaluation(str);
    }
}
