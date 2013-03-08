package mx.meido.jblog.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.meido.jblog.user.dao.UserInfoDao;
import mx.meido.jblog.user.model.UserInfo;
import mx.meido.jblog.user.service.UserInfoService;
@Service("userInfoService") 
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao userInfoDao;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userInfoDao.loadUserByUsername(username);
	}
	public List<Map<String, Object>> getUserInfos(UserInfo userinfo, int fromResultCount,
			int resultCountPerPage) {
		List<Map<String, Object>> list =  userInfoDao.getUserInfos(userinfo, fromResultCount, resultCountPerPage);
		//此处麻烦了。。。
		for(Map<String, Object> map : list){
			map.put("roleid",this.getRoleByRoleID(Integer.valueOf(map.get("roleid").toString())).get("roledescrition"));//借用roleid，填充角色名
			map.put("registered", new java.util.Date(((java.sql.Date)(map.get("registered"))).getTime()));
		}
		return list;
	}
	public int getUserInfosCount(UserInfo userinfo) {
		return userInfoDao.getUserInfosCount(userinfo);
	}
	public Map<String, Object> getUserInfoByID(int id) {
		Map<String, Object> userinfo = userInfoDao.getUserInfoByID(id);
		if(userinfo != null){
			userinfo.put("registered", new java.util.Date(((java.sql.Date)(userinfo.get("registered"))).getTime()));
			userinfo.put("roleid",this.getRoleByRoleID(Integer.valueOf(userinfo.get("roleid").toString())).get("roledescrition"));//借用roleid，填充角色名
		}
		return userinfo;
	}
	public Map<String, Object> getRoleByRoleID(int roleId) {
		return userInfoDao.getRoleByRoleID(roleId);
	}

}
