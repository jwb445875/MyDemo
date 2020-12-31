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

    private int xiaoNum=0;//小于等于5的数
    private int bigNum=0;//大于大于10的数
    private int aNum=0;//A的数


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
            if(p.getPointer().getNo()==15){
                aNum++;
            }else if(p.getPointer().getNo()>10){
                bigNum++;
            }else if(p.getPointer().getNo()>5){
            }else {
                xiaoNum++;
            }
        }
    }

    private void check() {
        if(bigNum>=7){
            this.tianPai=true;
            this.tianPaiName="7老头";
            return;
        }else if(bigNum==0){
            this.tianPai=true;
            this.tianPaiName=aNum==0?"全小":"半小";
            return;
        }else if(xiaoNum==0){
            this.tianPai=true;
            this.tianPaiName=aNum==0?"全大":"半大";
            return;
        }
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
