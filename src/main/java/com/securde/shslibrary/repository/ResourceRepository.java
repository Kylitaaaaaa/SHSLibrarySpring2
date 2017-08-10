package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    //List<User> findUserByUsertypeLike(int type);
    List<Resource> findResourceByStatusLike(int stat);

    //List<Resource> findResourceByAuthorLike(String author);
   // List<Resource> findResourceByTitleLike(String title);
    //List<Resource> findResourceByPublisherLike(String publisher);

    Resource findResourceByBookidLike(int uid);

   // List<Resource> findResourceByAuthorAndBooktype(String searchitem, int restype);
   // List<Resource> findResourceByPublisherAndBooktype(String searchitem, int restype);
   // List<Resource> findResourceByTitleAndBooktype(String searchitem, int restype);

    //List<Resource> findResourceByAuthorOrPublisherOrTitle(String searchitem, String searchitem2, String searchitem3);

    List<Resource> findResourceByAuthorIgnoreCaseContaining(String author);
    List<Resource> findResourceByTitleIgnoreCaseContaining(String title);
    List<Resource> findResourceByPublisherIgnoreCaseContaining(String publisher);

    List<Resource> findResourceByAuthorIgnoreCaseContainingAndBooktype(String searchitem, int restype);
    List<Resource> findResourceByPublisherIgnoreCaseContainingAndBooktype(String searchitem, int restype);
    List<Resource> findResourceByTitleIgnoreCaseContainingAndBooktype(String searchitem, int restype);

    List<Resource> findResourceByAuthorIgnoreCaseContainingOrPublisherIgnoreCaseContainingOrTitleIgnoreCaseContaining(String searchitem, String searchitem2, String searchitem3);

    List<Resource> findResourceByAuthorIgnoreCaseContainingOrPublisherIgnoreCaseContainingOrTitleIgnoreCaseContainingAndBooktype(String searchitem, String searchitem2, String searchitem3, int restype);

}
