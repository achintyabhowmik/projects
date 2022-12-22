package com.stackroute.referservice.service;

import java.util.List;

import com.stackroute.referservice.domain.News;
import com.stackroute.referservice.exception.NewsAlreadyExistsException;
import com.stackroute.referservice.exception.NewsNotFoundException;



public interface NewsService 
{
	boolean saveNews(News news) throws NewsAlreadyExistsException;
	
	
	
	List<News> getNews() throws NewsNotFoundException;
}
