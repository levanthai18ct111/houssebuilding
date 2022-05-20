package housebuilding.example.housebuilding.model;

import java.io.Serializable;

public class LoaiNha implements Serializable {
    private String id;
    private String loaiNha;
    private double giaPhantho;
    private double giaTronGio;

    public LoaiNha() {
    }

    public LoaiNha(String id, String loaiNha, double giaPhantho, double giaTronGio) {
        this.id = id;
        this.loaiNha = loaiNha;
        this.giaPhantho = giaPhantho;
        this.giaTronGio = giaTronGio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    public double getGiaPhantho() {
        return giaPhantho;
    }

    public void setGiaPhantho(double giaPhantho) {
        this.giaPhantho = giaPhantho;
    }

    public double getGiaTronGio() {
        return giaTronGio;
    }

    public void setGiaTronGio(double giaTronGio) {
        this.giaTronGio = giaTronGio;
    }

}
