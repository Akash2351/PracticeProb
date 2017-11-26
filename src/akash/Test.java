package akash;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by akash on 20-11-2017.
 */
public class Test {

    class TimeSeries implements Comparable<TimeSeries> {
        String dt;
        String str;
        int num;

        public TimeSeries(String dt, String str, int num) {
            this.dt = dt;
            this.str = str;
            this.num = num;
        }

        @Override
        public int compareTo(TimeSeries o) {
            Date dt1 = toDate(this.dt);
            Date dt0 = toDate(o.dt);
            if (dt1.compareTo(dt0) == 0) {
                return this.str.compareTo(o.str);
            }
            //for descending dates
            else if (dt1.compareTo(dt0) < 0)
                return 1;
            else return -1;
        }

        public Date toDate(String str) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM");
            Date date = null;
            try {
                date = (Date) formatter.parse(str);
            } catch (Exception e) {
                System.out.println(e);
            }
            return date;
        }
    }

    public static void main(String[] args) {
        Test ts = new Test();
        TimeSeries t1 = ts.new TimeSeries("2015-05", "clicks", 23);
        TimeSeries t2 = ts.new TimeSeries("2015-05", "clicka", 23);
        TimeSeries t3 = ts.new TimeSeries("2015-07", "clicks", 23);
        ArrayList<TimeSeries> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        Date dt;
        Collections.sort(list);
        /*list.sort(new Comparator<TimeSeries>() {
            @Override
            public int compare(TimeSeries o1, TimeSeries o2) {
                return 0;
            }
        });*/
        for (TimeSeries s1 : list) {
            System.out.println(s1.dt + " :" + s1.str);
        }
    }
}
