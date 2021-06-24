package com.wishes.demo.configure;

import com.wishes.demo.repository.impl.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.wishes.demo.repository",repositoryBaseClass = BaseRepositoryImpl.class)
public class PersistenceConfig {
}
