package com.controllador.integrador;
import com.dto.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User createUser(User user) {
        users.put(String.valueOf(user.getId()), user);
        return user;
    }

    @Override
    public User getUserById(String userId) {
        return users.get(userId);
    }

    @Override
    public User updateUser(String userId, User user) {
        if (users.containsKey(userId)) {
            users.put(userId, user);
            return user;
        } else {
            throw new IllegalArgumentException("User with id " + userId + " does not exist.");
        }
    }

    @Override
    public void deleteUser(String userId) {
        users.remove(userId);
    }
}
