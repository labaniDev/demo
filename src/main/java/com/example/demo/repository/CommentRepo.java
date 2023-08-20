package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Comment;
import com.example.demo.projections.CommentProjectionDTO;


public interface CommentRepo extends CrudRepository<Comment,Integer>,JpaRepository<Comment,Integer> {
	@Query(value="SELECT c1.commentid AS commentid, c1.parentid AS parentid, c1.comment AS commenttext, " +
            "c2.commentid AS parentid, c2.comment AS replytext " +
            "FROM Comment c1 " +
            "LEFT JOIN Comment c2 ON c1.commentId = c2.parentId", nativeQuery=true)
	List<CommentProjectionDTO>  findByParentid(@Param("parentid") Integer parentid);

	
   
}
