package com.example.farecare.ModelClass;

public class HomeCategoryModelClass {
    Integer image;
    String title;

    public HomeCategoryModelClass(Integer num, String str){
        this.image=num;
        this.title=str;
    }

    public Integer getImage(){
        return this.image;
    }

    public void setImage(Integer num){
        this.image=num;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String str){
        this.title=str;
    }
}
