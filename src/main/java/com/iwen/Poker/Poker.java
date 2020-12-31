package com.iwen.Poker;

public class Poker {
    private FlowerEnum flower;
    private PointEnum pointer;
    private int sort;

    public Poker(FlowerEnum flower, PointEnum pointer, int sort) {
        super();
        this.flower = flower;
        this.pointer = pointer;
        this.sort = sort;
    }

    public FlowerEnum getFlower() {
        return flower;
    }

    public void setFlower(FlowerEnum flower) {
        this.flower = flower;
    }

    public PointEnum getPointer() {
        return pointer;
    }

    public void setPointer(PointEnum pointer) {
        this.pointer = pointer;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return flower.getFlower()  + pointer.getPoint();
    }
}
