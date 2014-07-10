package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.User;

public interface UserRepository {

    User find(Long userId);
    List<User> findAll();
    List<User> paginate(int offset, int limit);
    User save(User User);
    User update(User User, Long userId);
    User delete(Long userId);

}
