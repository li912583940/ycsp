package com.sl.ue.util.spcore.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sl.ue.entity.sp.vo.SpAccessTokenVO;
import com.sl.ue.service.sp.SpAccessTokenService;
import com.sl.ue.util.Config;
import com.sl.ue.util.DateUtil;
import com.sl.ue.util.HttpUtil;
import com.sl.ue.util.spcore.AccessTokenService;


@Service("accessTokenService")
public class AccessTokenServiceImpl implements AccessTokenService{

	private static final Logger log = LoggerFactory.getLogger(AccessTokenServiceImpl.class);
	String spApiPath = Config.getPropertiesValue("spApiPath");
	
	@Autowired
	private SpAccessTokenService spAccessTokenSQL;
	
	@Override
	public String getAccessToken() {
		List<SpAccessTokenVO>  spAccessTokenList = spAccessTokenSQL.findList(new SpAccessTokenVO());
		if(spAccessTokenList.size()>0){
			SpAccessTokenVO t = spAccessTokenList.get(0);
			if(new Date().before(t.getDueTime())){
				return t.getAccessToken();
			}else{
				AccessToken accessToken =this.refAccessToken();
				if(accessToken != null){
					t.setAccessToken(accessToken.access_token);
					t.setDueTime(DateUtil.addSec(new Date(), accessToken.expires_in-1000));
					spAccessTokenSQL.edit(t);
					return t.getAccessToken();
				}
			}
		}else{
			AccessToken accessToken =this.refAccessToken();
			if(accessToken != null){
				SpAccessTokenVO t = new SpAccessTokenVO();
				t.setName("视频厂家token凭证");
				t.setAccessToken(accessToken.access_token);
				t.setDueTime(DateUtil.addSec(new Date(), accessToken.expires_in-1000));
				spAccessTokenSQL.add(t);
				return t.getAccessToken();
			}
		}
		return null;
	}
  
	public AccessToken refAccessToken(){
		String url = spApiPath+"/Open/App/token";
		Map<String, String> params = new HashMap<String, String>();
		params.put("application", "wh2007");
		params.put("username", "admin");
		params.put("userpwd", "123456");
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}
		AccessToken t = json.toJavaObject(AccessToken.class);
		return t;
	}
	
	public static class AccessToken{
		public String access_token;
		public Integer expires_in;
	}
	
}
