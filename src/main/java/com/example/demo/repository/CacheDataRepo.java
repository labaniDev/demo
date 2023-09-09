package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CacheData;
@Repository
public interface CacheDataRepo extends CrudRepository<CacheData,String> {

}
