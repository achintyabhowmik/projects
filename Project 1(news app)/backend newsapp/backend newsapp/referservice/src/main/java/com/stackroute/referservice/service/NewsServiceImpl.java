package com.stackroute.referservice.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.referservice.domain.News;
import com.stackroute.referservice.exception.NewsAlreadyExistsException;
import com.stackroute.referservice.exception.NewsNotFoundException;
import com.stackroute.referservice.repository.NewsRepository;


@Service
public class NewsServiceImpl implements NewsService
{
	@Autowired
	private NewsRepository newsRepository;

	@Override
	public boolean saveNews(News news) throws NewsAlreadyExistsException
	{

		Optional<News> checkNews = newsRepository.findByUserIdAndTitle(news.getUserId(), news.getTitle());
		
		if(checkNews.isPresent())
			throw new NewsAlreadyExistsException("News already exists");
		
		newsRepository.save(news);
		return true;
	}
	
	
	

	
	@Override
	public List<News> getNews() throws NewsNotFoundException
	{
		List<News> newsList = (List<News>) newsRepository.findAll();
		if(newsList.size()==0)
			throw new NewsNotFoundException("News not found!");
		return newsList;
	}
}
