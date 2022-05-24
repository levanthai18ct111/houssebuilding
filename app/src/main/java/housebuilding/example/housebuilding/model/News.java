package housebuilding.example.housebuilding.model;

public class News {
    private String id;
    private String body , image;
    private  int loai ;
    private String title;
    private String lh;
    private String date;

    public News() {
    }

    public News(String id, String body, String image, int loai, String title, String lh, String date) {
        this.id = id;
        this.body = body;
        this.image = image;
        this.loai = loai;
        this.title = title;
        this.lh = lh;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLh() {
        return lh;
    }

    public void setLh(String lh) {
        this.lh = lh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
