package com.example.simpleinv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Embedded.Nullable;

@Data
@Entity
@Table(name = "role_permission_table")
public class Role_Permission implements Serializable {

  private static final long serialVersionUID = 931184254925338031L;
  //  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Integer rolePermissionId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Integer rolePermissionId;
  private Integer roleId;
  private Integer permissionId;

//  @JoinColumn(foreignKey = @ForeignKey(name = "FK_ROLE"))
//  @ManyToOne
//  Role role;
//
//  @JoinColumn(foreignKey = @ForeignKey(name = "FK_permission"))
//  @ManyToOne
//  Permission permission;

}
