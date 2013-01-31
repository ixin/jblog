package mx.meido.jblog.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.meido.jblog.security.dao.RoleDao;
import mx.meido.jblog.security.model.Role;
import mx.meido.jblog.security.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	@Override
	public Role getRoleById(int roleid) {
		return roleDao.getRoleById(roleid);
	}

}
