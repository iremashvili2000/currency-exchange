package com.example.demo.model.response;

import javax.persistence.*;

@Entity
@Table(name="exchange")
public class Exchange {
    @Id
    private String id;
    @Column(name = "cur_code",unique = true)
    private String cur_code;
    @Column(name="cur_name",unique = true)
    private String cur_name;
    private String cur_value;
    private String cur_change;
    private String cur_image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCur_code() {
        return cur_code;
    }

    public void setCur_code(String cur_code) {
        this.cur_code = cur_code;
    }

    public String getCur_name() {
        return cur_name;
    }

    public void setCur_name(String cur_name) {
        this.cur_name = cur_name;
    }

    public String getCur_value() {
        return cur_value;
    }

    public void setCur_value(String cur_value) {
        this.cur_value = cur_value;
    }

    public String getCur_change() {
        return cur_change;
    }

    public void setCur_change(String cur_change) {
        this.cur_change = cur_change;
    }

    public String getCur_image() {
        return cur_image;
    }

    public void setCur_image(String cur_image) {
        this.cur_image = cur_image;
    }
}
