package akash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by akash on 21-02-2018.
 */
public class TimeSeries {
    public static void main(String[] args) {
        Time time = new Time("00:11");
        System.out.println(time.getNextValidTime());
    }
}

class Time implements Comparable<Time> {
    String str;
    String curTime;
    int hours;
    int min;
    ArrayList<Character> nos = new ArrayList<>();
    HashSet<String> combs = new HashSet<>();

    public Time(String str) {
        this.str = str;
        toDate(str);
        getAllCombination();
    }

    @Override
    public int compareTo(Time o) {
        if (this.hours == o.hours)
            return Integer.compare(this.min, o.min);
        else return Integer.compare(this.hours, o.hours);
    }

    public void toDate(String str) {
        String hour = str.substring(0, 2);
        String min = str.substring(3, 5);
        try {
            this.hours = Integer.parseInt(hour);
            this.min = Integer.parseInt(min);
            nos.add(hour.charAt(0));
            nos.add(hour.charAt(1));
            nos.add(min.charAt(0));
            nos.add(min.charAt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "TimeSeries{" +
                "str='" + str + '\'' +
                ", curTime='" + curTime + '\'' +
                ", hours=" + hours +
                ", min=" + min +
                ", nos=" + nos +
                ", combs=" + combs +
                '}';
    }

    public String getNextTime() {
        if (min < 59)
            min++;
        else {
            min = 0;
            hours++;
            if (hours > 23)
                hours = 0;
        }
        return String.format("%02d", hours) + String.format("%02d", min);
    }

    public void getAllCombination() {
        generateRecursive("", combs, 0, new ArrayList<>(nos));
    }

    public boolean isValidTime(String str) {
        String hour = str.substring(0, 2);
        String min = str.substring(2, 4);
        try {
            int hrs = Integer.parseInt(hour);
            int mins = Integer.parseInt(min);
            if (hrs > 23 || hrs < 0) return false;
            if (mins > 59 || mins < 0) return false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    void generateRecursive(String cur, Set<String> combinations, int index, List<Character> curList) {
        if (index == nos.size()) {
            if (isValidTime(cur))
                combinations.add(cur);
            return;
        } else {
            for (int i = 0; i < curList.size(); i++) {
                Character curChar = curList.get(i);
                curList.remove(i);
                generateRecursive(cur + curChar, combinations, index + 1, curList);
                curList.add(i, curChar);
            }
        }
    }

    public String getNextValidTime() {
        String next = "";
        do {
            next = getNextTime();
        } while (!combs.contains(next));

        String str = next.substring(0, 2) + ":" + next.substring(2, 4);
        return str;
    }
}
