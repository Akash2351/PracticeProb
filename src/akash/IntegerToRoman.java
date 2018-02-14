package akash;

/**
 * Created by akash on 13-02-2018.
 */
public class IntegerToRoman {

    //Given an integer, convert it to a roman numeral.
    //Input is guaranteed to be within the range from 1 to 3999.
    public String intToRoman(int num) {

        //X->10, L->50, C->100,D->500, M->1000

        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};


        int one = num % 10;
        int ten = (num % 100) / 10;
        int hundred = (num % 1000) / 100;
        int thousand = num / 1000;

        //System.out.printf("%d %d %d %d",one,ten,hundred,thousand);
        return thousands[thousand] + hundreds[hundred] + tens[ten] + ones[one];
    }
}
