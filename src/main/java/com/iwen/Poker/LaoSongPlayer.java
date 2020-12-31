package com.iwen.Poker;

import java.util.ArrayList;

public class LaoSongPlayer extends Player{

    boolean tianPai=false;
    private String tianPaiName;
    private ArrayList<Poker> head = new ArrayList<>();
    private ArrayList<Poker> middle = new ArrayList<>();
    private ArrayList<Poker> end = new ArrayList<>();

    private ArrayList<Poker> f1 = new ArrayList<>();
    private ArrayList<Poker> f2 = new ArrayList<>();
    private ArrayList<Poker> f3 = new ArrayList<>();
    private ArrayList<Poker> f4 = new ArrayList<>();

    public LaoSongPlayer() {
    }

    public LaoSongPlayer(int id, String name) {
        super(id, name);
    }

    public boolean isTianPai() {
        return tianPai;
    }

    public void setTianPai(boolean tianPai) {
        this.tianPai = tianPai;
    }

    public String getTianPaiName() {
        return tianPaiName;
    }

    public void setTianPaiName(String tianPaiName) {
        this.tianPaiName = tianPaiName;
    }

    public ArrayList<Poker> getHead() {
        return head;
    }

    public void setHead(ArrayList<Poker> head) {
        this.head = head;
    }

    public ArrayList<Poker> getMiddle() {
        return middle;
    }

    public void setMiddle(ArrayList<Poker> middle) {
        this.middle = middle;
    }

    public ArrayList<Poker> getEnd() {
        return end;
    }

    public void setEnd(ArrayList<Poker> end) {
        this.end = end;
    }

    public ArrayList<Poker> getF1() {
        return f1;
    }

    public void setF1(ArrayList<Poker> f1) {
        this.f1 = f1;
    }

    public ArrayList<Poker> getF2() {
        return f2;
    }

    public void setF2(ArrayList<Poker> f2) {
        this.f2 = f2;
    }

    public ArrayList<Poker> getF3() {
        return f3;
    }

    public void setF3(ArrayList<Poker> f3) {
        this.f3 = f3;
    }

    public ArrayList<Poker> getF4() {
        return f4;
    }

    public void setF4(ArrayList<Poker> f4) {
        this.f4 = f4;
    }

    public void doPoker(){
        sortPokers();
        doflowers();
        check();
        if(tianPai){
            return;
        }else {
            int i=0;
            for(Poker p:getPokers()){
                i++;
                if(i<4){
                    head.add(p);
                }else if(i<9){
                    middle.add(p);
                }else {
                    end.add(p);
                }
            }
        }
    }

    private void doflowers() {
        for(Poker p:getPokers()){
            if(p.getFlower().getNo()==1){
                f1.add(p);
            }else if(p.getFlower().getNo()==2){
                f2.add(p);
            }else if(p.getFlower().getNo()==3){
                f3.add(p);
            }else if(p.getFlower().getNo()==4){
                f4.add(p);
            }
        }
    }

    private void check() {
        boolean is3tonghua=check3tonghua();
        if(is3tonghua){
            this.tianPai=true;
            this.tianPaiName="3同花顺";
            sortByFlowerPokers();
        }
    }

    private boolean check3tonghua() {
        int num=f1.size();
        if(check3tonghua2(num)){
            return false;
        }
        num=f2.size();
        if(check3tonghua2(num)){
            return false;
        }
        num=f3.size();
        if(check3tonghua2(num)){
            return false;
        }
        num=f4.size();
        if(check3tonghua2(num)){
            return false;
        }
        return true;
    }

    private boolean check3tonghua2(int num) {
        if(num==0||num==3||num==5||num==8||num==10||num==13){
            return false;
        }
        return true;
    }

}
