package com.iwen.common;

/**
 * 存储redis key
 */
public class AppJedisKey {

    // 空间模块key
    public static final String evergrande = "iwen";

    // 用户登录key
    public static final String app_user_key = evergrande + Constant.point +  "app.user";

    // 权限key
    public static final String app_user_role_key = evergrande + Constant.point + "app.user.role";
}
