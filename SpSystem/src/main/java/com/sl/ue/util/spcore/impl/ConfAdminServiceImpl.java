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
import com.sl.ue.util.spcore.ConfAdminService;

@Service("confAdminService")
public class ConfAdminServiceImpl implements ConfAdminService{

	private static final Logger log = LoggerFactory.getLogger(ConfAdminServiceImpl.class);
	
	String spApiPath = Config.getPropertiesValue("spApiPath");
	
	@Override
	public List<ConfAdmin> getConfAdmins(String accessToken, String roomId) {
		String url = spApiPath+"/Open/App/getconfadmins";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("room_id", roomId);
		String res = HttpUtil.post(url,params);
		
		System.out.println(res);
		JSONObject json = JSONObject.parseObject(res);
		List<ConfAdmin> list = new ArrayList<ConfAdmin>();
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
		}else{
			JSONArray jsona = JSONArray.parseArray(res);
			for(int i=0;i<jsona.size();i++){
				if(jsona.get(i) instanceof JSONArray){
					list = JSONArray.parseArray(jsona.getString(i), ConfAdmin.class);
				}
			}
		}
		return list;
	}

	@Override
	public Integer setConfAdmin(String accessToken, String roomId, String userName) {
		String url = spApiPath+"/Open/App/setconfadmin";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("room_id", roomId);
		params.put("user_name", userName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	@Override
	public Integer unsetconfadmin(String accessToken, String roomId, String userName) {
		String url = spApiPath+"/Open/App/unsetconfadmin";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("room_id", roomId);
		params.put("user_name", userName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	@Override
	public Integer setConfAttender(String accessToken, String roomId, String userName) {
		String url = spApiPath+"/Open/App/setconfattender";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("room_id", roomId);
		params.put("user_name", userName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	@Override
	public Integer unsetConfAttender(String accessToken, String roomId, String userName) {
		String url = spApiPath+"/Open/App/unsetconfattender";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("room_id", roomId);
		params.put("user_name", userName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	@Override
	public Integer getOnlineCount(String accessToken, String roomId) {
		String url = spApiPath+"/Open/App/getonlinecount";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("room_id", roomId);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("onlinecount");
	}

	@Override
	public List<Companys> queryCompany(String accessToken, String start, String count, String starttime, String endtime,
			String join) {
		String url = spApiPath+"/Open/App/querycompany";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		if(StringUtils.isNotBlank(start)){
			params.put("start", start);
		}
		if(StringUtils.isNotBlank(count)){
			params.put("count", count);
		}
		params.put("starttime", starttime);
		params.put("endtime", endtime);
		if(StringUtils.isNotBlank(join)){
			params.put("join", join);
		}
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return new ArrayList<Companys>();
		}else{
			JSONArray jsona = JSONArray.parseArray(res);
			for(int i=0;i<jsona.size();i++){
				if(jsona.get(i) instanceof JSONArray){
					List<Companys> list = JSONArray.parseArray(jsona.getString(i), Companys.class);
					return list;
				}
			}
		}
		return new ArrayList<Companys>();
	}

	/**
	 * 说明 [会议室管理员bean]
	 * L_晓天  @2018年12月10日
	 */
	public static class ConfAdmin{
		public String room_id;			//会议室id
		public String busi_id;			//企业id
		public String user_id;			//用户id
		public String user_name;		//用户名称
		public String User_friend_name;	//用户昵称
	}
	
	/**
	 * 说明 [查询会议室使用情况bean]
	 * L_晓天  @2018年12月10日
	 */
	public static class Companys{
		public String busi_id;			//企业id
	}
}
