package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUserByUsertypeLike(int type);
    List<User> findUserByUseridLike(int uid);
    User findUserByIdnumberLike(int idnumber);

}
