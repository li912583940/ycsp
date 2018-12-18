package com.sl.ue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {

	public static void main(String[] args){
        String[] s={"0"};
        System.out.println(s.toString());
        JSONArray j = new JSONArray();
        j.add(s);
       
		System.out.println(j.toJSONString());
	}
}
