package com.sl.ue.util.spcore.impl;

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
import com.sl.ue.util.spcore.OtherService;
import com.sl.ue.util.spcore.impl.UserInfoServiceImpl.Users;

@Service("otherService")
public class OtherServiceImpl implements OtherService{

	private static final Logger log = LoggerFactory.getLogger(OtherServiceImpl.class);
	String spApiPath = Config.getPropertiesValue("spApiPath");
	
	@Override
	public List<AccountLog> getAccountLog(String accessToken, String userName, String start, String count, String busiId) {
		String url = spApiPath+"/Open/App/getaccountlog";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		if(StringUtils.isNotBlank(userName)){
			params.put("user_name", userName);
		}
		if(StringUtils.isNotBlank(start)){
			params.put("start", start);
		}
		if(StringUtils.isNotBlank(count)){
			params.put("count", count);
		}
		if(StringUtils.isNotBlank(busiId)){
			params.put("busi_id", busiId);
		}
		String res = HttpUtil.post(url,params);
		System.out.println(res);
		if(res.indexOf("errcode")>0){
			JSONObject json = JSONObject.parseObject(res);
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}else{
			JSONArray jsona = JSONArray.parseArray(res);
			for(int i=0;i<jsona.size();i++){
				if(jsona.get(i) instanceof JSONArray){
					List<AccountLog> list = JSONArray.parseArray(jsona.getString(i), AccountLog.class);
					return list;
				}
			}
		}
		return null;
	}

	@Override
	public List<OnlineConf> getOnlineConf(String accessToken, String start, String count) {
		String url = spApiPath+"/Open/App/getonlineconf";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		if(StringUtils.isNotBlank(start)){
			params.put("start", start);
		}
		if(StringUtils.isNotBlank(start)){
			params.put("start", start);
		}
		if(StringUtils.isNotBlank(count)){
			params.put("count", count);
		}
		String res = HttpUtil.post(url,params);
		if(res.indexOf("errcode")>0){
			JSONObject json = JSONObject.parseObject(res);
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}else{
			JSONArray jsona = JSONArray.parseArray(res);
			for(int i=0;i<jsona.size();i++){
				if(jsona.get(i) instanceof JSONArray){
					List<OnlineConf> list = JSONArray.parseArray(jsona.getString(i), OnlineConf.class);
					return list;
				}
			}
		}
		return null;
	}

	@Override
	public Integer checkCompanyName(String accessToken, String busiName) {
		String url = spApiPath+"/Open/App/checkcompanyname";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("busi_name", busiName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return Integer.parseInt(res);
	}

	@Override
	public Integer checkUserName(String accessToken, String userName) {
		String url = spApiPath+"/Open/App/checkusername";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return Integer.parseInt(res);
	}

	@Override
	public Integer checkRoomName(String accessToken, String roomName, String busiId) {
		String url = spApiPath+"/Open/App/checkroomname";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("room_name", roomName);
		params.put("busi_id", busiId);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return Integer.parseInt(res);
	}

	@Override
	public Integer getUserLastTime(String accessToken, String userName) {
		String url = spApiPath+"/Open/App/getuserlasttime";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return Integer.parseInt(res);
	}

	@Override
	public Integer getLoginUrl(String accessToken, String userName, String userPwd, String roomId, String roomPwd) {
		String url = spApiPath+"/Open/App/getloginurl";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		params.put("user_pwd", userPwd);
		params.put("room_id", roomId);
		if(StringUtils.isNotBlank(roomPwd)){
			params.put("room_pwd", roomPwd);
		}
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return Integer.parseInt(res);
	}

	@Override
	public Integer kickUser(String accessToken, String userName, String msg, String expire) {
		String url = spApiPath+"/Open/App/kickuser";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		if(StringUtils.isNotBlank(msg)){
			params.put("msg", msg);
		}
		if(StringUtils.isNotBlank(expire)){
			params.put("expire", expire);
		}
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		if("success".equals(json.getString("result"))){
			return 0;
		}else{
			return 1;
		}
	}

	@Override
	public Integer sendMsg(String accessToken, String userName, String msg, String expire) {
		String url = spApiPath+"/Open/App/sendmsg";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		params.put("msg", msg);
		if(StringUtils.isNotBlank(expire)){
			params.put("expire", expire);
		}
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		if("success".equals(json.getString("result"))){
			return 0;
		}else{
			return 1;
		}
	}

	@Override
	public UserIsonline checkUserIsonline(String accessToken, String userName) {
		String url = spApiPath+"/Open/App/checkuserisonline";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("user_name", userName);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}
		UserIsonline t = json.toJavaObject(UserIsonline.class);
		return t;
	}

	public static class AccountLog{
		public String op_user_id;		//
		public String op_busi_id;		//
		public String dst_user_id;		//
		public String dst_busi_id;		//
		public String exec_type;		//
		public String user_name;		//
		public String user_friend_name;	//
		public String modify_time;		//
		public String busi_name;		//
	}
	
	/**
	 * 说明 [在线的会议室列表bean]
	 * L_晓天  @2018年12月10日
	 */
	public static class OnlineConf{
		public String room_id;			//会议室id
		public String room_name;		//会议室名称
		public String busi_id;			//所属企业id
	}
	
	/**
	 * 说明 [用户是否在线bean]
	 * L_晓天  @2018年12月10日
	 */
	public static class UserIsonline{
		public Info info;				//在线用户的信息
		public String isonline;			//0:离线 1：在线
	}
	
	public static class Info{
		public String user_name;		//用户名
		public String User_friend_name;	//昵称
		public String enter_time;		//登录时间
		public String room_id;			//房间id
		public String room_name;		//房间名称
		public String clt_ip_home;		//登录ip所属地
	}
}
