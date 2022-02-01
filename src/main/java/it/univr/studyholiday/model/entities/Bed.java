package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

public class Bed implements Entity{
    private int id=-1;
    private int familyid=-1;
    private int dormroomid=-1;

    public Bed(int id, int familyid, int dormroomid) {
        this.id = id;
        if (familyid!=0)
            this.familyid = familyid;
        if (dormroomid!=0)
            this.dormroomid = dormroomid;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
