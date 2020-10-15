package com.example.farecare.ModelClass;

public class DateDayModelClass {
    String date;
    String day;

    public DateDayModelClass(String str, String str2) {
        this.date = str;
        this.day = str2;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String str) {
        this.day = str;
    }
}
