package com.yedam.app.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	//DAO 역할을 해줄 클래스 : 싱글톤
	private static SqlSessionFactory sqlSessionFactory;
	
	private MybatisSqlSessionFactory(){
		String resource = "config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource); // 키보드 마우스 입력파일을이용하여 
			sqlSessionFactory 
				= new SqlSessionFactoryBuilder().build(inputStream); // 빌더를기반으로 DB와소통가능한 sql세션팩토리를 만든다.
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory == null) {
			new MybatisSqlSessionFactory();
		}
		return sqlSessionFactory;
	}
}
