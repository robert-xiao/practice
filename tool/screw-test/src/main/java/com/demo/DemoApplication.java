package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		
		generate(applicationContext);
		System.out.println("generated");
	}
	
	public static void generate(ApplicationContext applicationContext) {
		DataSource dataSourceMysql = applicationContext.getBean(DataSource.class);

		String path = System.getProperty("user.dir");
		// 生成文件配置
		EngineConfig engineConfig = EngineConfig.builder()
				// 生成文件路径，自己mac本地的地址，这里需要自己更换下路径
				.fileOutputDir(path)
				// 打开目录
				.openOutputDir(false)
				// 文件类型
				.fileType(EngineFileType.WORD)
				// 生成模板实现
				.produceType(EngineTemplateType.freemarker).build();

		// 生成文档配置（包含以下自定义版本号、描述等配置连接）
		Configuration config = Configuration.builder().version("1.0.3").description("生成文档信息描述")
				.dataSource(dataSourceMysql).engineConfig(engineConfig).produceConfig(getProcessConfig()).build();

		// 执行生成
		new DocumentationExecute(config).execute();
	}

	/**
	 * 配置想要生成的表+ 配置想要忽略的表
	 * 
	 * @return 生成表配置
	 */
	public static ProcessConfig getProcessConfig() {
		// 忽略表名
		List<String> ignoreTableName = Arrays.asList("test_");
		// 忽略表前缀，如忽略a开头的数据库表
		List<String> ignorePrefix = Arrays.asList("test_");
		// 忽略表后缀
		List<String> ignoreSuffix = Arrays.asList("_test");

		return ProcessConfig.builder()
				// 根据名称指定表生成
				.designatedTableName(new ArrayList<>())
				// 根据表前缀生成
				.designatedTablePrefix(new ArrayList<>())
				// 根据表后缀生成
				.designatedTableSuffix(new ArrayList<>())
				// 忽略表名
				.ignoreTableName(ignoreTableName)
				// 忽略表前缀
				.ignoreTablePrefix(ignorePrefix)
				// 忽略表后缀
				.ignoreTableSuffix(ignoreSuffix).build();
	}
}
