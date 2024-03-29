package com.stackroute.favouriteservice.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.stackroute.favouriteservice.domain.News;
import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
import com.stackroute.favouriteservice.exception.NewsNotFoundException;
import com.stackroute.favouriteservice.repository.NewsRepository;



public class NewsServiceTest 
{
	@Mock
	private NewsRepository newsRepository;
	
	@InjectMocks
	private NewsServiceImpl newsServiceImpl;
	
	private News news;
	
	Optional<News> options;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		news = new News();
		news.setUserId("12345");
		news.setTitle("hot donao");
		news.setContent("that 70 show");;
		news.setDescription("love they had");
		news.setPublishedAt("09/09/2019");
		news.setSourceWebsiteName("ccn");
		news.setUrl("lki");
		news.setUrlToImage("pois");
		options=Optional.of(news);

	}
	
	@Test
	public void testSave() throws NewsAlreadyExistsException
	{
		when(newsRepository.save(news)).thenReturn(news);
		boolean flag = newsServiceImpl.saveNews(news);
		assertEquals(true,flag);
		verify(newsRepository,times(1)).save(news);
		verify(newsRepository,times(1)).findByUserIdAndTitle(news.getUserId(), news.getTitle());
	}
	
	@Test(expected=NewsAlreadyExistsException.class)
	public void testSaveFail() throws NewsAlreadyExistsException
	{
		when(newsRepository.findByUserIdAndTitle(news.getUserId(), news.getTitle())).thenReturn(options);
		boolean flag = newsServiceImpl.saveNews(news);
		assertEquals(false,flag);
		verify(newsRepository,times(0)).save(news);
		verify(newsRepository,times(1)).findByUserIdAndTitle(news.getUserId(), news.getTitle());
	}
	
	@Test
	public void testDelete() throws NewsNotFoundException
	{
		when(newsRepository.findById(news.getId())).thenReturn(options);
		doNothing().when(newsRepository).delete(news);
		boolean flag = newsServiceImpl.deleteNewsById(news.getId());
		assertEquals(true,flag);
		verify(newsRepository,times(1)).delete(news);
		verify(newsRepository,times(1)).findById(news.getId());
	}
	

	
	@Test(expected=NewsNotFoundException.class)
	public void testList() throws NewsNotFoundException
	{
		List<News> newsList = new ArrayList<>();
		when(newsRepository.findByUserId("12345")).thenReturn(newsList);
		List<News> newsList2 = newsServiceImpl.getNews("12345");
		assertEquals(newsList,newsList2);
		verify(newsRepository,times(1)).findByUserId("12345");
	}
}
