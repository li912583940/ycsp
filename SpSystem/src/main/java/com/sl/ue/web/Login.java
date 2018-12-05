package com.sl.ue.web;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ue.entity.sys.vo.SysUserVO;
import com.sl.ue.service.sys.SysUserService;
import com.sl.ue.util.Constants;
import com.sl.ue.util.anno.IgnoreSecurity;
import com.sl.ue.util.http.Result;
import com.sl.ue.util.http.WebContextUtil;
import com.sl.ue.util.http.token.JqRoleManager;
import com.sl.ue.util.http.token.TokenManager;
import com.sl.ue.util.http.token.TokenUser;

@RestController
public class Login extends Result{

	@Autowired
    private SysUserService sysUserSQL;
	
	/**
	 * 说明 [登录]
	 * @作者 LXT @2018年9月4日
	 */
	@RequestMapping("/login")
	@IgnoreSecurity
	public String login(String username, String password, HttpServletResponse response){
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
			this.error(error_102);
			return this.toResult();
		}
		SysUserVO user = new SysUserVO();
		user.setUserNo(username);
		user.setUserPwd(password);
		List<SysUserVO> list = sysUserSQL.findList(user);
		if(list.size()>0){
			SysUserVO loginUser = list.get(0);
			TokenManager tokenManager = new TokenManager();
			String token = tokenManager.createToken(username);
			System.out.println("token: "+token);
			loginUser.setToken(token);
			Date overdue = DateUtils.addHours(new Date(), Constants.TOKEN_EXPIRES_HOURS); // token 到期时间
			loginUser.setTokenTime(overdue);
			sysUserSQL.edit(loginUser);
			this.putJson(loginUser);
			
			// 存储监区权限
			JqRoleManager jqRoleManager = new JqRoleManager();
			if(loginUser.getIsSuper()==1){
				jqRoleManager.putJqRole(token, "admin");
			}else{
				String jqs = sysUserSQL.getJqs(loginUser);
				jqRoleManager.putJqRole(token, jqs);
			}
			return this.toResult();
		}
		this.msg("账号或密码错误");
		return this.toResult();
	}
	
	/**
	 * 说明 [登出]
	 * @作者 LXT @2018年9月4日
	 */
	@RequestMapping("/logout")
	@IgnoreSecurity
	public String logout(HttpServletRequest request){
		String token = request.getHeader(Constants.TOKEN_NAME);
		if(StringUtils.isBlank(token)){
			this.error(error_102);
			return this.toResult();
		}
		TokenManager tokenManager = new TokenManager();
		tokenManager.deleteToken(token);
		
		JqRoleManager jqRoleManager = new JqRoleManager();
		jqRoleManager.deleteJq(token);
		
		return this.toResult();
	}
}
