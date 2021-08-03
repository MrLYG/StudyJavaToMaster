package com.lagou.order.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.entity.UserCourseOrder;
import com.lagou.order.OrderService;
import mapper.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @BelongsProject: lagou-edu
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-09 16:00
 * @Description:
 */
@Service //暴露服务
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    public void saveOrder(String orderNo, String user_id, String course_id, String activity_course_id, String source_type) {
        orderDao.saveOrder(orderNo, user_id, course_id, activity_course_id, source_type);
    }

    public Integer updateOrder(String orderNo, int status) {
        return orderDao.updateOrder(orderNo,status);
    }

    public Integer deleteOrder(String orderNo) {
        return orderDao.deleteOrder(orderNo);
    }

    public List<UserCourseOrder> getOrdersByUserId(String userId) {
        return orderDao.getOrdersByUserId(userId);
    }
}
