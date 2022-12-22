package com.stackroute.referservice.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.referservice.domain.News;
import com.stackroute.referservice.repository.NewsRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class NewsRepositoryTest 
{
//	private static Logger logger = LoggerFactory.getLogger(NewsRepositoryTest.class);
	
	@Autowired
	private NewsRepository newsRepository;
	
	News news = new News();
	
	@Before
	public void setup() {
	
		news.setUserId("12345");
		news.setTitle("hot donao");
		news.setContent("that 70 show");;
		news.setDescription("love they had");
		news.setPublishedAt("09/09/2019");
		news.setSourceWebsiteName("ccn");
		news.setUrl("lki");
		news.setUrlToImage("pois");
		
	}
	@After	
	public void tearDown()
	{
		newsRepository.deleteAllInBatch();
	}

	@Test
	public void testSave() throws Exception
	{	
		newsRepository.save(news);
		assertEquals(true,newsRepository.existsById(news.getId()));
	}
	
	@Test
	public void testDelete()
	{
		newsRepository.save(news);
		assertEquals(true,newsRepository.existsById(news.getId()));
		newsRepository.delete(news);
		assertEquals(false,newsRepository.existsById(news.getId()));
	}
	

	
	@Test
	public void testList()
	{
		newsRepository.save(news);
		News news2 = new News();
		news.setUserId("123456");
		news2.setTitle("Bombbom");
		news2.setContent("bomb in tamil");;
		news2.setDescription("for sure");
		news2.setPublishedAt("00/09/2020");
		news2.setSourceWebsiteName("lookup");
		news2.setUrl("knknkn");
		news2.setUrlToImage("muiyu");
		newsRepository.save(news2);
		List<News> newsList = newsRepository.findAll();
		assertEquals(2,newsList.size());
	}
}
