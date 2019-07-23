package com.zml.entity.vo;

public class ToListEntityVo {

    private int id;
    private String title;
    private boolean isEven;
    private boolean state;
    private boolean isRepeated;


    public ToListEntityVo(int id, String title, boolean isEven, boolean state) {
        this.id = id;
        this.title = title;
        this.isEven = isEven;
        this.state = state;

    }

    public boolean isRepeated() {
        return isRepeated;
    }

    public void setRepeated(boolean repeated) {
        isRepeated = repeated;
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


}
