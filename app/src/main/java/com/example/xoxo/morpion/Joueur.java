package com.example.xoxo.morpion;


import java.util.ArrayList;

public class Joueur {
    public String name;
    public Integer score = 0;

    public Joueur(String name){
        this.name = name;
    }

    public void win(){
        this.score += 1;
    }
}
