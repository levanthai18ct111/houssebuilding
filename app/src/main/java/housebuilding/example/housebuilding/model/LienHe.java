package housebuilding.example.housebuilding.model;

import java.io.Serializable;

public class LienHe implements Serializable {
    private String id;
    private  String name;
    private String address;
    private String phone;
    private String email;
    private String chude;
    private String noidung;
    private String date;
    private int trangthai;

    public LienHe() {
    }

    public LienHe(String id, String name, String address, String phone, String email, String chude, String noidung,String date,int trangthai) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.chude = chude;
        this.noidung = noidung;
        this.date = date;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChude() {
        return chude;
    }

    public void setChude(String chude) {
        this.chude = chude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String noidung) {
        this.date = noidung;
    }
    public int getTrangthai(){
        return trangthai;
    }
    public void setTrangthai(){
        this.trangthai=trangthai;
    }
}
