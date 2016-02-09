package dates;


import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Intervals {


    public static void main(String[] args) {
        new Intervals().test();
    }

    private void test() {


        Interval interval1 = new Interval(DateTime.now(), DateTime.now().plusHours(2));


        Interval interval2 = interval1.withStart(DateTime.now().plusHours(3));

        System.out.println(interval1);
        System.out.println(interval2);
        Interval gapBetweenIntervals = interval1.gap(interval2);
        System.out.println(gapBetweenIntervals);


    }


}
