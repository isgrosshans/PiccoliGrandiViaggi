package it.univr.studyholiday.model;


import it.univr.studyholiday.util.Database.*;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;

//     HOLIDAY(id,
//      startdate,weeks,school)
public class Holiday implements Entity{
    private String id;
    private LocalDate start;
    private int weeks;
    private School school;

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
