package cn.itcast.music.service.impl;


import cn.itcast.music.music_dao.UserDao;
import cn.itcast.music.music_dao.impl.UserDaoImpl;
import cn.itcast.music.music_domain.User;
import cn.itcast.music.music_service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        //根据用户名查询用户对象
        User byUsername = userDao.findByName(user.getUsername());
        if (byUsername != null) {
            //存在
            return false;
        }
        userDao.regist(user);
        return true;
    }

    /**
     * 根据用户名、密码查询用户
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.login(user.getUsername(), user.getPassword());
    }
}
