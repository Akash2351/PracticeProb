package akash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by akash on 04-12-2017.
 */
public class NextClosestTime {

    public static void main(String[] args) {
        NextClosestTime ct = new NextClosestTime();
        ct.getNextTime("12:12");
    }

    public void getNextTime(String time) {
        //stores time in {h,h,m,m}
        ArrayList<Integer> nos = new ArrayList<>();
        nos.add(Character.getNumericValue(time.charAt(0)));
        nos.add(Character.getNumericValue(time.charAt(1)));
        nos.add(Character.getNumericValue(time.charAt(3)));
        nos.add(Character.getNumericValue(time.charAt(4)));

        HashMap<Integer, Integer> possibleMap = new HashMap<>();
        getAllTimeCombinations(nos, 4, "", possibleMap);
        for (Map.Entry<Integer, Integer> entry : possibleMap.entrySet()) {
            System.out.println("Hour:" + entry.getKey() + " min:" + entry.getValue());
        }


    }


    public void getAllTimeCombinations(List<Integer> nos, int len, String curTime, Map<Integer, Integer> map) {
        if (len == 0) {
            map.put(Integer.valueOf(curTime.substring(0, 2)), Integer.valueOf(curTime.substring(2, 4)));
            return;
        }
        for (int i = 0; i < len; i++) {
            int no = nos.get(i);
            nos.remove(nos.get(i));
            curTime = no + curTime;
            getAllTimeCombinations(nos, len - 1, curTime, map);
            curTime = curTime.substring(1);
            nos.add(no);
        }
    }
}
