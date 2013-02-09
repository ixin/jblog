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
		StringBuffer sb = new StringBuffer("select * from userinfo ui where 1 = 1 ");
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
		List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sb.toString(), params);
		//此处麻烦了。。。
		for(Map<String, Object> map : list){
			map.put("ROLEID",this.getRoleNameByRoleID(Integer.valueOf(map.get("ROLEID").toString())));//借用roleid，填充角色名
			map.put("REGISTERED", new java.util.Date(((java.sql.Date)(map.get("REGISTERED"))).getTime()));
		}
		return list;
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
	@Override
	public String getRoleNameByRoleID(int roleId) {
		String sql = "select rolename from role where id = ?";
		return this.getJdbcTemplate().queryForMap(sql, new Object[]{roleId}).get("ROLENAME").toString();
	}
	@Override
	public int getPostCountByUsername(String username) {
		//TODO 表名 。。。文章表
		String sql = "select count(*) from post where username = ?";
		return this.getJdbcTemplate().queryForInt(sql, new Object[]{username});
	}
	@Override
	public Map getUserInfoByID(int id) {
		String sql = "select * from userinfo where id = ?";
		Map<String, Object> map = this.getJdbcTemplate().queryForMap(sql, new Object[]{id});
		map.put("REGISTERED", new java.util.Date(((java.sql.Date)(map.get("REGISTERED"))).getTime()));
		map.put("ROLEID",this.getRoleNameByRoleID(Integer.valueOf(map.get("ROLEID").toString())));//借用roleid，填充角色名
		return map;
	}
	
}
