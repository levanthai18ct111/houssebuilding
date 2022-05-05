package housebuilding.example.housebuilding.model;

public class News {
    private String body , image;
    int loai ;
    private String title;

    public News() {
    }

    public News(String body, String image, int loai, String title) {
        this.body = body;
        this.image = image;
        this.loai = loai;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "body='" + body + '\'' +
                ", image='" + image + '\'' +
                ", loai=" + loai +
                ", title='" + title + '\'' +
                '}';
    }
}
