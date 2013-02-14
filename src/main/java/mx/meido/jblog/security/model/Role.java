package mx.meido.jblog.security.model;

import java.io.Serializable;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Role implements Serializable{
	private int id;
	private String roleName;
	private String roleDescrition;
	private Set<SimpleGrantedAuthority> authorities;
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescrition() {
		return roleDescrition;
	}

	public void setRoleDescrition(String roleDescrition) {
		this.roleDescrition = roleDescrition;
	}

	public Set<SimpleGrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Role(int id, String roleName, String roleDescrition,
			Set<SimpleGrantedAuthority> authorities) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.roleDescrition = roleDescrition;
		this.authorities = authorities;
	}

	public Role() {
		super();
	}

}
