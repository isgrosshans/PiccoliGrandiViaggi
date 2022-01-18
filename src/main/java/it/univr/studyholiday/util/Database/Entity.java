package it.univr.studyholiday.util.Database;

import java.lang.reflect.Field;

public interface Entity {
    public default Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
