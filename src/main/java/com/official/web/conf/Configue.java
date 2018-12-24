package com.official.web.conf;


import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * mvc通用配置
 * 
 * @author luoyr
 *
 */
@Configuration
@PropertySource("classpath:db.properties")
@MapperScan(basePackages = {"com.official.web.origin.mapper"})
public class Configue extends WebMvcConfigurerAdapter {

	@Value("${mybatis.mapper-locations}")   
	private String MAPPER_PATH;    
	@Value("${mybatis.type-aliases-package}")   
	private String typeAliasPackage;   

//	@Bean
//	public DataSource dataSource() throws IOException {
////		Properties properties = new Properties();
////		properties.load(getClass().getResourceAsStream("/db.properties"));
////		HikariConfig config = new HikariConfig(properties);
////		HikariConfig config = new HikariConfig();
////		config.setMaximumPoolSize(db_max_conn);
////		config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
////		config.addDataSourceProperty("serverName", db_url);
////		config.addDataSourceProperty("port", db_port);
////		config.addDataSourceProperty("databaseName", db_name);
////		config.addDataSourceProperty("user", db_username);
////		config.addDataSourceProperty("password", db_password);
////		HikariDataSource dataSource = new HikariDataSource(config);
//		return DataSourceBuilder.create().build();
////		return new HikariDataSource(config);
//	}
	
	private static String url = "127.0.0.1";
//	private static String url = "jdbc:mysql://59.110.218.135:3306/g4m";
	private static String databaseName = "g4m";
	private static String user = "root";
	private static String password = "123456";

	@Bean
	public static DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		// config.setMaximumPoolSize(db_max_conn);
		config.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
//		config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		config.addDataSourceProperty("serverName", url);
		config.addDataSourceProperty("port", 3306);
		config.addDataSourceProperty("databaseName", databaseName);
		config.addDataSourceProperty("user", user);
		config.addDataSourceProperty("password", password);
		return new HikariDataSource(config);
	}

	@Bean    
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();        
		/** 添加mapper 扫描路径 */        
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();        
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
		sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
		/** 设置datasource */        
		sqlSessionFactoryBean.setDataSource(dataSource());   
		/** 设置typeAlias 包扫描路径 */     
		sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}


	/*@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}*/

	//中文编码配置
	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}
	//日期转换
	/*@Bean
	public ConversionService formattingConversionService() {
	        DefaultFormattingConversionService dc = new DefaultFormattingConversionService();
	        dc.addConverter(new DateConverter());
	        return dc;
	    }*/


	@Primary
	@Bean
	public ObjectMapper jacksonObjectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		objectMapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);  //数字也加引号
		return objectMapper;
	}

	/*@Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

	 *//**
	 * 增加字符串转日期的功能
	 *//*
    @PostConstruct
    public void initEditableValidation() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
            .getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer
                .getConversionService();
            genericConversionService.addConverter(new StringToDateConverter());
        }

    }*/

}

