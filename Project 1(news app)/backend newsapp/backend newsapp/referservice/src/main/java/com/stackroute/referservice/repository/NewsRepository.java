package com.stackroute.referservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.referservice.domain.News;



public interface NewsRepository extends JpaRepository<News, Integer> 
{
	List<News> findByUserId(String userId);
	
	Optional<News> findByUserIdAndTitle(String userId, String title);
}
