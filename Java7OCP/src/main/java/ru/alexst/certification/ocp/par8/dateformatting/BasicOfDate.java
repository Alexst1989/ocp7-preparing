package ru.alexst.certification.ocp.par8.dateformatting;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
    Constants for manipulating with Calendar:
        
            

 */

public class BasicOfDate {

    public static void main(String args[]) {

        Date d = new Date();
        System.out.println(String.format("Today is %s", d.toString()));

        Calendar c = Calendar.getInstance();
        c.setTime(d);

        c.add(Calendar.DAY_OF_WEEK, -2);
        System.out.println(String.format("Two days ago %s", c.getTime().toString()));
        c.setTime(d);

        c.add(Calendar.WEEK_OF_MONTH, -1);
        System.out.println(String.format("A week ago %s", c.getTime().toString()));
        c.setTime(d);

        c.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(String.format("Three days ago %s", c.getTime().toString()));
        c.setTime(d);

        c.add(Calendar.DAY_OF_YEAR, -4);
        System.out.println(String.format("Four days ago %s", c.getTime().toString()));
        c.setTime(d);

        c.add(Calendar.MONTH, -5);
        System.out.println(String.format("Five month ago %s", c.getTime().toString()));
        c.setTime(d);

        System.out.println();
        System.out.println("========== Locale DateFormat =============");

        Locale locRus = new Locale("ru", "rus");
        Locale locUkr = new Locale("uk", "ukr");
        Locale loc = new Locale("en");

        DateFormat dfShortRus = DateFormat.getDateInstance(DateFormat.SHORT, locRus);
        DateFormat dfFullUkr = DateFormat.getDateInstance(DateFormat.FULL, locUkr);
        DateFormat df = DateFormat.getInstance();

        System.out.println(dfShortRus.format(d));
        System.out.println(dfFullUkr.format(d));
        System.out.println(df.format(d));

        locUkr.getCountry();

        System.out.println();
        System.out.println("=========== NumberFormat ======================");

        NumberFormat defaultNf = NumberFormat.getInstance();
        NumberFormat rusNf = NumberFormat.getInstance(locRus);
        NumberFormat ukrNf = NumberFormat.getInstance(locUkr);

        defaultNf.setMinimumFractionDigits(5);
        defaultNf.setMaximumFractionDigits(10);
        defaultNf.setGroupingUsed(false);

        NumberFormat defaultNfCurr = NumberFormat.getCurrencyInstance();
        NumberFormat rusNfCurr = NumberFormat.getCurrencyInstance(locRus);
        NumberFormat ukrNfCurr = NumberFormat.getCurrencyInstance(locUkr);

        NumberFormat defaultNfNum = NumberFormat.getNumberInstance();
        NumberFormat rusNfNum = NumberFormat.getNumberInstance(locRus);
        NumberFormat ukrNfNum = NumberFormat.getNumberInstance(locUkr);

        Integer num = 123456789;

        System.out.println("Instance:");
        System.out.println(defaultNf.format(num));
        System.out.println(rusNf.format(num));
        System.out.println(ukrNf.format(num));

        System.out.println("Currency:");
        System.out.println(defaultNfCurr.format(num));
        System.out.println(rusNfCurr.format(num));
        System.out.println(ukrNfCurr.format(num));

        System.out.println("Number:");
        System.out.println(defaultNfNum.format(num));
        System.out.println(rusNfNum.format(num));
        System.out.println(ukrNfNum.format(num));

        System.out.println("============== SimpleDateFormat ============================");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(sdf.format(d));

    }

}
