package com.yedam.app.lombok;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// 생성자패턴중 Builder 패턴에 해당하는 코드
public class MybatisSqlSessionFactory {
	// DAO 역할을 해줄 클래스 : Singleton, 아직 MyBatis 추가안해서 에러남
	private static SqlSessionFactory sqlSessionFactory;
	private MybatisSqlSessionFactory() {
		String resource = "config/mybatis-config.xml"; // src/main/resources 가 프로젝트에 등록되어있기때문에 config 부터 들어가도(상대경로 써도)된다.
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
