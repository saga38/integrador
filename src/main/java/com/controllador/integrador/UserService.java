package com.controllador.integrador;

import com.dto.User;

public interface UserService {
    User createUser(User user);
    User getUserById(String userId);
    User updateUser(String userId, User user);
    void deleteUser(String userId);
}
