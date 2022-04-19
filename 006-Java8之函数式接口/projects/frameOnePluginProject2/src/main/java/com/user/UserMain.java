package com.user;

import com.one.FrameOneUtil;
import com.one.plugin.FileReadPlugin;

public class UserMain {

    public static void main(String[] args) {
        String pluginName = FrameOneUtil.addPlugin(FileReadPlugin.get());
        System.out.println("[文件阅读插件]载入完成");

        Object fileReader = FrameOneUtil.emitPlugin(pluginName);
        System.out.println("文件内容: "+fileReader);

        Boolean pluginEndState = FrameOneUtil.endPlugin(pluginName);
        System.out.println("插件卸载状态: "+pluginEndState);
        System.out.println("[文件阅读插件]卸载完成");
    }

}
