package com.sl.ue.util.spcore.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sl.ue.util.Config;
import com.sl.ue.util.HttpUtil;
import com.sl.ue.util.spcore.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

	private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);
	String spApiPath = Config.getPropertiesValue("spApiPath");
	
	@Override
	public Company getSingleCompany(String accessToken, String busiId) {
		String url = spApiPath+"/Open/App/getsinglecompany";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		if(StringUtils.isNotBlank(busiId)){
			params.put("busi_id", busiId);
		}
		String res = HttpUtil.post(url,params);
		System.out.println(res);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}
		Company t = json.toJavaObject(Company.class);
		return t;
	}

	@Override
	public List<Company> getCompanys(String accessToken, String start, String count, String like, String state,
			String creater) {
		String url = spApiPath+"/Open/App/getcompanys";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		if(StringUtils.isNotBlank(start)){
			params.put("start", start);
		}
		if(StringUtils.isNotBlank(count)){
			params.put("count", count);
		}
		if(StringUtils.isNotBlank(like)){
			params.put("like", like);
		}
		if(StringUtils.isNotBlank(state)){
			params.put("state", state);
		}
		if(StringUtils.isNotBlank(creater)){
			params.put("creater", creater);
		}
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		List<Company> list = new ArrayList<Company>();
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
		}else{
			JSONArray jsona = JSONArray.parseArray(res);
			for(int i=0;i<jsona.size();i++){
				if(jsona.get(i) instanceof JSONArray){
					list = JSONArray.parseArray(jsona.getString(i), Company.class);
				}
			}
		}
		return list;
	}

	@Override
	public Integer addCompany(String accessToken, String busiName, String busiContacter, String phone,
			String userName, String nickName, String userPwd, String maxUserCount, String maxConcurrentCount,
			String maxConfCount, String expireTime, String videoQuality) {
		String url = spApiPath+"/Open/App/addcompany";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("busi_name", busiName);
		params.put("busi_contacter", busiContacter);
		params.put("phone", phone);
		params.put("user_name", userName);
		params.put("nick_name", nickName);
		params.put("user_pwd", userPwd);
		params.put("max_user_count", maxUserCount);
		params.put("max_concurrent_count", maxConcurrentCount);
		params.put("max_conf_count", maxConfCount);
		params.put("expire_time", expireTime);
		params.put("video_quality", videoQuality);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	@Override
	public Integer modifyCompany(String accessToken, String busiId, String busiName, String busiContacter,
			String phone, String maxUserCount, String maxConcurrentCount, String maxConfCount, String expireTime,
			String videoQuality) {
		String url = spApiPath+"/Open/App/modifycompany";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("busi_id", busiId);
		if(StringUtils.isNotBlank(busiName)){
			params.put("busi_name", busiName);
		}
		if(StringUtils.isNotBlank(busiContacter)){
			params.put("busi_contacter", busiContacter);
		}
		if(StringUtils.isNotBlank(phone)){
			params.put("phone", phone);
		}
		if(StringUtils.isNotBlank(maxUserCount)){
			params.put("max_user_count", maxUserCount);
		}
		if(StringUtils.isNotBlank(maxConcurrentCount)){
			params.put("max_concurrent_count", maxConcurrentCount);
		}
		if(StringUtils.isNotBlank(maxConfCount)){
			params.put("max_conf_count", maxConfCount);
		}
		if(StringUtils.isNotBlank(expireTime)){
			params.put("expire_time", expireTime);
		}
		if(StringUtils.isNotBlank(videoQuality)){
			params.put("video_quality", videoQuality);
		}
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	@Override
	public Integer deleteCompany(String accessToken, String busiId) {
		String url = spApiPath+"/Open/App/deletecompany";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("busi_id", busiId);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	@Override
	public CompanyOp getCompanyOp(String accessToken, String busiId) {
		String url = spApiPath+"/Open/App/getcompanyop";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("busi_id", busiId);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}
		CompanyOp t = json.toJavaObject(CompanyOp.class);
		return t;
	}

	@Override
	public CompanyOp setCompanyOp(String accessToken, String busiId, String opUserName) {
		String url = spApiPath+"/Open/App/setcompanyop";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("busi_id", busiId);
		params.put("op_user_name", opUserName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}
		CompanyOp t = json.toJavaObject(CompanyOp.class);
		return t;
	}

	/**
	 * 说明 [企业bean]
	 * L_晓天  @2018年12月9日
	 */
	public static class Company{
		public String busi_id; 			//企业id
		public String busi_name;		//企业名称
		public String busi_contacter;	//企业联系人
		public String phone;			//联系电话
		public String user_name;		//管理员账号
		public String max_user_count;	//会议最大并发数
		public String max_conf_count;	//会议室最大数量
		public String create_time;		//创建时间
		public String expire_time;		//过期时间
	}
	
	/**
	 * 说明 [企业开户人bean]
	 * L_晓天  @2018年12月9日
	 */
	public static class CompanyOp{
		public String user_name;		//开户人账号
		public String user_friend_name;	//开户人昵称
	}
}
