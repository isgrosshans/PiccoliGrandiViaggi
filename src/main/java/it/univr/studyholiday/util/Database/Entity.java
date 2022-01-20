package it.univr.studyholiday.util.Database;

import java.lang.reflect.Field;

public interface Entity {
    public Object getValue(Field field) throws IllegalAccessException;
}
