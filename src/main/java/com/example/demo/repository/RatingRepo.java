package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Rating;
import com.example.demo.projections.AverageRatingProjectionDTO;





@Repository
public interface RatingRepo extends JpaRepository<Rating,Integer>,CrudRepository<Rating,Integer> {
	
//	List<Rating> findByUserid(Integer userid);
	
	
	@Query("SELECT AVG(r.ratingvalue) as avgRating FROM Rating r  WHERE   r.person.userid  =:userid  GROUP BY r.person.userid")
	List<AverageRatingProjectionDTO> getAverageRating(@Param("userid")Integer userid);
	
	

}


