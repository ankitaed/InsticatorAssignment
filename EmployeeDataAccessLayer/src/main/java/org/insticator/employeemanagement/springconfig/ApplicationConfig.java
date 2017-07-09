package org.insticator.employeemanagement.springconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = {"org.insticator.employeemanagement.repository"})
@ComponentScan(basePackages = {"org.insticator.employeemanagement.db.service"})
public class ApplicationConfig {

	@Value("${db.driver}")
	private String databaseDriver;
	
	@Value("${db.url}")
	private String databaseUrl;
	
	@Value("${db.username}")
	private String databaseUserName;
	
	@Value("${db.password}")
	private String databasePassword;
	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${entitymanager.packages.to.scan}")
	private String packagesToScan; 
	
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;
	
	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource  dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(databaseDriver);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(databaseUserName);
		dataSource.setPassword(databasePassword);
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(packagesToScan);
		entityManagerFactoryBean.setJpaProperties(getProperties());
		return entityManagerFactoryBean;
	}
	
	@Bean
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());
		return transactionManager;
	}
	
	private Properties getProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.put(HIBERNATE_DIALECT, hibernateShowSql);
		jpaProperties.put(HIBERNATE_SHOW_SQL, hibernateDialect);
		return jpaProperties;
	}
}
