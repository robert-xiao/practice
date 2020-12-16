package com.demo;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testList(){
		List mockList = mock(ArrayList.class);
		
		Assert.assertTrue(mockList instanceof ArrayList);
		Mockito.when(mockList.add(1)).thenReturn(true);
		Mockito.when(mockList.size()).thenReturn(10);
		
		Assert.assertTrue(mockList.add(1));
		Assert.assertFalse(mockList.add(2));
		
		Assert.assertEquals(mockList.size(), 10);
		
		System.out.println(mockList.get(0));
	}
}
