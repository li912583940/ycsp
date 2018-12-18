package com.sl.ue.util.spcore;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sl.ue.util.spcore.impl.OtherServiceImpl.AccountLog;
import com.sl.ue.util.spcore.impl.OtherServiceImpl.OnlineConf;
import com.sl.ue.util.spcore.impl.OtherServiceImpl.UserIsonline;

public interface OtherService {

	/**
	 * 说明 [获取账号增删记录]
	 * @param accessToken
	 * @param userName  非必传   操作人账号
	 * @param start     非必传   开始记录数，默认0
	 * @param count     非必传   每次查询的记录数，默认15
	 * @param busiId    非必传   企业id
	 * @return
	 * L_晓天  @2018年12月7日
	 */
	public List<AccountLog> getAccountLog(String accessToken, String userName, String start, 
			String count, String busiId);

	/**
	 * 说明 [获取在线的会议室列表（开会中的会议室）]
	 * @param accessToken
	 * @param start   非必传   开始记录数，默认0
	 * @param count   非必传   每次查询的记录数，默认15
	 * @return
	 * L_晓天  @2018年12月7日
	 */
	public List<OnlineConf> getOnlineConf(String accessToken, String start, String count);
	
	/**
	 * 说明 [校验企业是否存在]
	 * @param accessToken
	 * @param busiName  企业名称
	 * @return -1:接口错误，0:企业不存在（企业名称未占用）,1:企业已存在（企业名称占用）
	 * L_晓天  @2018年12月7日
	 */
	public Integer checkCompanyName(String accessToken, String busiName);
	
	/**
	 * 说明 [校验用户是否存在]
	 * @param accessToken
	 * @param userName  用户名称
	 * @return -1:接口错误，0:企业不存在（企业名称未占用）,1:企业已存在（企业名称占用）
	 * L_晓天  @2018年12月7日
	 */
	public Integer checkUserName(String accessToken, String userName);
	
	/**
	 * 说明 [校验会议室名称是否重复]
	 * @param accessToken
	 * @param roomName  会议室名称
	 * @param busiId    企业id
	 * @return -1:接口错误，0:企业不存在（企业名称未占用）,1:企业已存在（企业名称占用）
	 * L_晓天  @2018年12月7日
	 */
	public Integer checkRoomName(String accessToken, String roomName, String busiId);
	
	/**
	 * 说明 [查询用户最后使用时间]
	 * @param accessToken
	 * @param userName  用户名称
	 * @return -1:接口错误，0:企业不存在（企业名称未占用）,1:企业已存在（企业名称占用）
	 * L_晓天  @2018年12月7日
	 */
	public Integer getUserLastTime(String accessToken, String userName);
	
	/**
	 * 说明 [获取客户端登录会议室url]
	 * @param accessToken
	 * @param userName   用户名称
	 * @param userPwd    用户密码
	 * @param roomId     会议室id
	 * @param roomPwd    非必传    会议室密码
	 * @return -1:接口错误，0:企业不存在（企业名称未占用）,1:企业已存在（企业名称占用）
	 * L_晓天  @2018年12月7日
	 */
	public Integer getLoginUrl(String accessToken, String userName, String userPwd, 
			String roomId, String roomPwd);
	
	/**
	 * 说明 [使用户下线]
	 * @param accessToken
	 * @param userName  用户名称
	 * @param msg       非必传   下线原因（可以不填）
	 * @param expire    非必传   格式：2016-01-01 23:59:59(默认是当前时间的5分钟后)
	 * @return -1:接口返回错误， 0:成功，1:失败
	 * L_晓天  @2018年12月7日
	 */
	public Integer kickUser(String accessToken, String userName, String msg, String expire);
	
	/**
	 * 说明 [给用户发通知信息]
	 * @param accessToken
	 * @param userName  用户名称
	 * @param msg       通知消息
	 * @param expire    非必传  格式：2016-01-01 23:59:59(默认是当前时间的5分钟后)
	 * @return
	 * L_晓天  @2018年12月7日
	 */
	public Integer sendMsg(String accessToken, String userName, String msg, String expire);
	
	/**
	 * 说明 [查询用户是否在线]
	 * @param accessToken
	 * @param userName  用户名称
	 * @return
	 * L_晓天  @2018年12月7日
	 */
	public UserIsonline checkUserIsonline(String accessToken, String userName);
}
