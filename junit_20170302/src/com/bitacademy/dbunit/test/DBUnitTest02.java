package com.bitacademy.dbunit.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

public class DBUnitTest02
{
	// Driver 객체 생성
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	private String xmlPath = "tbdept2_record.xml"; // "export.xml";

	@Before // @Test 하기 전에 실행됨
	public void dbinit()
	{
		// Driver 객체에 정보 넣기
		// 연결된 드라이버 설정
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		// 연결된 주소 설정
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		// 해당 주소의 접근가능한 유저 이름
		dataSource.setUsername("scott");
		// 해당 주소의 접근가능한 유저 비밀번호
		dataSource.setPassword("tiger");

		// 테이블 생성 쿼리의 실행 // 스크립트 위치는 script/table.script
		// SimpleJdbcTestUtils.executeSqlScript(new SimpleJdbcTemplate(dataSource), new ClassPathResource("table.script"), true);
		SimpleJdbcTestUtils.executeSqlScript(new SimpleJdbcTemplate(dataSource), new ClassPathResource("table.script"), true);
		System.out.println("table.script를 실행함");

		// 쿼리 백업
		// exportRecord();
		// 쿼리 복원 import
		// importRecord();
	}

	@Test
	public void importRecord() throws Throwable
	{
		// 데이터베이스 연결 정보 주기
		IDatabaseConnection connection = new DatabaseConnection(dataSource.getConnection());

		// 저장하려는 xml 주소로 데이터 셋 만들기
		IDataSet dataset = new FlatXmlDataSetBuilder().build(new File(xmlPath));

		// DatabaseOperation.CLEAN_INSERT.execute(IDatabaseConnection connection, IDataSet dataSet);
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
		System.out.println("xml 테이블 집어넣음");
	}

}
