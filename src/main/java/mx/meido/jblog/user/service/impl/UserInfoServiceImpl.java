package mx.meido.jblog.user.service.impl;

import java.util.List;

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
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userInfoDao.loadUserByUsername(username);
	}
	@Override
	public List getUserInfos(UserInfo userinfo, int fromResultCount,
			int resultCountPerPage) {
		return userInfoDao.getUserInfos(userinfo, fromResultCount, resultCountPerPage);
	}
	@Override
	public int getUserInfosCount(UserInfo userinfo) {
		return userInfoDao.getUserInfosCount(userinfo);
	}

}
