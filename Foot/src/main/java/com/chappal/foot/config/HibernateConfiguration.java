package com.chappal.foot.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.chappal.foot.model.Brand;
import com.chappal.foot.model.Category;
import com.chappal.foot.model.ListProducts;
import com.chappal.foot.model.ProductSpecification;
import com.chappal.foot.model.Products;
import com.chappal.foot.model.SubCategory;
import com.chappal.foot.model.Supplier;
import com.chappal.foot.model.User;
import com.chappal.foot.model.Role;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.handler.RegistrationHandler;
import com.chappal.foot.handler.UserHandler;
import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.Cart;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.model.UserRole;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.chappal.foot")
public class HibernateConfiguration extends WebMvcConfigurerAdapter
{
	@Bean(name = "dataSource")
    public DataSource dataSource() 
	{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/foot");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        
        Properties dproperties = new Properties();
        dproperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        dproperties.setProperty("hibernate.show_sql", "true");
        dproperties.setProperty("hibernate.hbm2ddl.auto", "update");
        return dataSource;
    }
	
    private Properties hibernateProperties() 
    {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
    @Bean(name = "transactionManager")
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) 
    {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory SessionFactory(DataSource dataSource) 
    {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(hibernateProperties());
        sessionBuilder.addAnnotatedClass(Category.class);
        sessionBuilder.addAnnotatedClass(Supplier.class);
        sessionBuilder.addAnnotatedClass(SubCategory.class);
        sessionBuilder.addAnnotatedClass(Brand.class);
        sessionBuilder.addAnnotatedClass(Products.class);
        sessionBuilder.addAnnotatedClass(User.class);
        sessionBuilder.addAnnotatedClass(UserDetail.class);
        sessionBuilder.addAnnotatedClass(UserRole.class);
        sessionBuilder.addAnnotatedClass(ShippingAddress.class);
        sessionBuilder.addAnnotatedClass(BillingAddress.class);
        sessionBuilder.addAnnotatedClass(Cart.class);
        sessionBuilder.addAnnotatedClass(Role.class);
        sessionBuilder.addAnnotatedClass(ProductSpecification.class);
        sessionBuilder.addAnnotatedClass(ListProducts.class);
        return sessionBuilder.buildSessionFactory();
    }
    
    @Autowired
    @Bean(name="registartionHandler")
    public RegistrationHandler registrationHandler()
    {
    	return new RegistrationHandler();
    }
    
    @Autowired
    @Bean(name="userHandler")
    public UserHandler userHandler()
    {
    	return new UserHandler();
    }
 
    
    @Autowired
    @Bean(name="billingAddress")
    public BillingAddress billingAddress()
    {
    	return new BillingAddress();
    }
    
    @Autowired
    @Bean(name="shippingAddress")
    public ShippingAddress shippingAddress()
    {
    	return new ShippingAddress();
    }
    
    @Autowired
    @Bean(name="supplier")
    public Supplier supplier()
    {
    	return new Supplier();
    }
    
}