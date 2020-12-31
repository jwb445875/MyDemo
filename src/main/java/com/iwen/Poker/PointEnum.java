package com.iwen.Poker;

public enum PointEnum {
    p1(15,"a"),
    p2(2,"2"),
    p3(3,"3"),
    p4(4,"4"),
    p5(5,"5"),
    p6(6,"6"),
    p7(7,"7"),
    p8(8,"8"),
    p9(9,"9"),
    p10(10,"10"),
    pJ(11,"J"),
    pQ(12,"Q"),
    pK(13,"K"),
    pW(19,"王"),
    ;

    private int no;
    private String point;

    PointEnum(int no, String point) {
        this.no = no;
        this.point = point;
    }

    public static PointEnum[] values2() {
        PointEnum[] p={p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,pJ,pQ,pK};
        return p;
    }

    public int getNo() {
        return no;
    }

    public String getPoint() {
        return point;
    }
}
