package com.iwen.common;

/**
 * 常量
 */
public class Constant {
    // 管理员默认名称
    public static final String admin = "admin";
    // 点
    public static final String point = ".";
    // 逗号
    public static final String comma = ",";
    // 中划线
    public static final String line = "-";
    // accessToken
    public static final String access_token = "accessToken";
    // APP 签名key
    public static final String sign_key = "signature";
    // APP登录用户过期时间
    public static final Integer expire_time = 7 * 24 * 60 * 60;
    // redis默认不过期时间
    public static final Integer no_expire_time = 0;
    // 权限-无权限
    public static final Integer no_authority = 0;
    // 权限-有权限
    public static final Integer authority = 1;
    // 图片前缀地址
    public static final String IMG_URL = "/api/cfc/app/taskdetail/thumb?fileId=%s";
    // 图片缩略图地址
    public static final String IMG_SMALL_URL = IMG_URL + "&imgType=1_1";
    //月份
    public class MONTH{
        public static final int ONE = 1;
        public static final int TWO = 2;
        public static final int THREE = 3;
        public static final int FOUR = 4;
        public static final int FIVE = 5;
        public static final int SIX = 6;
        public static final int SEVEN = 7;
        public static final int EIGHT = 8;
        public static final int NINE = 9;
        public static final int TEN = 10;
        public static final int ELEVEN = 11;
        public static final int TWELVE = 12;

    }
    //终端类型
    public class TERMINAL_TYPE{
        public static final String APP="app";
        public static final String PC="pc";
        public static final String MONTH="month";
        public static final String OTHER="other";
    }
    //完成状态
    public class FINISH_STATUS{
        public  static final String WAIT_FINISH = "0";
        public  static final String FINISH = "1";
    }
    public class DELTE_TYPE_C{
        public static final String DELETE = "删除";
    }

    public class DELTE_TYPE_N{
        public static final String DELETE = "1";
    }
}
