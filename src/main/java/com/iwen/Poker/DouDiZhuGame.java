package com.iwen.Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DouDiZhuGame {
    static List<Player> players;
    static ArrayList<Poker> list = new ArrayList<>();

    static FlowerEnum[] flowers = FlowerEnum.values2();
    static PointEnum[] pointers = PointEnum.values2();
    int bossIndex;// 地主索引

    static {
        // 初始化扑克
        for (int i = 0; i < flowers.length; i++) {
            for (int j = 0; j < pointers.length; j++) {
                // 生成一张扑克对象
                Poker p = new Poker(flowers[i], pointers[j], j);
                list.add(p);
            }
        }

        // 单独将双王加进去
        list.add(new Poker(FlowerEnum.xiao, PointEnum.pW, 13));
        list.add(new Poker(FlowerEnum.da, PointEnum.pW, 14));

        // 初始化玩家
        players = Arrays.asList(new Player(1, "刘备"), new Player(2, "关羽"), new Player(3, "张飞"));
    }

    // 随机地主
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
            for (int i = 0; i < 17; i++) {
                int index = r.nextInt(list.size());
                players.get(n).getPokers().add(list.get(index));
                list.remove(index);
            }
        }

        // 将最后剩的牌给地主
        players.get(bossIndex).getPokers().addAll(list);
    }

    public void start() {
        pushBoss();
        pushPoker();
        for (Player p : players) {
            p.sortPokers();
            if(p.isBoss()){
                System.err.println(p.getName()+p.getPokers());
            }else {
                System.out.println(p.getName()+p.getPokers());
            }
        }
    }

    public static void main(String[] args) {
        new DouDiZhuGame().start();
    }

}
