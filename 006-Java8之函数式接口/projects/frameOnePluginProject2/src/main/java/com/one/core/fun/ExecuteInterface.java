package com.one.core.fun;

import com.one.core.FrameOne;


@FunctionalInterface
public interface ExecuteInterface<T> {
    T run(FrameOne frame);
}
