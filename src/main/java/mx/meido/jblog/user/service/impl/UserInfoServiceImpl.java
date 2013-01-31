package mx.meido.jblog.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.meido.jblog.user.dao.UserInfoDao;
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

}
