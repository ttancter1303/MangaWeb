package t3h.manga.mangaweb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Account")
public class Account {
    public Account() {
        this.avatar = "img/user/unknown.jpg";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String avatar;
    private String username;
    private String password;
    private String email;
    private String role;
    private String verificationCode;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<SavedManga> savedMangas = new HashSet<>();


}
