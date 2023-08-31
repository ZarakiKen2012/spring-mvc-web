package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(int id) { entityManager.remove(getUserById(id)); }

    @Override
    public void changeUserById(int id, User user) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setAge(user.getAge());
        entityManager.merge(userToBeUpdated);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }
}
