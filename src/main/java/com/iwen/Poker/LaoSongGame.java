package com.iwen.Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LaoSongGame {
    static List<LaoSongPlayer> players;
    static ArrayList<Poker> list = new ArrayList<>();

    static FlowerEnum[] flowers = FlowerEnum.values2();
    static PointEnum[] pointers = PointEnum.values2();
    int bossIndex;// 庄家索引

    static {
        // 初始化扑克
        for (int i = 0; i < flowers.length; i++) {
            for (int j = 0; j < pointers.length; j++) {
                // 生成一张扑克对象
                Poker p = new Poker(flowers[i], pointers[j], j);
                list.add(p);
            }
        }
        // 初始化玩家
        players = Arrays.asList(new LaoSongPlayer(1, "我"), new LaoSongPlayer(2, "上家"), new LaoSongPlayer(3, "对家"), new LaoSongPlayer(4, "下家"));
    }

    // 随机庄家
    public void pushBoss() {
        Random r = new Random();
        bossIndex = r.nextInt(players.size());
        // 设置随机到的玩家为地主
        players.get(bossIndex).setBoss(true);
    }

    // 发牌
    public void pushPoker() {
        Random r = new Random();
        for (int n = 0; n < players.size(); n++) {
            for (int i = 0; i < 13; i++) {
                int index = r.nextInt(list.size());
                players.get(n).getPokers().add(list.get(index));
                list.remove(index);
            }
        }
    }

    public void start() {
        pushBoss();
        pushPoker();
        for (LaoSongPlayer p : players) {
            p.doPoker();
            StringBuilder sb=new StringBuilder();
            sb.append(p.getName()).append(":");
            if(p.isTianPai()){
                sb.append(p.getTianPaiName());
                sb.append(p.getPokers());
            }else {
                sb.append(p.getHead()).append(p.getMiddle()).append(p.getEnd());
            }
            if(p.isBoss()){
                System.err.println(sb.toString());
            }else {
                System.out.println(sb.toString());
            }

        }
    }

    public static void main(String[] args) {
        new LaoSongGame().start();
    }

}
