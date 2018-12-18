package com.sl.ue.entity.sp;

import com.sl.ue.util.anno.DbField;
import com.sl.ue.util.anno.Id;
import com.sl.ue.util.anno.Table;
import java.util.Date;

@Table("sp_access_token")
public class SpAccessToken implements java.io.Serializable{

    /** 序列化 */
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @Id
    @DbField("id")
    private Integer id;

    /** 名称 */
    @DbField("name")
    private String name;

    /** 视频厂家凭证 */
    @DbField("access_token")
    private String accessToken;

    /** 到期时间  */
    @DbField("due_time")
    private Date dueTime;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public Date getDueTime() {
        return this.dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }
}
