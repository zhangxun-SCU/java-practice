package cw.learn.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Day2Day {
    public static void main(String[] args) throws ParseException {
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        String day1 = scanner.nextLine();
        String day2 = scanner.nextLine();
        day1 = day1.substring(0, 4) + "-" + day1.substring(4, 6) + "-" + day1.substring(6, 8);
        day2 = day2.substring(0, 4) + "-" + day2.substring(4, 6) + "-" + day2.substring(6, 8);
        Date date1 = dft.parse(day1);//开始时间
        Date date2= dft.parse(day2);//结束时间
        Date nextDay = date1;
        int count = 0;
        while(nextDay.before(date2)){
            Calendar cld = Calendar.getInstance();
            cld.setTime(date1);
            cld.add(Calendar.DATE, 1);
            date1 = cld.getTime();
            nextDay = date1;
            count++;
        }
        System.out.println(count + 1);
    }
}
