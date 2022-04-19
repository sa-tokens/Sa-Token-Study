package com.one.plugin;

import com.one.core.FrameOnePlugin;

public class FileReadPlugin {

    public static FrameOnePlugin<String> get() {

        FrameOnePlugin<String> plugin = new FrameOnePlugin<>();

        plugin.init = frame -> "fileReader";

        plugin.execute = (frame) -> {
            System.out.println("根据 frame 里面的对象读取文件路径, 并返回文件内容");
            return "xxx (本来可以返回 IO文件流对象, 这里为了简化返回 String 对象)";
        };

        plugin.finish = frame -> true;

        return plugin;
    }

}
