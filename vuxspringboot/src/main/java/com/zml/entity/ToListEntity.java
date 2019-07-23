package com.zml.entity;

import javax.persistence.*;

@Entity
@Table(name = "to_list_entity")
public class ToListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String title;
    @Column(name = "is_checked")
    private int isChecked;
    @Column(name = "is_even")
    private int isEven=0;

    public ToListEntity() {
    }

    public ToListEntity(int id, String title, int isChecked) {
        this.id = id;
        this.title = title;
        this.isChecked = isChecked;
    }

    public int getIsEven() {
        return isEven;
    }

    public void setIsEven(int isEven) {
        this.isEven = isEven;
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

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }
}
