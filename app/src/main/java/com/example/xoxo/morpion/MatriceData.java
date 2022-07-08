package com.example.xoxo.morpion;

import java.util.ArrayList;
import java.util.List;

public class MatriceData {
    private int dimension;
    private Integer[][] listData;

    public MatriceData(int dimension){
        this.dimension = dimension;
        listData = new Integer[dimension][dimension];

    }

    public Integer[][]  getListData() {
        System.out.println("fa aona marina e ?");
        return listData;
    }

    public void setData(int colonne, int ligne, int valeur){
        listData[colonne][ligne] = valeur;
    }

    public Integer getElementInData(int colonne, int ligne){
        return listData[colonne][ligne];
    }
}
