package mapper;

import entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 17:37
 * @Description: 用户操作mapper
 */
@Service
public interface UserMapper {
    int register( Users users );

    int deleteUser(Integer userId);

    int reviseUser(Users users);

    List<Users> findUsersbyName(Users users);
}
