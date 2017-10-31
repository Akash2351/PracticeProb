/**
 * Created by Chiru on Jan 6, 2017
 */
package byteByByte;

//Displays the number of one's present in a binary representation of a number
//No of bit to represent a number x = log(x)
//So runtime is O(log x)
public class NoOfOnesInBinary {

    public static void main(String[] args) {
        System.out.println(noOfOnes(7));
    }

    public static int noOfOnes(int number) {
        int count = 0;

        while (number > 0) {
            // checking if rightmost bit is 1
            count += number & 1;
            number >>= 1;
        }
        return count;
    }
}