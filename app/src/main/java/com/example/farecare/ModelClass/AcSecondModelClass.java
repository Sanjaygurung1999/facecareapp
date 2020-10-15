package com.example.farecare.ModelClass;

public class AcSecondModelClass {
    String subtitle;
    String title;

    public AcSecondModelClass(String str, String str2) {
        this.title = str;
        this.subtitle = str2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }
}
