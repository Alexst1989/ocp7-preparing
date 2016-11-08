package ru.alexst.certification.ocp.par8.locale;

import java.util.Locale;

/*
 
 There are two types of locale constants: with only language, 
 with both language and country
 locale.ENGLISH -   determines only "en" language, whithout country
 
 
 Locale.ENGLISH             en
 Locale.FRANCH              fr
 Locale.CHINESE             zh
 Locale.GERMAN              de
 Locale.ITALIAN             it
 Locale.JAPANESE            ja
 Locale.KOREAN              ko
 
 
 Locale.TRADITIONAL_CHINESE zh_TW
 Locale.UK                  en_GB
 Locale.US                  en_US
 Locale.CANADA              en_CA
 Locale.CANADA_FRENCH       fr_CA
 Locale.FRANCE              fr_FR
 
 
CANADA
CANADA_FRENCH
CHINA

ENGLISH
FRANCE
FRENCH

GERMANY

ITALY
JAPAN

KOREA

PRC
SIMPLIFIED_CHINESE
TAIWAN

 
 
 */

public class LocaleBasic {

    public static void main(String[] args) {
        Locale loc = Locale.FRANCE;
        Locale loc2 = Locale.FRENCH;
        Locale loc3 = Locale.CHINESE;
        Locale loc4 = Locale.GERMAN;
        Locale loc5 = Locale.ITALIAN;
        Locale loc6 = Locale.JAPANESE;
        Locale loc7 = Locale.KOREAN;
        Locale loc8 = Locale.TRADITIONAL_CHINESE;
        System.out.println(String.format("1 %s %s", loc.getLanguage(), loc.getCountry()));
        System.out.println(String.format("2 %s %s", loc2.getLanguage(), loc2.getCountry()));
        System.out.println(String.format("3 %s %s", loc3.getLanguage(), loc3.getCountry()));
        System.out.println(String.format("4 %s %s", loc4.getLanguage(), loc4.getCountry()));
        System.out.println(String.format("5 %s %s", loc5.getLanguage(), loc5.getCountry()));
        System.out.println(String.format("6 %s %s", loc6.getLanguage(), loc6.getCountry()));
        System.out.println(String.format("7 %s %s", loc7.getLanguage(), loc7.getCountry()));
        System.out.println(String.format("8 %s %s", loc8.getLanguage(), loc8.getCountry()));
        
    }

}
