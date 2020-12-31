package com.iwen.Poker;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

public class Player {
    private int id;
    private String name;
    private ArrayList<Poker> pokers = new ArrayList<>();
    private boolean boss;

    public Player() {

    }

    public Player(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Poker> getPokers() {
        return pokers;
    }

    public void setPokers(ArrayList<Poker> pokers) {
        this.pokers = pokers;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public void sortPokers() {
        pokers= (ArrayList<Poker>) pokers.stream().sorted(Comparator.comparing(p->p.getPointer().getNo())).collect(toList());
    }
}
