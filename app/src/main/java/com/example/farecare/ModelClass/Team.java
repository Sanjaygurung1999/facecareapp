package com.example.farecare.ModelClass;

import java.util.ArrayList;

public class Team {
    public String Image;
    public String Name;
    public ArrayList<String> players = new ArrayList<>();

    public Team(String str) {
        this.Name = str;
    }

    public String toString() {
        return this.Name;
    }
}
