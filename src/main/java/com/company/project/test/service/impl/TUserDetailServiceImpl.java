package com.company.project.test.service.impl;

import com.company.project.test.dao.TUserDetailMapper;
import com.company.project.test.model.TUserDetail;
import com.company.project.test.service.TUserDetailService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/30.
 */
@Service
@Transactional
public class TUserDetailServiceImpl extends AbstractService<TUserDetail> implements TUserDetailService {
    @Resource
    private TUserDetailMapper tUserDetailMapper;

}
