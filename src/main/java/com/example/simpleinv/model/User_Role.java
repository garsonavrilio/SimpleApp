package com.example.simpleinv.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "user_role")
public class User_Role implements Serializable {

  private static final long serialVersionUID = 2477828437570821862L;
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Integer id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Integer userRoleId;
  private Integer roleId;
  private Integer userId;
  private String userName;

//  @ManyToOne
//  @JoinColumn
//  private User user;

//  @ManyToOne
//  @JoinColumn
//  private Role role;

}
