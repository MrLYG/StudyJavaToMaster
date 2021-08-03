package mapper;

import com.lagou.entity.User;
import com.lagou.entity.UserCourseOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-07 17:26:30
 */
@Service
public interface OrderDao {

    /**
     * 生成订单
     * @param orderNo 订单编号
     * @param user_id 用户编号
     * @param course_id 课程编号
     * @param activity_course_id 活动课程编号
     * @param source_type 订单来源类型
     */
    void saveOrder(@Param("orderNo")String orderNo,@Param("user_id")String user_id,@Param("course_id")String course_id,@Param("activity_course_id")String activity_course_id,@Param("source_type")String source_type);

    /**
     * 修改订单状态
     * @param orderNo 订单编号
     * @param status 订单状态 0已创建 10已支付 20已完成 30已取消 40已过期
     * @return 受影响的行数
     */
    Integer updateOrder( @Param("orderNo") String orderNo,@Param("status") int status );

    /**
     * 删除订单
     * @param orderNo 订单编号
     * @return 受影响的行数
     */
    Integer deleteOrder(@Param("orderNo") String orderNo);

    /**
     * 查询登录用户的全部订单
     * @param userId 用户编号
     * @return 所有订单
     */
    List<UserCourseOrder> getOrdersByUserId(@Param("userId") String userId);

}