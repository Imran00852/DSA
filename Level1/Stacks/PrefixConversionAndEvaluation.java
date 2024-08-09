package Level1.Stacks;

import java.util.Stack;

import static Level1.Stacks.InfixEvaluation.Operation;

public class PrefixConversionAndEvaluation {
    private static String pval2;

    public static void prefixEvaluationAndConversion(String str) {
        Stack<Integer> operation = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                //operation
                int v1 = operation.pop();
                int v2 = operation.pop();
                int res = Operation(v1, v2, ch);
                operation.push(res);
                //infix
                String val1 = infixStack.pop();
                String val2 = infixStack.pop();
                String Ires = "(" + val1 + ch + val2 + ")";
                infixStack.push(Ires);
                //postfix
                String pval1 = postfixStack.pop();
                String pval2 = postfixStack.pop();
                String Pres=pval1+pval2+ch;
                postfixStack.push(Pres);
            } else {
                operation.push(ch - '0');
                infixStack.push(ch + "");
                postfixStack.push(ch + "");
            }
        }

        System.out.println(operation.pop());
        System.out.println(infixStack.pop());
        System.out.println(postfixStack.pop());
    }

    public static void main(String[] args) {
        String str = "-+2/*6483";
        prefixEvaluationAndConversion(str);
    }
}
