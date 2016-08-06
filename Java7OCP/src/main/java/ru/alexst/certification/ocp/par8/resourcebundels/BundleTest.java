package ru.alexst.certification.ocp.par8.resourcebundels;

import java.util.Locale;
import java.util.ResourceBundle;

/*
 
!!!!!!!!!!!!11
Remember that searching for a property file uses a linear list. However, once a
matching resource bundle is found, keys can only come from that resource bundle's
hierarchy

RB_fr_CA.java 
RB.java
RB_fr.java
RB_fr_CA.java

RB_fr_CA.properties 
RB.properties
RB_fr.properties
RB_fr_CA.properties

Path to bundle files must be specified by fully qualified name: !!!!!!!!!!!!!!!!

ru.alexst.certification.ocp.par8.resources.locale


SEARCHING ALGORYTHM!!!!!!!!

Locale locale = new Locale("fr", "CA");
ResourceBundle rb = ResourceBundle.getBundle("RB", locale);


RB_fr_CA.java // exactly what we asked for
RB_fr_CA.properties
RB_fr.java // couldn't find exactly what we asked for
RB_fr.properties // now trying just requested language
RB_en_US.java // couldn't find French
RB_en_US.properties // now trying default Locale (for Russia default Locale ru_Ru) !!!!!!!!
RB_en.java // couldn't find full default Locale country
RB_en.properties // now trying default Locale language
RB.java // couldn't find anything any matching Locale,
RB.properties // now trying default bundle


"locale" and "Locale" are different bundles !!!!!!!!!!!!!!!!!!!!!


If in Locale.java bundle there is not String key a runtime exception will occur 
 */

public class BundleTest {

    public static void main(String[] args) {
        Locale ruLocale = new Locale("ru", "rus");
        Locale enLocale = new Locale("en", "eng");
        Locale defaultLoc = Locale.getDefault();

        ResourceBundle ruRb = ResourceBundle.getBundle("ru.alexst.certification.ocp.par8.resources.locale", ruLocale);

        ResourceBundle enRb = ResourceBundle.getBundle("ru.alexst.certification.ocp.par8.resources.locale", enLocale);
        // Не для экзамена, но запомни что defaultLocale для России ru_RU

        ResourceBundle defaultRb = ResourceBundle.getBundle("ru.alexst.certification.ocp.par8.resources.Locale",
                defaultLoc);

        System.out.println(ruRb.getString("text"));
        System.out.println(enRb.getString("text"));

        System.out.println((StringBuilder) defaultRb.getObject("second"));
    }

}
