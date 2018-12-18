package com.sl.ue.util.spcore;

import java.util.List;

import com.sl.ue.util.spcore.impl.UserInfoServiceImpl.Users;

/**
 * 说明 [视频用户信息接口]
 * L_晓天  @2018年12月6日
 */
public interface UserInfoService {

	/**
	 * 说明 [获取单个用户信息 ]
	 * @param userName 非必传 请求查询的账号，不传默认查询自己
	 * L_晓天  @2018年12月6日
	 */
	public Users getSingleUser(String accessToken, String userName);
	
	/**
	 * 说明 [获取多个用户]
	 * @param start 非必传     查询开始记录数 默认0
	 * @param count  非必传     查询count条记录 默认15条
	 * @param busiId 非必传     0：查询本企业（默认）1：查询所有企业  其他：企业id
	 * @param like   非必传      模糊查询条件，字符允许类型：（string，int）
	 * L_晓天  @2018年12月6日
	 */
	public List<Users> getUsers(String accessToken, String start, String count, String busiId, String like);
	
	/**
	 * 说明 [新建用户账号]
	 * @param userName  用户登录账号
	 * @param userPwd    用户登录密码
	 * @param dstBusiId  非必传  用户企业id，默认为当前操作人企业
	 * @param nickName   非必传  用户昵称，默认与账号相同
	 * @param isAdmin    非必传  是否管理员 0：否（默认）1：是
	 * @param userStatus 非必传  用户状态 0：正常（默认） 1：禁用
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer addUser(String accessToken, String userName, String userPwd, String dstBusiId, 
			String nickName, String isAdmin, String userStatus);
	
	/**
	 * 说明 [修改用户账号]
	 * @param userName 用户登录账号
	 * @param userPwd 非必传 用户登录密码
	 * @param nickName 非必传 用户昵称，默认与账号相同
	 * @param isAdmin 非必传 是否管理员 0：否（默认）1：是
	 * @param userStatus 非必传 用户状态 0：正常（默认） 1：禁用
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer modifyUser(String accessToken, String userName, String userPwd, String nickName,
			String isAdmin, String userStatus);
	
	/**
	 * 说明 [删除用户账号]
	 * @param userName 用户登录账号
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer deleteUser(String accessToken, String userName);
}
