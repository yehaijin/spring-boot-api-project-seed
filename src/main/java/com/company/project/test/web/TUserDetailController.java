package com.company.project.test.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.test.model.TUserDetail;
import com.company.project.test.service.TUserDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/30.
*/
@RestController
@RequestMapping("/web/login")
public class TUserDetailController {
    @Resource
    private TUserDetailService tUserDetailService;

    @PostMapping("/add")
    public Result add(TUserDetail tUserDetail) {
        tUserDetailService.save(tUserDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tUserDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TUserDetail tUserDetail) {
        tUserDetailService.update(tUserDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TUserDetail tUserDetail = tUserDetailService.findById(id);
        return ResultGenerator.genSuccessResult(tUserDetail);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TUserDetail> list = tUserDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
