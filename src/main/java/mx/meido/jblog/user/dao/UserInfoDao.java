package mx.meido.jblog.user.dao;

import java.util.List;
import java.util.Map;

import mx.meido.jblog.user.model.UserInfo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserInfoDao {
	/**
	 * 验证用户
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
	/**
	 * 获取用户信息列表
	 * @param userinfo
	 * @param fromResultCount
	 * @param resultCountPerPage
	 * @return
	 */
	public List getUserInfos(UserInfo userinfo, int fromResultCount, int resultCountPerPage);
	/**
	 * 获取信息总数
	 * @param userinfo
	 * @return
	 */
	public int getUserInfosCount(UserInfo userinfo);
	
	public int getPostCountByUsername(String username);
	
	public Map getUserInfoByID(int id);
	
	public Map getRoleByRoleID(int roleId);
}
