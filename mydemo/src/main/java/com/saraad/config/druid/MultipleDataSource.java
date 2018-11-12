package com.saraad.config.druid;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: MultipleDataSource
 * @Package:com.saraad.config.druid
 * @Description:切数据源专用
 * @author: saraad
 * @date: 2018/11/13 1:24
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource{

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static final String DEFAULT_DATASOURCE = "default";
    public static final String SLAVE_DATASOURCE = "slave";
    public static final String LOG_DATASOURCE = "log";
    public static final String PRODUCT_DATASOURCE = "product";
    public static final String BATCH_DATASOURCE = "batchOrder";


    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    public static void removeDataSource() {
        dataSourceKey.remove();
    }
}
