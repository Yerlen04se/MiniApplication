package intern.dev.App.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    // fields
    @Id
    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "repeated_password")
    private String repeatedPassword;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "image_link")
    private String imgLink;

    @Column(name = "active")
    private int active;

    // constructor

    public User(){
        this.active = 1;
    }

    public User(String loginId, String password, String repeatedPassword, String fullName, String imgLink) {
        this.loginId = loginId;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.fullName = fullName;
        this.imgLink = imgLink;
        this.active = 1;
    }

    // getter & setter


    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", repeatedPassword='" + repeatedPassword + '\'' +
                ", fullName='" + fullName + '\'' +
                ", imgLink='" + imgLink + '\'' +
                '}';
    }
}
