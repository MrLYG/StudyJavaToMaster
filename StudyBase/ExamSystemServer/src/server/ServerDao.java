package server;

import model.User;

public class ServerDao {
    /***
     * 校验账号和密码
     * @param user
     * @return
     */
    public boolean serverManagerCheck(User user){
        if("admin".equals(user.getUserName())&&"123456".equals(user.getPassWord())){
            return true;
        }
        return false;
    }
}
