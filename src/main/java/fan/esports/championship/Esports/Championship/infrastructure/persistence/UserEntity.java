package fan.esports.championship.Esports.Championship.infrastructure.persistence;

import fan.esports.championship.Esports.Championship.core.enums.UserRole;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
public class UserEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private String nickname;
    private String password;
    private Date birthday;
    private String profilePhoto;
    private UserRole role;

    public UserEntity() {
    }

    public UserEntity(String id, String name, String email, String nickname, String password, Date birthday, String profilePhoto, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.birthday = birthday;
        this.profilePhoto = profilePhoto;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", role=" + role +
                '}';
    }
}
