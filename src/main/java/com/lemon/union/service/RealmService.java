package com.lemon.union.service;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.union.auth.vo.UserVO;
import com.lemon.union.dao.UserDAO;

@Service("bmanagerService")
public class RealmService extends AuthorizingRealm {

	@Autowired
	UserDAO adminUserDAO;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		Long userId = (Long) principals.fromRealm(getName()).iterator().next();
		List<Object[]> rpList = adminUserDAO.getUserInfo(userId);
		if (rpList != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (Object[] arr : rpList) {
				info.addRole(arr[0].toString());
				info.addStringPermission(arr[1].toString());
			}
			return info;
		} else {
			return null;
		}
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		UserVO user = adminUserDAO.isUserExist(token.getUsername(), new String(
				token.getPassword()));
		if (user != null)
			return new SimpleAuthenticationInfo(user.getId(), user.getPwd(),
					getName());
		else
			return null;
	}

}
