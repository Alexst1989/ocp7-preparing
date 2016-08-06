package ru.alexst.certification.ocp.par8.resources;

import java.util.ListResourceBundle;

/*
 
 if in first place place not string, ClassCastException would be thrown
 
 */

public class Locale_ru_RU extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] { { "first", 1, 2, 3 }, { "second", new StringBuilder("as") }, { "third", 4 } };
    }

}
