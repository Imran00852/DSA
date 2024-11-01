package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class FractionToRecurringDecimal {
    public static String getDecimalAns(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        
        if (numerator < 0 ^ denominator < 0) ans.append("-");
        if (numerator == 0) return "0";

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);


        long q = num / den;
        long r = num % den;
        ans.append(q);

        if (r == 0) {
            return ans.toString();
        } else {
            ans.append(".");
            HashMap<Long, Integer> hm = new HashMap<>();
            while (r != 0) {
                if (hm.containsKey(r)) {
                    int pos = hm.get(r);
                    ans.insert(pos, "(");
                    ans.append(")");
                    break;
                } else {
                    hm.put(r, ans.length());
                    r *= 10;
                    q = r / den;
                    r = r % den;
                    ans.append(q);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int numerator = 4, denominator = 333;
        System.out.println(getDecimalAns(numerator, denominator));
    }
}
