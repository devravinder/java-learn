package com.paravar.labs.lab7;

public class Q10_TestStringReverse {
    public static void main(String[] args) {

        StringReverse stringReverse = new StringInbuiltReverseImpl();
        StringReverse stringReverse1 = new StringCustomReverseImpl();
        String str = "Hello";
        System.out.println(stringReverse.reverse(str));
        System.out.println(stringReverse1.reverse(str));
    }
}
interface StringReverse {
    public String reverse( String str);
}
class StringInbuiltReverseImpl implements StringReverse{
    @Override
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

class StringCustomReverseImpl implements StringReverse{

    @Override
    public String reverse(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}