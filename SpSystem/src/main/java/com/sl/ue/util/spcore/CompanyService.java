package com.sl.ue.util.spcore;

import java.util.List;

import com.sl.ue.util.spcore.impl.CompanyServiceImpl.Company;
import com.sl.ue.util.spcore.impl.CompanyServiceImpl.CompanyOp;

/**
 * 说明 [视频企业信息接口]
 * L_晓天  @2018年12月7日
 */
public interface CompanyService {

	
	/**
	 * 说明 [获取单个企业信息]
	 * @param accessToken
	 * @param busiId 非必须   企业id
	 * @return
	 * L_晓天  @2018年12月7日
	 */
	public Company getSingleCompany(String accessToken, String busiId);
	
	/**
	 * 说明 [获取企业列表信息]
	 * @param accessToken
	 * @param start    非必须  查询起始记录
	 * @param count    非必须  每次查询的记录数
	 * @param like     非必须  模糊查询条件，字符允许类型：（string，int）
	 * @param state    非必须  1：查询过期企业 2：查询未过期企业3：查询即将到期企业（一周内）
	 * @param creater  非必须  开户人
	 * @return
	 * L_晓天  @2018年12月7日
	 */
	public List<Company> getCompanys(String accessToken, String start, String count, String like, 
			String state, String creater);
	
	/**
	 * 说明 [创建企业]
	 * @param accessToken
	 * @param busiName       企业名称
	 * @param busiContacter  联系人
	 * @param phone          联系电话
	 * @param userName       企业管理账号
	 * @param nickName       账号昵称
	 * @param userPwd        账号密码
	 * @param maxUserCount   账号数
	 * @param maxConcurrentCount   最大会议并发数
	 * @param maxConfCount   最大会议室数量
	 * @param expireTime     到期时间
	 * @param videoQuality   最大分辨率0：不限1：1080P 2：720P 3：800*600
	 * @return  0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月7日
	 */
	public Integer addCompany(String accessToken, String busiName, String busiContacter,
			String phone, String userName, String nickName, String userPwd, String maxUserCount,
			String maxConcurrentCount, String maxConfCount, String expireTime, String videoQuality);
	
	/**
	 * 说明 [修改企业信息]
	 * @param accessToken
	 * @param busiId          企业id
	 * @param busiName        非必须   企业名称
	 * @param busiContacter   非必须   联系人
	 * @param phone           非必须   联系电话
	 * @param maxUserCount    非必须   账号数
	 * @param maxConcurrentCount   非必须   最大会议并发数
	 * @param maxConfCount    非必须   最大会议室数量
	 * @param expireTime      非必须   到期时间
	 * @param videoQuality    非必须   最大分辨率0：不限1：1080P 2：720P 3：800*600
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月7日
	 */
	public Integer  modifyCompany(String accessToken, String busiId,String busiName, String busiContacter,
			String phone, String maxUserCount,
			String maxConcurrentCount, String maxConfCount, String expireTime, String videoQuality);
	
	/**
	 * 说明 [删除企业]
	 * @param accessToken
	 * @param busiId  企业id
	 * @return 0：创建成功 -1：创建失败
	 * L_晓天  @2018年12月7日
	 */
	public Integer deleteCompany(String accessToken, String busiId);
	
	/**
	 * 说明 [获取企业开户人（业务员）]
	 * @param accessToken
	 * @param busiId  企业id
	 * @return
	 * L_晓天  @2018年12月7日
	 */
	public CompanyOp getCompanyOp(String accessToken, String busiId);
	
	/**
	 * 说明 [修改企业开户人（业务员）]
	 * @param accessToken
	 * @param busiId      企业id
	 * @param opUserName  开户人账号
	 * @return
	 * L_晓天  @2018年12月7日
	 */
	public CompanyOp setCompanyOp(String accessToken, String busiId, String opUserName);
}
