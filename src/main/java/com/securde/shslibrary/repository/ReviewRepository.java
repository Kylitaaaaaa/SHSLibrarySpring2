package com.securde.shslibrary.repository;

import com.securde.shslibrary.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findReviewByBookidLike(int bookid);
    List<Review> findReviewByBookidAndUserid(int bookid, int userid);

}
