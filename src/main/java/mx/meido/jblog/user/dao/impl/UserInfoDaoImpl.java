package mx.meido.jblog.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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
			java.util.Date date = (java.util.Date) userMap.get("registered");
			ui = new UserInfo(username, userMap.get("password").toString(), role, null, userMap.get("nickname").toString(), userMap.get("email").toString(), userMap.get("url").toString(), date,  Integer.parseInt(userMap.get("isaccountnonexpired").toString())==0?false:true, Integer.parseInt(userMap.get("isaccountnonlocked").toString())==0?false:true, Integer.parseInt(userMap.get("iscredentialsnonexpired").toString())==0?false:true, Integer.parseInt(userMap.get("isenabled").toString())==0?false:true );
		}
		
		return ui;
	}
	@Override
	public List<Map<String, Object>> getUserInfos(UserInfo userinfo, int fromResultCount,
			int resultCountPerPage) {
		StringBuffer sb = new StringBuffer("select ui.id, ui.username, ui.nickname, ui.email, ui.url, ui.registered, ui.isaccountnonexpired, ui.isaccountnonlocked, ui.iscredentialsNonExpired, ui.isenabled from userinfo ui where 1 = 1 ");
		int paramsSize = 0;
		if(StringUtils.isNotBlank(userinfo.getUsername())){
			sb.append(" and ui.username = ? ");
			paramsSize ++;
		}
		if(StringUtils.isNotBlank(userinfo.getEmail())){
			sb.append(" and ui.email = ? ");
			paramsSize ++;
		}
		sb.append(" order by ui.registered ");
		//初始化参数数组
		Object[] params = new Object[paramsSize];
		//逆序设置参数值
		if(StringUtils.isNotBlank(userinfo.getEmail())){
			paramsSize --;
			params[paramsSize] = userinfo.getEmail();
		}
		if(StringUtils.isNotBlank(userinfo.getUsername())){
			paramsSize --;
			params[paramsSize] = userinfo.getUsername();
		}
		//执行查询
		return this.getJdbcTemplate().queryForList(sb.toString(), params);
	}
	@Override
	public int getUserInfosCount(UserInfo userinfo) {
		StringBuffer sb = new StringBuffer("select count(*) from userinfo ui where 1 = 1 ");
		int paramsSize = 0;
		if(StringUtils.isNotBlank(userinfo.getUsername())){
			sb.append(" and ui.username = ? ");
			paramsSize ++;
		}
		if(StringUtils.isNotBlank(userinfo.getEmail())){
			sb.append(" and ui.email = ? ");
			paramsSize ++;
		}
		//sb.append(" order by ui.registered ");
		//初始化参数数组
		Object[] params = new Object[paramsSize];
		//逆序设置参数值
		if(StringUtils.isNotBlank(userinfo.getEmail())){
			paramsSize --;
			params[paramsSize] = userinfo.getEmail();
		}
		if(StringUtils.isNotBlank(userinfo.getUsername())){
			paramsSize --;
			params[paramsSize] = userinfo.getUsername();
		}
		//执行查询
		return this.getJdbcTemplate().queryForInt(sb.toString(), params);
	}
	
}
