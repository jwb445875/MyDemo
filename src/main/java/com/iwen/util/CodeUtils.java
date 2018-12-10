package com.iwen.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Administrator on 2018/12/10.
 */
public class CodeUtils {

    /**
     * 获取随机的6位数字验证码
     * @return
     */
    public static String getCode(){
        char[] randomChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
        }
        String mobilecode = stringBuffer.toString();
        return mobilecode;
    }
    /**
     * 随机产生N位验证码
     *
     * @return
     */
    public static char[] getRandNum(int n) {
        char[] rand = new char[n];
        String str = "123456789qwertyuipkjhgfdsaxcvbnmQWERTYUIPLKJHGFDSAXCVBNM";
        for (int i = 0; i < n; i++) {
            Random rd = new Random();
            int index = rd.nextInt(str.length());

            // 通过下标获取字符
            rand[i] = str.charAt(index);
        }
        return rand;
    }

    /**
     * 生成图片 - 验证码
     *
     * @param randNum
     *            验证码
     * @return
     */
    public static BufferedImage generateRandImg(char[] randNum) {

        // 在内存中创建图象
        int width = 162, height = 45;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics g = image.getGraphics();

        // 生成随机类
        Random random = new Random();

        // 设定背景色
        g.setColor(getRandColor(200, 250));

        g.fillRect(0, 0, width, height);

        // 设定字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, 28));

        // 画边框
        // g.setColor(new Color());
        // g.drawRect(0,0,width-1,height-1);

        // 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 160; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        String strRandNum = "";
        for (int i = 0; i < 4; i++) {// 取出验证码(4位数字)
            strRandNum = Character.toString(randNum[i]);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(strRandNum, 38 * i + 6, 28);// 将验证码显示到图象中
        }

        // 图象生效
        g.dispose();

        return image;
    }

    /**
     * 获得随机图片颜色
     *
     * @param fc
     * @param bc
     * @return
     */
    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
