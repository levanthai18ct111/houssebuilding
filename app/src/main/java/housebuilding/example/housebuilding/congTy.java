package housebuilding.example.housebuilding;

import java.io.Serializable;

public class congTy implements Serializable {
    private String ten , url ;
    private int img ;

    public congTy() {
    }

    public congTy(String ten, String url, int img) {
        this.ten = ten;
        this.url = url;
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
