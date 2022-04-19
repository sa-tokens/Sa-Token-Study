package com.one;

import com.one.core.FrameOne;
import com.one.core.FrameOnePlugin;

import java.util.HashMap;
import java.util.Map;

public class FrameOneUtil {

    private static FrameOne frameOne = new FrameOne();

    private static Map<String, FrameOnePlugin> plugins = new HashMap<>();


    public static String addPlugin(FrameOnePlugin plugin) {
        String pluginTriggerName = plugin.pluginInit(frameOne);
        boolean hasSameTriggerName = plugins.containsKey(pluginTriggerName);
        if (hasSameTriggerName) {
            // 之前载入过同名的插件, 移除前结束资源占用
            plugins.get(pluginTriggerName).pluginFinish(frameOne);
        }
        plugins.put(pluginTriggerName, plugin);
        return pluginTriggerName;
    }

    public static Object emitPlugin(String triggerName) {
        if (plugins.containsKey(triggerName)) {
            return plugins.get(triggerName).pluginExecute(frameOne);
        } else {
            return null;
        }
    }

    public static Boolean endPlugin(String triggerName) {
        if (plugins.containsKey(triggerName)) {
            return plugins.get(triggerName).pluginFinish(frameOne);
        } else {
            return true;
        }
    }



}
