package com.sl.ue.util.spcore;

import com.sl.ue.util.spcore.impl.AccessTokenServiceImpl.AccessToken;

public interface AccessTokenService {

	/**
	 * 说明 [获取视频接口token 返回值：token]
	 * L_晓天  @2018年12月5日
	 */
	public String getAccessToken();
	
	/**
	 * 说明 [更新视频接口token 返回值：结果集]
	 * L_晓天  @2018年12月6日
	 */
	public AccessToken refAccessToken();
	
	
}
