package ru.javamentor.SpringBoot_pp_312.service;


import ru.javamentor.SpringBoot_pp_312.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

    List<User> getAllUser();

    void userEditor(User user, Long id);
}
