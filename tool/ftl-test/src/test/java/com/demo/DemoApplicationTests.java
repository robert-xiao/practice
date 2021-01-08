package com.demo;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.DemoApplication;
import com.demo.service.GeneratorService;
import com.demo.util.GeneratorUtil;
import com.demo.vo.ColumnInfo;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
    private GeneratorService generatorService;
	
	@Test
	public void contextLoads() throws IOException {
		String tableName = "user";
        String pack = "com.titans";
        String author = "ba jie";
        List<ColumnInfo> columnInfos = generatorService.getColumns(tableName);
        GeneratorUtil.generatorCode(columnInfos,pack,author,tableName);		
	}

}
