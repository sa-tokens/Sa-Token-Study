package com.one.core;

import com.one.core.fun.ExecuteInterface;
import com.one.core.fun.FinishInterface;
import com.one.core.fun.InitInterface;

public class FrameOnePlugin<T> {

    public InitInterface init;
    public ExecuteInterface<T> execute;
    public FinishInterface finish;

    public void setInit(InitInterface init) {
        this.init = init;
    }

    public void setExecute(ExecuteInterface exe) {
        this.execute = exe;
    }

    public void setFinish(FinishInterface finish) {
        this.finish = finish;
    }

}





