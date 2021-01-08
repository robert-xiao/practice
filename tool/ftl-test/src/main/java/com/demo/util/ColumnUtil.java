package com.demo.util;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ColumnUtil {
	private static final char SEPARATOR = '_';

    /**
     * 获取配置信息
     */
    public static PropertiesConfiguration getConfig() {
        try {
             Configurations configs = new Configurations();
				// setDefaultEncoding是个静态方法,用于设置指定类型(class)所有对象的编码方式。
				// 本例中是PropertiesConfiguration,要在PropertiesConfiguration实例创建之前调用。
			FileBasedConfigurationBuilder.setDefaultEncoding(PropertiesConfiguration.class, "UTF-8");
			
			//return configs.properties(ColumnUtil.class.getClassLoader().getResource("generator1.properties"));
			
			return configs.properties("generator.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换mysql数据类型为java数据类型
     * @param type
     * @return
     */
    public static String cloToJava(String type){
        Configuration config = getConfig();
        System.out.println(config.getString("date"));
        return config.getString(type,null);
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
