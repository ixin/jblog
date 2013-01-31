package mx.meido.jblog.user.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserInfoDao {
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
}
