package authfromscratch.demo.User;

import javax.persistence.*;

@Entity
@Table
public class UserMain {

    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;
    private String email;
    private String username;
    private String password;

    public UserMain(){}

    public UserMain(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserMain(long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String toString() {
        return String.format("User{Username : %s \nEmail : %s \nPassword : %s}", username,email,password);
    }

}
