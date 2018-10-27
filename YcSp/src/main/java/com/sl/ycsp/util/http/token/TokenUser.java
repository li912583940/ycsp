package com.sl.ycsp.util.http.token;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sl.ycsp.entity.sys.vo.SysUserVO;
import com.sl.ycsp.service.sys.SysUserService;
import com.sl.ycsp.util.Constants;
import com.sl.ycsp.util.component.SpringTool;
import com.sl.ycsp.util.http.WebContextUtil;

/**
 * 说明 [登陆用户]
 * L_晓天  @2018年10月10日
 */
public class TokenUser {
	
	/**
	 * 说明 [根据登录者token获取用户信息]
	 * L_晓天  @2018年10月10日
	 */
	public static SysUserVO getUser(){
		SysUserService sysUserSQL = (SysUserService) SpringTool.getBean("sysUserSQL");
		// 从 request header 中获取当前 token
		String token = WebContextUtil.getRequest().getHeader(Constants.TOKEN_NAME);
		SysUserVO sysUser = new SysUserVO();
		sysUser.setToken(token);
		List<SysUserVO> userList = sysUserSQL.findList(sysUser);
		if(userList.size()>0){
			return userList.get(0);
		}
		return new SysUserVO();
	}
}
