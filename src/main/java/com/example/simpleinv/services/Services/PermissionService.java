package com.example.simpleinv.services.Services;

//import com.example.simpleinv.config.JwtTokenUtil;
import com.example.simpleinv.model.Role;
import com.example.simpleinv.model.Role_Permission;
import com.example.simpleinv.model.User;
import com.example.simpleinv.repositories.Permission.PermissionRepositories;
import com.example.simpleinv.repositories.Permission_Role.PermissionRoleRepositories;
import com.example.simpleinv.repositories.Role.RoleRepositories;
import com.example.simpleinv.services.user.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

  //@Autowired
  //JwtTokenUtil jwtTokenUtil;

  @Autowired
   UserService userService;

  @Autowired
  RoleRepositories roleRepositories;

  @Autowired
  PermissionRoleRepositories permissionRoleRepositories;

  @Autowired
  PermissionRepositories permissionRepositories;

  public String getUsernameByToken(String token){
    String username = null;
    String jwtToken = null;
    jwtToken = token.substring(7);
   // username = jwtTokenUtil.getUsernameFromToken(jwtToken);
    return username;
  }

  public Integer getRoleByUsername(String username){
    Integer result = null;
    User user = userService.getUserByUsername(username);
    Optional<Role> role = roleRepositories.findRolesByRoleName(user.getRole());
    Role newRole = role.orElseThrow(()->new IllegalArgumentException("Cannot find role"));
    return newRole.getRoleId();
  }

  public List<Integer> rolePermission (Integer id){
    List<Role_Permission> role_permissions = permissionRoleRepositories.findAllByRoleId(id);
    ArrayList<Integer> result = new ArrayList<>();
    for(Role_Permission role_permission :role_permissions){
      assert false;
      result.add(role_permission.getPermissionId());
    }
    return result;
  }

  public Integer searchUrlId(String url){
    Integer a =  permissionRepositories.getUrlId(url);
    System.out.println(a);
    return a;
  }

}
