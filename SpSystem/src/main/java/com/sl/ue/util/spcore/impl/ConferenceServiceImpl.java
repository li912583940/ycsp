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
import com.sl.ue.util.spcore.ConferenceService;

@Service("conferenceService")
public class ConferenceServiceImpl implements ConferenceService{

	private static final Logger log = LoggerFactory.getLogger(ConferenceServiceImpl.class);
	String spApiPath = Config.getPropertiesValue("spApiPath");
	
	@Override
	public Conference getSingleConf(String accessToken, String confid) {
		String url = spApiPath+"/Open/App/getsingleconf";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("confid", confid);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return null;
		}
		Conference t = json.toJavaObject(Conference.class);
		return t;
	}


	@Override
	public List<Conference> getConfs(String accessToken, String start, String count, String busiId, String like) {
		String url = spApiPath+"/Open/App/getconfs";
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
		List<Conference> list = new ArrayList<Conference>();
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
		}else{
			JSONArray jsona = JSONArray.parseArray(res);
			for(int i=0;i<jsona.size();i++){
				if(jsona.get(i) instanceof JSONArray){
					list = JSONArray.parseArray(jsona.getString(i), Conference.class);
				}
			}
		}
		return list;
	}


	@Override
	public Integer addConf(String accessToken, Conference conference) {
		String url = spApiPath+"/Open/App/addconf";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("busi_name", conference.busi_name);
		if(StringUtils.isNotBlank(conference.busi_id)){
			params.put("dst_busi_id", conference.busi_id);
		}
		if(StringUtils.isNotBlank(conference.room_type)){
			params.put("room_type", conference.room_type);
		}
		if(StringUtils.isNotBlank(conference.room_pwd)){
			params.put("room_pwd", conference.room_pwd);
		}
		if(StringUtils.isNotBlank(conference.room_admin_pwd)){
			params.put("room_admin_pwd", conference.room_admin_pwd);
		}
		if(StringUtils.isNotBlank(conference.room_max_attenders)){
			params.put("room_max_attenders", conference.room_max_attenders);
		}
		if(StringUtils.isNotBlank(conference.room_max_speakers)){
			params.put("room_max_speakers", conference.room_max_speakers);
		}
		if(StringUtils.isNotBlank(conference.room_begin_time)){
			params.put("room_begin_time", conference.room_begin_time);
		}
		if(StringUtils.isNotBlank(conference.room_end_time)){
			params.put("room_end_time", conference.room_end_time);
		}
		if(StringUtils.isNotBlank(conference.login_auth_code)){
			params.put("login_auth_code", conference.login_auth_code);
		}
		if(StringUtils.isNotBlank(conference.room_islocked)){
			params.put("room_islocked", conference.room_islocked);
		}
		if(StringUtils.isNotBlank(conference.video_privs)){
			params.put("video_privs", conference.video_privs);
		}
		if(StringUtils.isNotBlank(conference.text_privs)){
			params.put("text_privs", conference.text_privs);
		}
		if(StringUtils.isNotBlank(conference.rec_privs)){
			params.put("rec_privs", conference.rec_privs);
		}
		if(StringUtils.isNotBlank(conference.wbd_privs)){
			params.put("wbd_privs", conference.wbd_privs);
		}
		if(StringUtils.isNotBlank(conference.scr_privs)){
			params.put("scr_privs", conference.scr_privs);
		}
		if(StringUtils.isNotBlank(conference.media_privs)){
			params.put("media_privs", conference.media_privs);
		}
		if(StringUtils.isNotBlank(conference.sync_privs)){
			params.put("sync_privs", conference.sync_privs);
		}
		if(StringUtils.isNotBlank(conference.video_quality)){
			params.put("video_quality", conference.video_quality);
		}
		if(StringUtils.isNotBlank(conference.allowed_default_attender)){
			params.put("allowed_default_attender", conference.allowed_default_attender);
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
	public Integer modifyConf(String accessToken, Conference conference) {
		String url = spApiPath+"/Open/App/modifyconf";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("room_id", conference.room_id);
		if(StringUtils.isNotBlank(conference.busi_id)){
			params.put("dst_busi_id", conference.busi_id);
		}
		if(StringUtils.isNotBlank(conference.room_type)){
			params.put("room_type", conference.room_type);
		}
		if(StringUtils.isNotBlank(conference.room_pwd)){
			params.put("room_pwd", conference.room_pwd);
		}
		if(StringUtils.isNotBlank(conference.room_admin_pwd)){
			params.put("room_admin_pwd", conference.room_admin_pwd);
		}
		if(StringUtils.isNotBlank(conference.room_max_attenders)){
			params.put("room_max_attenders", conference.room_max_attenders);
		}
		if(StringUtils.isNotBlank(conference.room_max_speakers)){
			params.put("room_max_speakers", conference.room_max_speakers);
		}
		if(StringUtils.isNotBlank(conference.room_begin_time)){
			params.put("room_begin_time", conference.room_begin_time);
		}
		if(StringUtils.isNotBlank(conference.room_end_time)){
			params.put("room_end_time", conference.room_end_time);
		}
		if(StringUtils.isNotBlank(conference.login_auth_code)){
			params.put("login_auth_code", conference.login_auth_code);
		}
		if(StringUtils.isNotBlank(conference.room_islocked)){
			params.put("room_islocked", conference.room_islocked);
		}
		if(StringUtils.isNotBlank(conference.video_privs)){
			params.put("video_privs", conference.video_privs);
		}
		if(StringUtils.isNotBlank(conference.text_privs)){
			params.put("text_privs", conference.text_privs);
		}
		if(StringUtils.isNotBlank(conference.rec_privs)){
			params.put("rec_privs", conference.rec_privs);
		}
		if(StringUtils.isNotBlank(conference.wbd_privs)){
			params.put("wbd_privs", conference.wbd_privs);
		}
		if(StringUtils.isNotBlank(conference.scr_privs)){
			params.put("scr_privs", conference.scr_privs);
		}
		if(StringUtils.isNotBlank(conference.media_privs)){
			params.put("media_privs", conference.media_privs);
		}
		if(StringUtils.isNotBlank(conference.sync_privs)){
			params.put("sync_privs", conference.sync_privs);
		}
		if(StringUtils.isNotBlank(conference.video_quality)){
			params.put("video_quality", conference.video_quality);
		}
		if(StringUtils.isNotBlank(conference.allowed_default_attender)){
			params.put("allowed_default_attender", conference.allowed_default_attender);
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
	public Integer deleteConf(String accessToken, String roomId) {
		String url = spApiPath+"/Open/App/deleteconf";
		Map<String, String> params = new HashMap<>();
		params.put("access_token", accessToken);
		params.put("room_id", roomId);
		String res = HttpUtil.post(url,params);
		JSONObject json = JSONObject.parseObject(res);
		if(json.containsKey("errcode")){
			log.error(json.getString("errcode")+":"+json.getString("errmsg"));
			return -1;
		}
		return json.getInteger("exec_result");
	}

	
	/**
	 * 说明 [会议室bean]
	 * L_晓天  @2018年12月10日
	 */
	public static class Conference{
		public String room_id;				//会议室id
		public String busi_id;				//企业id
		public String room_name;			//会议室名称
		public String room_type;			//会议类型 0：自由讨论 1：集中管理
		public String room_islocked;		//是否锁定1：是 2：否
		public String room_pwd;				//会议室密码（MD5）
		public String room_admin_pwd;		//临时管理员密码（MD5）
		public String room_max_attenders;	//最大与会人数/最大参会人数
		public String room_max_speakers;	//最大上麦人数/最大主席数
		public String room_begin_time;		//会议室有效时间（开始
		public String room_end_time;		//会议室有效时间（结束）
		public String login_auth_code;		//登录验证码（9位数有效，其他位数为无效验证码）
		public String video_privs;			//视频浏览权限 默认0：只允许管理员操作 1：只允许发言者 2：允许管理员和发言者 3：允许所有人 4：禁止所有人
		public String text_privs;			//文字消息权限 默认0：（同上）
		public String rec_privs;			//会议录制权限 默认0：（同上）
		public String wbd_privs;			//白板操作权限 默认0：（同上）
		public String scr_privs;			//屏幕共享权限 默认0：（同上）
		public String media_privs;			//媒体播放权限 默认0：（同上
		public String sync_privs;			//数据同步权限 默认0：（同上）
		public String video_quality;		//视频质量（分辨率） 默认0：不限 1：1080P 2：720P 3：800*600
		public String allowed_default_attender;//是否只允许默认与会者进入0：不限制 1：只允许默认与会者登入（管理员不受限制，需于默认与会人员设置功能联合使用）
		public String busi_name;			//企业名称
	}
}
