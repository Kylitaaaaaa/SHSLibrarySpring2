package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    //List<User> findUserByUsertypeLike(int type);
    List<Resource> findResourceByStatusLike(int stat);
    List<Resource> findResourceByAuthorLike(String author);
    List<Resource> findResourceByTitleLike(String title);
    List<Resource> findResourceByPublisherLike(String publisher);
    Resource findResourceByBookidLike(int uid);

}
