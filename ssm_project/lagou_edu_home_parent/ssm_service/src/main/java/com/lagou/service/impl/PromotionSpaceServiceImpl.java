package com.lagou.service.impl;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {

        List<PromotionSpace> allPromotionSpace = promotionSpaceMapper.findAllPromotionSpace();

        return allPromotionSpace;
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {

        // 1.封装数据
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);

        // 2.调用mapper方法
        promotionSpaceMapper.savePromotionSpace(promotionSpace);

    }

    /*
        根据ID查询广告位信息
     */
    @Override
    public PromotionSpace findPromotionSpaceById(int id) {

        PromotionSpace promotionSpaceById = promotionSpaceMapper.findPromotionSpaceById(id);
        return promotionSpaceById;
    }

    /*
        修改广告位名称
     */
    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {

        // 封装数据
        promotionSpace.setUpdateTime(new Date());

        // 调用mapper
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);

    }


}
