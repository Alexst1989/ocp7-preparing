package ru.alexst.certification.ocp.par8.resources;

import java.util.ListResourceBundle;

public class Locale_en_UK extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] objectArray = { { "one", 1L }, { "two", "value" }, { "three", (short) 1, (byte) 2, 3, 4 } };
        return objectArray;
    }

}
