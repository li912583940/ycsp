package com.sl.ue.entity.jl.vo;

import com.sl.ue.entity.jl.JlJq;

public class JlJqVO extends JlJq{

    /** 序列化 */
    private static final long serialVersionUID = 1L;

    /** 监区会见星期日 */
    private String jqWeek;

    public String getJqWeek() {
		return jqWeek;
	}

	public void setJqWeek(String jqWeek) {
		this.jqWeek = jqWeek;
	}

    /*---------------------------  处理关联表  -----------------------------*/

	private String leftJoinField; // 关联表字段

    private String leftJoinTable; // 关联表

    private String leftJoinWhere; // 关联表条件

    public String getLeftJoinField() {
        return leftJoinField;
    }

    public void setLeftJoinField(String leftJoinField) {
        this.leftJoinField = leftJoinField;
    }

    public String getLeftJoinTable() {
        return leftJoinTable;
    }

    public void setLeftJoinTable(String leftJoinTable) {
        this.leftJoinTable = leftJoinTable;
    }

    public String getLeftJoinWhere() {
        return leftJoinWhere;
    }

    public void setLeftJoinWhere(String leftJoinWhere) {
        this.leftJoinWhere = leftJoinWhere;
    }


}
