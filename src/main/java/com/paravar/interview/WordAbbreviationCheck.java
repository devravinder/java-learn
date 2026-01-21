package com.paravar.interview;

public class WordAbbreviationCheck {

    /*
    if a word & its abbreviation is given...check whether the abbreviation is proper or not.
     eg:
        happy - > h3y : true
        happy -> 5 : true
        happy -> h4 : true
        happy -> h5y : false

    * */
    public static boolean isValidAbbreviation(String word, String abbr) {
        int i = 0; // pointer for word
        int j = 0; // pointer for abbr

        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                // number should not start with 0
                if (abbr.charAt(j) == '0') return false;

                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num; // skip characters in word
            } else {
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }

        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        System.out.println(isValidAbbreviation("happy", "h3y")); // true
        System.out.println(isValidAbbreviation("happy", "5"));   // true
        System.out.println(isValidAbbreviation("happy", "h4"));  // true
        System.out.println(isValidAbbreviation("happy", "h5y")); // false
    }
}
