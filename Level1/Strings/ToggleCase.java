package Level1.Strings;

public class ToggleCase {
    public static String toggleCase(String str){
        StringBuilder sb=new StringBuilder(str);

        for(int i=0;i<str.length();i++){
            char ch=sb.charAt(i);

            if(ch>='a' && ch<='z'){
                char uc= (char) ('A' + ch-'a');
                sb.setCharAt(i,uc);
            } else if (ch>='A' && ch<='Z') {
                char lc=(char)('a'+ch-'A');
                sb.setCharAt(i,lc);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str= "PEPCODING";
        System.out.println(toggleCase(str));
    }
}
