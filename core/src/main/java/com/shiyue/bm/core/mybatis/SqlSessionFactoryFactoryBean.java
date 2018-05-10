package com.shiyue.bm.core.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.InputStream;

/**
 * <br/>
 * Created on 16/11/5.
 *
 * @auther lishenghao01
 */
public class SqlSessionFactoryFactoryBean implements FactoryBean<SqlSessionFactory>, InitializingBean, DisposableBean {
    private SqlSessionFactory sqlSessionFactory;
    private String mybatisConf = "mybatis.xml";

    @Override
    public void destroy() throws Exception {
    }

    @Override
    public SqlSessionFactory getObject() throws Exception {
        return this.sqlSessionFactory;
    }

    @Override
    public Class<?> getObjectType() {
        return SqlSessionFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(this.mybatisConf);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public String getMybatisConf() {
        return mybatisConf;
    }

    public void setMybatisConf(String mybatisConf) {
        this.mybatisConf = mybatisConf;
    }
}
