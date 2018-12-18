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
import com.sl.ue.util.spcore.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{

	private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	String spApiPath = Config.getPropertiesValue("spApiPath");
	
	@Override
	public Users getSingleUser(String accessToken, String userName) {
		String url = spApiPath+"/Open/App/getsingleuser";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		if(StringUtils.isNotBlank(userName)){
			params.put("user_name", userName);
		}
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}else{
			Users user = json.toJavaObject(Users.class);
			return user;
		}
	}

	@Override
	public List<Users> getUsers(String accessToken, String start, String count, String busiId, String like) {
		String url = spApiPath+"/Open/App/getusers";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		if(StringUtils.isNotBlank(start)){
			params.put("start", start);
		}
		if(StringUtils.isNotBlank(count)){
			params.put("count", count);
		}
		if(StringUtils.isNotBlank(busiId)){
			params.put("busi_id", busiId);
		}
		if(StringUtils.isNotBlank(like)){
			params.put("like", like);
		}
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		List<Users> list = new ArrayList<Users>();
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
		}else{
			JSONArray jsona = JSONArray.parseArray(res);
			for(int i=0;i<jsona.size();i++){
				if(jsona.get(i) instanceof JSONArray){
					list = JSONArray.parseArray(jsona.getString(i), Users.class);
				}
			}
		}
		return list;
	}

	@Override
	public Integer addUser(String accessToken, String userName, String userPwd, String dstBusiId, String nickName,
			String isAdmin, String userStatus) {
		String url = spApiPath+"/Open/App/adduser";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		params.put("user_pwd", userPwd);
		if(StringUtils.isNotBlank(dstBusiId)){
			params.put("dst_busi_id", dstBusiId);
		}
		if(StringUtils.isNotBlank(nickName)){
			params.put("nick_name", nickName);
		}
		if(StringUtils.isNotBlank(isAdmin)){
			params.put("is_admin", isAdmin);
		}
		if(StringUtils.isNotBlank(userStatus)){
			params.put("user_status", userStatus);
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
	public Integer modifyUser(String accessToken, String userName, String userPwd, String nickName, String isAdmin,
			String userStatus) {
		String url = spApiPath+"/Open/App/modifyuser";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		if(StringUtils.isNotBlank(userPwd)){
			params.put("user_pwd", userPwd);
		}
		if(StringUtils.isNotBlank(nickName)){
			params.put("nick_name", nickName);
		}
		if(StringUtils.isNotBlank(isAdmin)){
			params.put("is_admin", isAdmin);
		}
		if(StringUtils.isNotBlank(userStatus)){
			params.put("user_status", userStatus);
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
	public Integer deleteUser(String accessToken, String userName) {
		String url = spApiPath+"/Open/App/deleteuser";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	public static class Users{
		public String user_id;			//用户在企业中的id
		public String busi_id;			//企业id 
		public String user_name;		//登录账号
		public String user_friend_name;	//昵称
		public String is_sys_admin;		//是否为企业管理员1：是 2：否
		public String user_pwd;			//登录密码（MD5）
		public String user_status;		//账号状态 0：正常 1：禁用
		public String user_create_time;	//账号创建时间
		public String user_modify_time;	//信息修改时间
		public String user_token;		//企业名称
	}
}
