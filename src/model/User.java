package model;

public class User {

    private String username;
    private String password;
    private String id;
    private String addr;
    private int glass;
    private String tel;
    private String auth;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", addr='" + addr + '\'' +
                ", glass=" + glass +
                ", tel='" + tel + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }


    public User(String username, String password, String id, String addr, int glass, String tel) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.addr = addr;
        this.glass = glass;
        this.tel = tel;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getGlass() {
        return glass;
    }

    public void setGlass(int glass) {
        this.glass = glass;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}