package com.iwen.dataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

//表示这个类为一个配置类
@Configuration
// 配置mybatis的接口类放的地方
@MapperScan(basePackages = "com.iwen.plan.dao", sqlSessionFactoryRef = "planSqlSessionFactory")
public class PlanConfig {
    // 将这个对象放入Spring容器中
    @Bean(name = "planDataSource") // 读取application.properties中的配置参数映射成为一个对象
    @ConfigurationProperties(prefix = "spring.datasource.plan")  // prefix表示参数的前缀
    public DataSource getDateSource1() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "planSqlSessionFactory") // @Qualifier表示查找Spring容器中名字为planDataSource的对象
    public SqlSessionFactory planSqlSessionFactory(@Qualifier("planDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:com/iwen/plan/dao/*.xml"));
        return bean.getObject();
    }

    @Bean("planSqlSessionTemplate")
    public SqlSessionTemplate plansqlsessiontemplate( @Qualifier("planSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

}
