package mx.meido.jblog.common.tools;

import mx.meido.jblog.user.model.UserInfo;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {
	public static UserInfo getUserInfo(){
		SecurityContext context = SecurityContextHolder.getContext();
		if(context.getAuthentication().getPrincipal().toString().equals("anonymousUser"))
			return null;
		UserInfo userInfo = (UserInfo)context.getAuthentication().getPrincipal();
		return userInfo;
	}
}
