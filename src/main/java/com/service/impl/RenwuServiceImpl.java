package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.RenwuDao;
import com.entity.RenwuEntity;
import com.service.RenwuService;
import com.entity.view.RenwuView;

/**
 * 任务 服务实现类
 * @author 
 * @since 2021-03-03
 */
@Service("renwuService")
@Transactional
public class RenwuServiceImpl extends ServiceImpl<RenwuDao, RenwuEntity> implements RenwuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<RenwuView> page =new Query<RenwuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
