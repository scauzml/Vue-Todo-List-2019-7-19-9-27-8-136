package com.zml.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "to_list_entity")
public class ToListEntity {
    @Id
    private int id;
    private String title;
    @Column(name = "is_checked")
    private int isChecked;

    public ToListEntity() {
    }

    public ToListEntity(int id, String title, int isChecked) {
        this.id = id;
        this.title = title;
        this.isChecked = isChecked;
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
