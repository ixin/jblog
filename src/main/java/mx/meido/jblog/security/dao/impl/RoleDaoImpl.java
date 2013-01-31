package mx.meido.jblog.security.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import mx.meido.jblog.security.dao.RoleDao;
import mx.meido.jblog.security.model.Role;
@Repository("roleDao")
public class RoleDaoImpl extends JdbcDaoSupport implements RoleDao{

	@Override
	public Role getRoleById(int roleid) {
		String sql = "select * from role where id = ?";
		Map<String, Object> roleMap = this.getJdbcTemplate().queryForMap(sql, new Object[]{roleid});
		Role role = null;
		Set<SimpleGrantedAuthority> authorities = null;
		if(roleMap != null){
			String sqlforauth = "select * from role r left join role_auth ra on r.id = ra.roleid left join authority a on ra.authid = a.id where r.id = ?";
			List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sqlforauth, new Object[]{roleid});
			if(list != null){
				authorities = new HashSet<SimpleGrantedAuthority>();
				for(Map<String, Object> map : list){
					authorities.add(new SimpleGrantedAuthority(map.get("authorityname").toString()));
				}
			}
			role = new Role(roleid, roleMap.get("rolename").toString(), roleMap.get("roledescrition").toString(), authorities);
		}
		return role;
	}

}
