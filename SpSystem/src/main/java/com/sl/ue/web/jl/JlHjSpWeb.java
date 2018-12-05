package com.sl.ue.web.jl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sl.ue.entity.jl.vo.JlHjSpVO;
import com.sl.ue.service.jl.JlHjSpService;
import com.sl.ue.util.http.Result;

@RestController
@RequestMapping("/jlHjSp")
public class JlHjSpWeb extends Result{

    @Autowired
    private JlHjSpService jlHjSpSQL;

    @RequestMapping("/findList")
    public String findList(JlHjSpVO model,Integer pageSize, Integer pageNum){
        List<JlHjSpVO> list = jlHjSpSQL.findList(model, pageSize, pageNum);
        this.putData(list);
        return this.toResult();
    }

    @RequestMapping("/findPojo")
    public String findPojo(JlHjSpVO model, Integer pageSize, Integer pageNum){
        Map<String, Object> map = jlHjSpSQL.findPojoJoin(model, pageSize, pageNum);
        this.putPojo(map);
        return this.toResult();
    }

    @RequestMapping("/findCount")
    public String findCount(JlHjSpVO model){
        Integer count = jlHjSpSQL.count(model);
        this.putJson("count", count);
        return this.toResult();
    }

    @RequestMapping("/findOne")
    public String findOne(Integer id){
        JlHjSpVO model = jlHjSpSQL.findOne(id);
        this.putJson(model);
        return this.toResult();
    }

    @RequestMapping("/add")
    public String add(JlHjSpVO model){
        jlHjSpSQL.add(model);
        return this.toResult();
    }

    @RequestMapping("/edit")
    public String edit(JlHjSpVO model){
        jlHjSpSQL.edit(model);
        return this.toResult();
    }

    @RequestMapping("/delete")
    public String del(Integer id){
        jlHjSpSQL.deleteKey(id);
        return this.toResult();
    }

    @RequestMapping("/findDetails")
    public String findDetails(Long spId){
    	return jlHjSpSQL.findDetails(spId);
    }
}
