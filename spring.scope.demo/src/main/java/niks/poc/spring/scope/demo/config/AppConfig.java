package niks.poc.spring.scope.demo.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import niks.poc.spring.scope.demo.beans.Person;
import niks.poc.spring.scope.demo.beans.Student;
import niks.poc.spring.scope.demo.beans.TestBean;
import niks.poc.spring.scope.demo.beans.TestBeanCondition;

@Configuration
@ComponentScan(basePackages = "niks.poc.spring.propagation.demo, niks.poc.spring.scope.demo.beans.jsr250, niks.poc.spring.scope.demo.messageresource, niks.poc.spring.scope.demo.aspect")
@PropertySource(value="classpath:config/config-test.properties", ignoreResourceNotFound = false)
@EnableTransactionManagement
@EnableAspectJAutoProxy
//@EnableJpaRepositories(basePackages = {"niks.poc.spring.propagation.demo"})
public class AppConfig {
	
	@PreDestroy
	void destroy(){
		System.out.println("global destroy....");
	}
	
	@PostConstruct
	void init() {
		System.out.println("global init");
	}
	
	@Bean
	@Conditional(TestBeanCondition.class)
	public TestBean testCondition() {
		System.out.println("################creating TestBean.....");
		return new TestBean();
	}
	
	@Bean(name = "person")
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public Person getPerson() {
		return new Person();
	}
	
	@Bean(autowire = Autowire.BY_NAME)
	public BeanPostProcessorTest beanPost() {
		return new BeanPostProcessorTest();
	} 
	
	@Bean
	public DataSource dataSource() {
	  return new EmbeddedDatabaseBuilder()
	    .generateUniqueName(false)
	    .setName("testdb")
	    .setType(EmbeddedDatabaseType.H2)
	    .addDefaultScripts()
	    .setScriptEncoding("UTF-8")
	    .ignoreFailedDrops(true)
	    .build();
	}
	
	@Bean
	public JdbcTemplate JdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	/*
	 * @Bean public DataSourceTransactionManager txManager() { return new
	 * DataSourceTransactionManager(dataSource()); }
	 */
	
	
	@Bean
	public Student student() {
		return new Student("hello nikhil!");
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource mc = new ReloadableResourceBundleMessageSource();
		
		mc.setBasenames("classpath:config/config-test", "classpath:config/esign-error-codes");
		mc.setCacheSeconds(2);
		
		return mc;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean  entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.H2);
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("niks.poc.spring.scope.demo.entities");
		factory.setDataSource(dataSource());
		//factory.setPersistenceUnitName("em");

		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}

}
