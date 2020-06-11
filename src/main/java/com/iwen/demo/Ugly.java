package com.iwen.demo;

public class Ugly {
    private int Ugly;

    private Ugly(int ugly) {
        Ugly = ugly;
    }

    public static Ugly Ugly(){
        int Ugly;
        for(Ugly=0;Ugly<5;Ugly++){
        }
        return new Ugly(Ugly);
    }

    @Override
    public String toString() {
        return "Ugly=" + Ugly ;
    }

    public static void main(String[] args) {
        System.out.println(Ugly());
    }
}
