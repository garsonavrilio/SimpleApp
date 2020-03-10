package com.example.simpleinv.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;


@Data
@Entity
@Table(name = "permission_table")
public class Permission {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer permission_id;
  private String name;

//  @OneToMany(mappedBy = "permission")
//  List<Role_Permission> role_permissions;
}
