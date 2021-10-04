package test3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Timer {

    public  void main(final String[] args) throws ParseException {
//        String string = "2021-09-28 15:8:43";
//        String pattern = "yyyy-MM-dd' 'HH:mm:ss";
//        Date date = new SimpleDateFormat(pattern).parse(string);
//        System.out.println(date);
//        System.out.println(date.getYear()+1900);
//        System.out.println(date.getMonth()+1);
//        System.out.println(date.getDate());
//        System.out.println(date.getHours());
//        System.out.println(date.getMinutes());
//        System.out.println(date.getSeconds());
//
//        Date date1 = new Date();
//        System.out.println(date1);
//
//        Date date2;
//        if (date1.after(date)){
//            date2 = new Date(date1.getTime() - date.getTime());
//        }
//        else {
//            date2 = new Date(date.getTime() - date1.getTime());
//        }
//
//
//        System.out.println(date2);
//        System.out.println(date2.getTime()); //ms
    }

    public long count(String hour, String minute){
        Date date1 = new Date();
        Date date2 = new Date();
        date2.setHours(Integer.parseInt(hour));
        date2.setMinutes(Integer.parseInt(minute));
        date2.setSeconds(0);

        Date date = new Date();

        if (date1.after(date2)){
            date = new Date(date1.getTime() - date2.getTime());
        }
        else {
            date = new Date(date2.getTime() - date1.getTime());
        }

        System.out.println(date.getTime()/1000);
        return date.getTime();
    }
}