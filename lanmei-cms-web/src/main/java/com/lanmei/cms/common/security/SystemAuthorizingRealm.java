package com.lanmei.cms.common.security;

import com.lanmei.admin.dao.model.CmsAdmin;
import com.lanmei.admin.service.CmsAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自定义shiro 的realm 
 * realm：域，Shiro从从Realm获取安全数据（如用户、角色、权限），就是说SecurityManager要验证用户身份，
 * 那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法；也需要从Realm得到用户相应的角色/权限进行
 * 验证用户是否能进行操作；可以把Realm看成DataSource，即安全数据源
 * @author lgj
 *
 */

public class SystemAuthorizingRealm extends AuthorizingRealm  {

	private final static Logger logger = LoggerFactory.getLogger("SystemAuthorizingRealm.class");	
	{
		logger.debug("SystemAuthorizingRealm Create Bean............. ");
	}
	
	@Autowired
    CmsAdminService adminService;
	
	/**
	 * 权限验证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		logger.debug("into doGetAuthorizationInfo....");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		info.addRole("usertest");
		info.addStringPermission("sad");
		/*info.addRole("user");*/
		return info;
	}

	/**
	 * 登录验证
	 */

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		logger.debug("into doGetAuthenticationInfo....");
		
		String loginJobNum = token.getPrincipal().toString();
	    String password  = token.getCredentials().toString();
		CmsAdmin admin = null;
		
		admin = adminService.getAdminByJobnum(loginJobNum);
		if(admin != null) {
			logger.debug("查询到用户");
		}
		else {
			logger.debug("未查询到用户");
			throw new UnknownAccountException();
		}
		System.out.println("密码：" +   admin.getAdminPassword() + "\r\ntoken 密码：" + password
		                     + "  盐：" +  admin.getPasswordSalt() + "  工号：" +  admin.getLoginJobnum());
		SimpleAuthenticationInfo authenticationInfo 
			= new SimpleAuthenticationInfo(admin,admin.getAdminPassword(),
					ByteSource.Util.bytes(admin.getPasswordSalt()),admin.getLoginJobnum());
		
		this.setSession("currentUser", admin.getAdminId());
		
		return authenticationInfo;
	}	
	
	/** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }  
}
