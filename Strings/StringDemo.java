package Strings;

public class StringDemo {
    public static void main(String[] args) {
        String s= "imran";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            System.out.println(ch);
        }

        //strings are immutable cuz of interning

        //example of interning
        String s1="hello";
        String s2="hello";

        //to compare contents of two strings use equals
        System.out.println(s1.equals(s2)); //true

        //to check if the string object is different, use ==
        String s3=new String("Hello");
        System.out.println(s1==s3); //false
        System.out.println(s1==s2); //true


        //String Builder--->better performance than String
        StringBuilder sb=new StringBuilder();

        //append
        sb.append("hello");
        System.out.println(sb);

        //insert
        sb.insert(0,'h');
        System.out.println(sb);

        //update
        sb.setCharAt(0,'d');
        System.out.println(sb);

        //remove
        sb.deleteCharAt(0);
        System.out.println(sb);
    }
}
