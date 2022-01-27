package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

public interface Entity {
    public Object getValue(Field field) throws IllegalAccessException;
}
