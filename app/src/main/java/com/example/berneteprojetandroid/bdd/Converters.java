package com.example.berneteprojetandroid.bdd;

import androidx.room.TypeConverter;

public class Converters {

    @TypeConverter
    public String fromStringArray(String[] stringArray) {
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray) {
            sb.append(s);
            sb.append(",");
        }
        return sb.toString();
    }

    @TypeConverter
    public String[] toStringArray(String string) {
        return string.split(",");
    }
}