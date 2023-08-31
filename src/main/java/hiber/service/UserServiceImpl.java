package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public List<User> getUsers() { return userDao.getUsers(); }

    @Transactional
    @Override
    public void changeUserById(int id, User user) { userDao.changeUserById(id, user); }
    @Transactional
    @Override
    public void deleteUserById(int id){ userDao.deleteUserById(id); }
}
