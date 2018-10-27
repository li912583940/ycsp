package com.sl.ycsp.service.sys;

import java.util.List;
import java.util.Set;

import com.sl.ycsp.entity.sys.vo.SysResourceVO;
import com.sl.ycsp.entity.sys.vo.SysRoleVO;
import com.sl.ycsp.entity.sys.vo.SysUserVO;
import com.sl.ycsp.service.base.BaseService;

public interface SysUserService extends BaseService<SysUserVO>{

	/**
	 * 说明 [根据用户名查找其角色]
	 * @author lxt
	 */
	public List<SysRoleVO> findRoles(String username);
	
	/**
	 * 说明 [根据用户名查找其权限]
	 * @author lxt
	 */
	public List<SysResourceVO> findResource(String username);
	
	/**
	 * 说明 [查询用户角色]
	 * L_晓天  @2018年9月20日
	 */
	public List<String> getRoles(String token);
}