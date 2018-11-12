package com.saraad.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: DruidAutoConfig
 * @Package:com.saraad.config.druid
 * @Description:
 * @author: saraad
 * @date: 2018/11/13 0:22
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
@Configuration
@EnableConfigurationProperties({DruidConfig.class})
public class DruidAutoConfig {

    private DruidConfig druidConfig;

    @Autowired
    public DruidAutoConfig(DruidConfig druidConfig) {
        this.druidConfig = druidConfig;
    }

    @Bean
    @Primary
    public DataSource dataSource(){return buildDataSource();}

    private DataSource buildDataSource(){
        DruidDataSource defaultDataSource = new DruidDataSource();
        defaultDataSource.setUrl(druidConfig.getUrl());
        defaultDataSource.setUsername(druidConfig.getUsername());
        defaultDataSource.setPassword(druidConfig.getPassword());
        defaultDataSource.setDriverClassName(druidConfig.getDriverClass());

        if (druidConfig.getMaxActive() > 0) {
            defaultDataSource.setMaxActive(druidConfig.getMaxActive());
        }
        if (druidConfig.getMinIdle() > 0) {
            defaultDataSource.setMinIdle(druidConfig.getMinIdle());
        }
        if(druidConfig.getInitialSize() > 0) {
            defaultDataSource.setInitialSize(druidConfig.getInitialSize());
        }
        if (druidConfig.getMaxWait() > 0) {
            defaultDataSource.setMaxWait(druidConfig.getMaxWait());
        }

        //配置druid相关的保持心跳参数
        if (druidConfig.getTimeBetweenEvictionRunsMillis() > 0){
            defaultDataSource.setTimeBetweenEvictionRunsMillis(druidConfig.getTimeBetweenEvictionRunsMillis());
        }
        if (druidConfig.getMinEvictableIdleTimeMillis() > 0){
            defaultDataSource.setMinEvictableIdleTimeMillis(druidConfig.getMinEvictableIdleTimeMillis());
        }
        defaultDataSource.setValidationQuery(druidConfig.getValidationQuery());
        defaultDataSource.setTestWhileIdle(druidConfig.isTestWhileIdle());
        defaultDataSource.setTestOnBorrow(druidConfig.isTestOnBorrow());
        defaultDataSource.setTestOnReturn(druidConfig.isTestOnReturn());
        try {
            defaultDataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(MultipleDataSource.DEFAULT_DATASOURCE, defaultDataSource);

        MultipleDataSource dataSource = new MultipleDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(defaultDataSource);
        return dataSource;
    }



}
