package com.sl.ue.entity.jl;


import java.util.Date;

import com.sl.ue.util.anno.DbField;
import com.sl.ue.util.anno.Id;
import com.sl.ue.util.anno.Table;

@Table("JL_JQ")
public class JlJq implements java.io.Serializable {

	/** */
	private static final long serialVersionUID = 7864514060046268897L;
	@Id
	@DbField("WebID")
	private Integer webId;
	@DbField("JQ_No")
	private String jqNo;
	@DbField("JY")
	private String jy;
	@DbField("JQ_Name")
	private String jqName;
	@DbField("Is_Ts")
	private Integer isTs;
	@DbField("Pwd")
	private String pwd;
	@DbField("UseTimeLen")
	private Integer useTimeLen;
	@DbField("LastTime")
	private Date lastTime;

	public Integer getWebId() {
		return this.webId;
	}

	public void setWebId(Integer webId) {
		this.webId = webId;
	}

	public String getJqNo() {
		return this.jqNo;
	}

	public void setJqNo(String jqNo) {
		this.jqNo = jqNo;
	}

	public String getJy() {
		return this.jy;
	}

	public void setJy(String jy) {
		this.jy = jy;
	}

	public String getJqName() {
		return this.jqName;
	}

	public void setJqName(String jqName) {
		this.jqName = jqName;
	}

	public Integer getIsTs() {
		return this.isTs;
	}

	public void setIsTs(Integer isTs) {
		this.isTs = isTs;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getUseTimeLen() {
		return this.useTimeLen;
	}

	public void setUseTimeLen(Integer useTimeLen) {
		this.useTimeLen = useTimeLen;
	}

	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

}