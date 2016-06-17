package ejemplo.springjdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("ejemplo.springjdbc.controller")
public class DataConfig {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://192.168.44.10:3306/demo");
		ds.setUsername("user");
		ds.setPassword("123456");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
}
