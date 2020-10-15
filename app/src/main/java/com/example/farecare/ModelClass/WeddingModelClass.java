package com.example.farecare.ModelClass;

public class WeddingModelClass {
    String title;
    String txt1;
    String txt2;
    String txt3;

    public WeddingModelClass(String str, String str2, String str3, String str4) {
        this.title = str;
        this.txt1 = str2;
        this.txt2 = str3;
        this.txt3 = str4;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTxt1() {
        return this.txt1;
    }

    public void setTxt1(String str) {
        this.txt1 = str;
    }

    public String getTxt2() {
        return this.txt2;
    }

    public void setTxt2(String str) {
        this.txt2 = str;
    }

    public String getTxt3() {
        return this.txt3;
    }

    public void setTxt3(String str) {
        this.txt3 = str;
    }
}
