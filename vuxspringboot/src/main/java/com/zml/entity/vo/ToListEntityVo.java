package com.zml.entity.vo;

public class ToListEntityVo {

    private int id;
    private String title;
    private boolean isEven;
    private boolean state;
    private boolean bianji;

    public ToListEntityVo(int id, String title, boolean isEven, boolean state, boolean bianji) {
        this.id = id;
        this.title = title;
        this.isEven = isEven;
        this.state = state;
        this.bianji = bianji;
    }

    public ToListEntityVo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isBianji() {
        return bianji;
    }

    public void setBianji(boolean bianji) {
        this.bianji = bianji;
    }
}
