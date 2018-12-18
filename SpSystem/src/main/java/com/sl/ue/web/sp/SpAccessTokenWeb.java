package com.sl.ue.web.sp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sl.ue.entity.sp.vo.SpAccessTokenVO;
import com.sl.ue.service.sp.SpAccessTokenService;
import com.sl.ue.util.http.Result;

@RestController
@RequestMapping("/spAccessToken")
public class SpAccessTokenWeb extends Result{

    @Autowired
    private SpAccessTokenService spAccessTokenSQL;

    @RequestMapping("/findList")
    public String findList(SpAccessTokenVO model,Integer pageSize, Integer pageNum){
        List<SpAccessTokenVO> list = spAccessTokenSQL.findList(model, pageSize, pageNum);
        this.putData(list);
        return this.toResult();
    }

    @RequestMapping("/findPojo")
    public String findPojo(SpAccessTokenVO model, Integer pageSize, Integer pageNum){
        Map<String, Object> map = spAccessTokenSQL.findPojo(model, pageSize, pageNum);
        this.putPojo(map);
        return this.toResult();
    }

    @RequestMapping("/findCount")
    public String findCount(SpAccessTokenVO model){
        Integer count = spAccessTokenSQL.count(model);
        this.putJson("count", count);
        return this.toResult();
    }

    @RequestMapping("/findOne")
    public String findOne(Integer id){
        SpAccessTokenVO model = spAccessTokenSQL.findOne(id);
        this.putJson(model);
        return this.toResult();
    }

    @RequestMapping("/add")
    public String add(SpAccessTokenVO model){
        spAccessTokenSQL.add(model);
        return this.toResult();
    }

    @RequestMapping("/edit")
    public String edit(SpAccessTokenVO model){
        spAccessTokenSQL.edit(model);
        return this.toResult();
    }

    @RequestMapping("/delete")
    public String del(Integer id){
        spAccessTokenSQL.deleteKey(id);
        return this.toResult();
    }

}
