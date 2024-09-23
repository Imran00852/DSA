package Level1.DynamicProgramming;

//count of a+b+c+ subsequences--->aabbcc,aaabbbccc,abc,aabcc,aaabcc,...
public class ABCSubsequences {
    public static void getABCSubsequence(String str) {
        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                a = 2 * a + 1;
            } else if (str.charAt(i) == 'b') {
                ab = 2 * ab + a;
            } else if (str.charAt(i) == 'c') {
                abc = 2 * abc + ab;
            }
        }

        System.out.println(abc);
    }

    public static void main(String[] args) {
        String str = "abcabc";
        getABCSubsequence(str);
    }
}
