package com.demo.util;

public class ToolUtil {
    private static String info;
    public static void setInfo(String s) {
        info = s;
    }
    public static String getInfo() {
        if (info == null) {
            info = "没有赋初值, 返回默认信息";
        }
        return info;
    }
}
