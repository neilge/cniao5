package io.neo.model;

import java.io.Serializable;

/**
 * @author Neo
 * @since 10/10/2020-6:34 PM
 */
public class Account implements Serializable {

    private long id;
    private String mobi;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobi() {
        return mobi;
    }

    public void setMobi(String mobi) {
        this.mobi = mobi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", mobi='" + mobi + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
