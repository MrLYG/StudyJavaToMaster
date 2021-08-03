package mapper;

import com.lagou.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-07 17:26:30
 */
@Service
public interface UserDao {

    /**
     * 用户登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return 用户对象
     */
    User login(@Param("phone") String phone, @Param("password") String password);


    /**
     * 检查手机号是否注册过
     *
     * @param phone 手机号
     * @return 0：未注册 ， 1：已注册
     */
    Integer checkPhone(String phone);

    /**
     * 用户注册
     *
     * @param phone    手机号
     * @param password 密码
     * @param nickname 昵称
     * @param headimg 头像
     * @return 受影响的行数
     */
    Integer register(@Param("phone") String phone, @Param("password") String password,@Param("nickname") String nickname,@Param("headimg") String headimg);
}