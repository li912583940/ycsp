package com.sl.ue.util.spcore;

import java.util.List;

import com.sl.ue.util.spcore.impl.ConferenceServiceImpl.Conference;

/**
 * 说明 [会议室接口]
 * L_晓天  @2018年12月6日
 */
public interface ConferenceService {

	/**
	 * 说明 [获取单个会议室信息]
	 * @param confid 请求查询的会议室id，数字类型
	 * L_晓天  @2018年12月6日
	 */
	public Conference getSingleConf(String accessToken, String confid);
	
	/**
	 * 说明 [获取多个会议室]
	 * @param start 非必传 从第start条记录开始查询，默认为0
	 * @param  count 非必传 查询count条记录（与start结合使用）默认为15
	 * @param  busiId 非必传 0：本企业 1：所有企业 xxxx:企业id
	 * @param  like 非必传 模糊查询条件，字符允许类型：（string，int）
	 * L_晓天  @2018年12月6日
	 */
	public List<Conference> getConfs(String accessToken, String start, String count, String busiId, String like);
	
	/**
	 * 说明 [创建会议室]
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer addConf(String accessToken, Conference conference);
	
	/**
	 * 说明 [修改会议室]
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer modifyConf(String accessToken, Conference conference);
	
	/**
	 * 说明 [删除会议室]
	 * @param  roomId 会议室id
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月6日
	 */
	public Integer deleteConf(String accessToken, String roomId);
	
	
}
