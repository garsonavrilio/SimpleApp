package com.example.simpleinv.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import lombok.Data;

import javax.persistence.*;
import lombok.ToString;

@Data
@Entity
@Table(name = "user_table")
@ToString(callSuper = true)
public class User implements Serializable {

    private static final long serialVersionUID = 6513800620961659211L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private String fullname;
    private String gender;
    private String role;

//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private List<User_Role> user_roles;

}
