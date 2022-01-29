package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

public class Bed implements Entity{
    private int id=-1;
    private int familyid=-1;
    private int dormroomid=-1;


    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
