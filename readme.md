https://www.youtube.com/watch?v=jdeSV0GRvwI


Error:
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Failed to initialize dependency 'flywayInitializer' of LoadTimeWeaverAware bean 'entityManagerFactory': Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Unsupported Database: PostgreSQL 17.0

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Failed to initialize dependency 'flywayInitializer' of LoadTimeWeaverAware bean 'entityManagerFactory': Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Unsupported Database: PostgreSQL 17.0
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:326) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:205) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:954) ~[spring-context-6.1.14.jar:6.1.14]
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.14.jar:6.1.14]
at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.3.5.jar:3.3.5]
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.3.5.jar:3.3.5]
at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.3.5.jar:3.3.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:335) ~[spring-boot-3.3.5.jar:3.3.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1363) ~[spring-boot-3.3.5.jar:3.3.5]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1352) ~[spring-boot-3.3.5.jar:3.3.5]
at com.ecommerce.product_service.ProductServiceApplication.main(ProductServiceApplication.java:10) ~[classes/:na]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Unsupported Database: PostgreSQL 17.0
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1806) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:337) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:335) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:313) ~[spring-beans-6.1.14.jar:6.1.14]
... 10 common frames omitted
Caused by: org.flywaydb.core.api.FlywayException: Unsupported Database: PostgreSQL 17.0
at org.flywaydb.core.internal.database.DatabaseTypeRegister.getDatabaseTypeForConnection(DatabaseTypeRegister.java:105) ~[flyway-core-10.10.0.jar:na]
at org.flywaydb.core.internal.jdbc.JdbcConnectionFactory.<init>(JdbcConnectionFactory.java:73) ~[flyway-core-10.10.0.jar:na]
at org.flywaydb.core.FlywayExecutor.execute(FlywayExecutor.java:134) ~[flyway-core-10.10.0.jar:na]
at org.flywaydb.core.Flyway.migrate(Flyway.java:147) ~[flyway-core-10.10.0.jar:na]
at org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer.afterPropertiesSet(FlywayMigrationInitializer.java:66) ~[spring-boot-autoconfigure-3.3.5.jar:3.3.5]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1853) ~[spring-beans-6.1.14.jar:6.1.14]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1802) ~[spring-beans-6.1.14.jar:6.1.14]
... 17 common frames omitted

------------------------------------------------------------------------------------------------------------------------------------
https://github.com/flyway/flyway/issues/3807
https://github.com/flyway/flyway/issues/3780
------------------------------------------------------------------------------------------------------------------------------------