package akash;

/**
 * Created by akash on 09-03-2018.
 */
public class IntegerToEnglishWords {
/*    Convert a non-negative integer to its english words representation.
 Given input is guaranteed to be less than 2^31 - 1.

    For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1,234,567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" */


    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] elevens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String hundred = "Hundred";
    String thousand = "Thousand";
    String million = "Million";
    String billion = "Billion";

    public String numberToWords(int num) {
        String number = "";
        if (num > 1000000000) {
            int bil = num / 1000000000;
            number += getNumberBelow1000(bil) + " " + billion;
            num = num % 1000000000;
        }
        if (num > 1000000) {
            int mil = num / 1000000;
            number += " " + getNumberBelow1000(mil) + " " + million;
            num = num % 1000000;
        }

        number += " " + getNumberBelow1000(num);
        return number.trim();
    }

    public String getNumberBelow1000(int num) {
        String str = "";
        if (num >= 1000) {
            int ths = num / 1000;
            if (ths > 9) {
                str += " " + getNumberBelow1000(ths) + " " + thousand;
                num = num % 1000;
            } else {
                if (ths > 9) {
                    str += getNumberBelow1000(ths) + " " + thousand;
                } else str += " " + ones[ths] + " " + thousand;
                num = num % 1000;
            }
        }
        if (num >= 100) {
            int hunds = num / 100;
            if (hunds > 9) {
                str += getNumberBelow1000(hunds) + " " + hundred;
            } else str += " " + ones[hunds] + " " + hundred;
            num = num % 100;
        }
        if (num > 9) {
            if (num > 10 && num <= 19) {
                int ele = num % 10;
                str += " " + elevens[ele];
                return str.trim();
            } else {
                int ten = num / 10;
                int one = num % 10;
                if (one == 0) {
                    str += " " + tens[ten];
                    return str.trim();
                }
                str += " " + tens[ten] + " " + ones[one];
                return str.trim();
            }
        }
        if (num <= 9) {
            str += " " + ones[num];
            return str.trim();
        }
        return str.trim();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords words = new IntegerToEnglishWords();
        // System.out.println(words.numberToWords(100));
        System.out.println(words.numberToWords(1000010));
      /*  System.out.println(words.numberToWords(10000));
        System.out.println(words.numberToWords(1234567));
        System.out.println(words.numberToWords(1234567890));
        System.out.println(words.numberToWords(12345));
        System.out.println(words.getNumberBelow1000(2903));
        System.out.println(words.getNumberBelow1000(917));*/
    }
}
