package com.weblog.shiro;

import com.weblog.dao.PerimissionMapper;
import com.weblog.dao.RolesMapper;
import com.weblog.dao.UserMapper;
import com.weblog.pojo.Perimission;
import com.weblog.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义realm
 */
public class Realm extends AuthorizingRealm {
    @Autowired
    UserMapper userDao;
    @Autowired
    RolesMapper roleDao;
    @Autowired
    PerimissionMapper permissionDao;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权开始");
        //获取token的主身份(登录的username
        User userObject=(User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据角色获取当前权限
        List<User> users = userDao.getPermissionsByUserId(userObject.getUserId());
        System.out.println("给用户添加权限");
        for(User user:users) {
            List<Perimission> perimissions = user.getPermission();
            for(Perimission perimission:perimissions){
                info.addStringPermission(perimission.getPermissionName());
            }
        }
        System.out.println("打印"+info.getStringPermissions().toString());
        System.out.println("授权结束");
        return info;

    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("token.getPrincipal:" + token.getPrincipal());
        System.out.println("token.getCredentials:" + token.getCredentials());
        //从token中取出用户名
        String userName = token.getPrincipal().toString();
        //根据用户名从数据库查询
        User user = userDao.getUserByUserName(userName);
        System.out.println("user:"+user.getUserName());
        if (user == null) {
            return null;
        }
        //判断密码
        return new SimpleAuthenticationInfo(user, user.getUserPwd(), "");

    }
}
