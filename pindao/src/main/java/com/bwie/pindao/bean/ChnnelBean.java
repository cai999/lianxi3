package com.bwie.pindao.bean;

/**
 * Created by ll on 2018/7/27.
 */

public class ChnnelBean {
    private String name;
    private boolean flag;

    public ChnnelBean(String name, boolean flag) {
        this.name = name;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ChnnelBean() {
        super();
    }

    @Override
    public String toString() {
        return "ChnnelBean{" +
                "name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}
