package com.one.core;

public interface FrameOnePlugin<T> {
    String pluginInit(FrameOne frame);
    T pluginExecute(FrameOne frame);
    Boolean pluginFinish(FrameOne frame);
}
