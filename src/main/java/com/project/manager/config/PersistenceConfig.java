package com.project.manager.config;

//@Configuration
//@PropertySource(value = {"classpath:application.properties"})
//@EnableTransactionManagement
//@EnableJpaRepositories
public class PersistenceConfig {

//    @Autowired
//    private Environment env;
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        final HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setConnectionTestQuery(env.getProperty("spring.datasource.hikari.connection-test-query"));
//        hikariConfig.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name"));
//        hikariConfig.setJdbcUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
//        hikariConfig.setDataSourceProperties(getDataSourceProps());
//
//        return new HikariDataSource(hikariConfig);
//    }
//
//    private Properties getDataSourceProps() {
//        final Properties properties = new Properties();
//        properties.setProperty("url", env.getProperty("spring.datasource.hikari.jdbc-url"));
//        properties.setProperty("user", env.getProperty("spring.datasource.hikari.username"));
//        properties.setProperty("password", env.getProperty("spring.datasource.hikari.password"));
//        return properties;
//    }
//
//    private Properties jpaHibernateProperties() {
//        final Properties properties = new Properties();
//        properties.put(DIALECT, env.getProperty("spring.jpa.database-platform"));
//        properties.put(SHOW_SQL, env.getProperty("spring.jpa.show-sql"));
//        properties.put(HBM2DDL_AUTO, env.getProperty("spring.jpa.hibernate.ddl-auto"));
//        properties.put(GLOBALLY_QUOTED_IDENTIFIERS, true);
//        return properties;
//    }
//
//    @Bean
//    public JpaTransactionManager jpaTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return transactionManager;
//    }
//
//    private HibernateJpaVendorAdapter vendorAdaptor() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setShowSql(true);
//        return vendorAdapter;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPackagesToScan("com.project.manager.domain");
//        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//
//        return entityManagerFactoryBean;
//    }


}
