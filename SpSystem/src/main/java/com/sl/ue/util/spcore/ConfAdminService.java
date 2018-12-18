package com.sl.ue.util.spcore;

import java.util.List;

import com.sl.ue.util.spcore.impl.ConfAdminServiceImpl.Companys;
import com.sl.ue.util.spcore.impl.ConfAdminServiceImpl.ConfAdmin;

/**
 * 说明 [会议室管理员]
 * L_晓天  @2018年12月10日
 */
public interface ConfAdminService {

	/**
	 * 说明 [获取会议室管理员列表]
	 * @param roomId 会议室id
	 * L_晓天  @2018年12月6日
	 */
	public List<ConfAdmin> getConfAdmins(String accessToken, String roomId);
	
	
	/**
	 * 说明 [设置会议室管理员 ]
	 * @param accessToken
	 * @param roomId 会议室id
	 * @param userName 用户名称
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer setConfAdmin(String accessToken, String roomId, String userName);
	

	/**
	 * 说明 [取消会议室管理员]
	 * @param accessToken
	 * @param roomId 会议室id
	 * @param userName 用户名称
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer unsetconfadmin(String accessToken, String roomId, String userName);
	
	/**
	 * 说明 [设置会议室默认与会者]
	 * @param accessToken
	 * @param roomId 会议室id
	 * @param userName 用户名称
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer setConfAttender(String accessToken, String roomId, String userName);
	
	/**
	 * 说明 [取消会议室默认与会者]
	 * @param accessToken
	 * @param roomId 会议室id
	 * @param userName 用户名称
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer unsetConfAttender(String accessToken, String roomId, String userName);
	
	/**
	 * 说明 [获取会议室在线人数]
	 * @param accessToken
	 * @param roomId
	 * @return -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer getOnlineCount(String accessToken, String roomId);
	
	/**
	 * 说明 [查询会议室使用情况（查询统计）]
	 * @param accessToken
	 * @param start 非必须 默认0，查询开始记录数
	 * @param count 非必须 默认15，查询记录数
	 * @param starttime 查询时间（开始时间）
	 * @param endtime 查询时间（结束时间）
	 * @param join 非必须 默认1：查询开会数据 0：查询未开会数据
	 * @return
	 * L_晓天  @2018年12月6日
	 */
	public List<Companys> queryCompany(String accessToken, String start, String count, 
			String starttime, String endtime, String join);
}
