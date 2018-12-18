package com.sl.ue.web.sp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sl.ue.util.HttpUtil;
import com.sl.ue.util.anno.IgnoreSecurity;
import com.sl.ue.util.http.Result;
import com.sl.ue.util.spcore.CompanyService;
import com.sl.ue.util.spcore.ConfAdminService;
import com.sl.ue.util.spcore.OtherService;
import com.sl.ue.util.spcore.UserInfoService;
import com.sl.ue.util.spcore.impl.CompanyServiceImpl.Company;
import com.sl.ue.util.spcore.impl.ConfAdminServiceImpl.ConfAdmin;
import com.sl.ue.util.spcore.impl.OtherServiceImpl.AccountLog;
import com.sl.ue.util.spcore.impl.UserInfoServiceImpl.Users;

@RestController
@RequestMapping("/apiWeb")
public class ApiWeb extends Result {

	@Autowired
	private ConfAdminService confAdminService;
	
	
	@RequestMapping("/getAppToken")
	@IgnoreSecurity
	public String getAppToken() {
		String url = "http://127.0.0.1:13000/Open/App/token?application=wh2007&username=admin&userpwd=123456";
		String res = HttpUtil.get(url);
		System.out.println(res);
		this.putJson(res);
		return this.toResult();
	}
	
	@RequestMapping("/getUsers")
	@IgnoreSecurity
	public String getUsers(String token){
		List<ConfAdmin> list = confAdminService.getConfAdmins(token, null);
		return JSONObject.toJSONString(list);
	}
}
