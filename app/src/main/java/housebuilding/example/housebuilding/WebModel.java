package housebuilding.example.housebuilding;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.io.Serializable;

public class WebModel implements Serializable {
    private String title,url;
    private int img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WebModel() {
    }

    public WebModel(String title, String url, int img) {
        this.title = title;
        this.url = url;
        this.img = img;
    }



}
