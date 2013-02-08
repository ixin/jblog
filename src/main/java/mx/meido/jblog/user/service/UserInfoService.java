package mx.meido.jblog.user.service;

import java.util.List;

import mx.meido.jblog.user.model.UserInfo;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInfoService extends UserDetailsService{
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
}
