package mx.meido.jblog.user.dao.impl;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import mx.meido.jblog.security.dao.RoleDao;
import mx.meido.jblog.security.model.Role;
import mx.meido.jblog.user.dao.UserInfoDao;
import mx.meido.jblog.user.model.UserInfo;
@Repository("userInfoDao")
public class UserInfoDaoImpl extends JdbcDaoSupport implements UserInfoDao{
	@Autowired
	private RoleDao roleDao;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String sql = "select * from userinfo where username = ?";
		Map<String, Object> userMap = this.getJdbcTemplate().queryForMap(sql, new Object[]{username});
		UserInfo ui = null;
		if(userMap != null){
			int roleid = Integer.valueOf(userMap.get("roleid").toString());
			Role role = roleDao.getRoleById(roleid);
			Date date = Date.valueOf(userMap.get("registered").toString());
			ui = new UserInfo(username, userMap.get("password").toString(), role, null, userMap.get("nickname").toString(), userMap.get("email").toString(), userMap.get("url").toString(), date,  Integer.parseInt(userMap.get("isaccountnonexpired").toString())==0?false:true, Integer.parseInt(userMap.get("isaccountnonlocked").toString())==0?false:true, Integer.parseInt(userMap.get("iscredentialsnonexpired").toString())==0?false:true, Integer.parseInt(userMap.get("isenabled").toString())==0?false:true );
		}
		
		return ui;
	}
	
}
