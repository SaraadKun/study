package com.saraad.config.druid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: DruidConfiguration
 * @Package:com.saraad.config
 * @Description:基本属性
 * @author: saraad
 * @date: 2018/11/13 0:13
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
@Configuration
@ConfigurationProperties(prefix = "db.druid")
public class DruidConfig {

        private String url;
        private String username;
        private String password;
        private String driverClass;

        private int maxActive;
        private int minIdle;
        private int initialSize;
        private int maxWait;

        //two means of this property:
        //1) Destroy线程会检测连接的间隔时间，如果连接空闲时间大于等于minEvicta
        //2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
        private int timeBetweenEvictionRunsMillis;
        //连接保持空闲而不被驱逐的最小时间
        private int minEvictableIdleTimeMillis;
        //用来检测连接是否有效的sql，要求是一个查询语句，常用select 'x'。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
        private String validationQuery;

        //    #建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
        private boolean testWhileIdle;
        //    #归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
        private boolean testOnReturn;
        //    #申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        private boolean testOnBorrow;

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getDriverClass() {
                return driverClass;
        }

        public void setDriverClass(String driverClass) {
                this.driverClass = driverClass;
        }

        public int getMaxActive() {
                return maxActive;
        }

        public void setMaxActive(int maxActive) {
                this.maxActive = maxActive;
        }

        public int getMinIdle() {
                return minIdle;
        }

        public void setMinIdle(int minIdle) {
                this.minIdle = minIdle;
        }

        public int getInitialSize() {
                return initialSize;
        }

        public void setInitialSize(int initialSize) {
                this.initialSize = initialSize;
        }

        public int getMaxWait() {
                return maxWait;
        }

        public void setMaxWait(int maxWait) {
                this.maxWait = maxWait;
        }

        public int getTimeBetweenEvictionRunsMillis() {
                return timeBetweenEvictionRunsMillis;
        }

        public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
                this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
        }

        public int getMinEvictableIdleTimeMillis() {
                return minEvictableIdleTimeMillis;
        }

        public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
                this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
        }

        public String getValidationQuery() {
                return validationQuery;
        }

        public void setValidationQuery(String validationQuery) {
                this.validationQuery = validationQuery;
        }

        public boolean isTestWhileIdle() {
                return testWhileIdle;
        }

        public void setTestWhileIdle(boolean testWhileIdle) {
                this.testWhileIdle = testWhileIdle;
        }

        public boolean isTestOnReturn() {
                return testOnReturn;
        }

        public void setTestOnReturn(boolean testOnReturn) {
                this.testOnReturn = testOnReturn;
        }

        public boolean isTestOnBorrow() {
                return testOnBorrow;
        }

        public void setTestOnBorrow(boolean testOnBorrow) {
                this.testOnBorrow = testOnBorrow;
        }
}
