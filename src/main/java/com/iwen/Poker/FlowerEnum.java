package com.iwen.Poker;

public enum FlowerEnum {
    // "", "", "", ""
    hei(1,"♠"),
    hong(2,"♥"),
    mei(3,"♣"),
    fang(4,"♦"),
    xiao(5,"小"),
    da(6,"大"),
    ;



    private int no;
    private String flower;

    FlowerEnum(int no, String flower) {
        this.no = no;
        this.flower = flower;
    }

    public static FlowerEnum[] values2() {
        FlowerEnum[] f={hei,hong,mei,fang};
        return f;
    }

    public int getNo() {
        return no;
    }

    public String getFlower() {
        return flower;
    }


}
