package housebuilding.example.housebuilding.model;

import java.io.Serializable;

public class Admin implements Serializable {
    private String tk;
    private String mk;

    public Admin() {
    }

    public Admin(String tk, String mk) {
        this.tk = tk;
        this.mk = mk;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
}
