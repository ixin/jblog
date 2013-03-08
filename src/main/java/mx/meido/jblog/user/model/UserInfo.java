package mx.meido.jblog.user.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import mx.meido.jblog.security.model.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements UserDetails,Serializable{
 
	private String username;
	private String password;
	private Role role;
	private Set<SimpleGrantedAuthority> authorities;
	private String nickname;
	private String email;
	private String url;
	private java.util.Date registered;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (authorities == null) {
			authorities = new HashSet<SimpleGrantedAuthority>();
			if(role != null){
				authorities = role.getAuthorities();
			}
		}
		return authorities;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean isAccountNonExpired() {
		return this.isAccountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	public boolean isEnabled() {
		return this.isEnabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public java.util.Date getRegistered() {
		return registered;
	}

	public void setRegistered(java.util.Date registered) {
		this.registered = registered;
	}

	public void setAuthorities(Set<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public UserInfo(String username, String password, Role role,
			Set<SimpleGrantedAuthority> authorities, String nickname,
			String email, String url, java.util.Date registered,
			boolean isAccountNonExpired, boolean isAccountNonLocked,
			boolean isCredentialsNonExpired, boolean isEnabled) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.authorities = authorities;
		this.nickname = nickname;
		this.email = email;
		this.url = url;
		this.registered = registered;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}

	public UserInfo() {
		super();
	}

}
