package ru.alexst.certification.ocp.par8.locale;

import java.util.Locale;

/*
 
 There are two types of locale constants: with only language, 
 with both language and country
 
 locale.ENGLISH - determines only "en" language, whithout country
 
 
 */

public class LocaleBasic {

	public static void main(String[] args) {
		Locale loc = Locale.ENGLISH;
		System.out.println(String.format("%s %s", loc.getLanguage(), loc.getCountry()));
	}

}
