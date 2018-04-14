package com.cetech.listviewentries.model;

import android.support.annotation.DrawableRes;

/**
 * Created by oemy9 on 08/04/2018.
 */

public class Contact {

    private String name;
    private String phone;
    private String email;
    @DrawableRes
    private int photo;

    public Contact (String name, String phone, String email, int photo) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public int getPhoto () {
        return photo;
    }

    public void setPhoto (int photo) {
        this.photo = photo;
    }
}
