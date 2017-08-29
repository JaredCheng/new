package model;

public class New {
    private int newid;
    private String context;
    private String author;
    private String pic;
    private String createTime;
    private String title;
    private int newlevel;

    public New(int newid, String context, String author, String pic, String createTime, String title, int newlevel) {
        this.newid = newid;
        this.context = context;
        this.author = author;
        this.pic = pic;
        this.createTime = createTime;
        this.title = title;
        this.newlevel = newlevel;
    }

    public New() {
    }

    public int getNewid() {
        return newid;
    }

    public void setNewid(int newid) {
        this.newid = newid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNewlevel() {
        return newlevel;
    }

    public void setNewlevel(int newlevel) {
        this.newlevel = newlevel;
    }
}
