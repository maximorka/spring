package com.dz8.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dz8.demo"})
public class Dz8Application {

	public static void main(String[] args) {

//	 String CONNECTION_URL;
//
//
//			String homeDirectory = System.getenv().get("HOME");
//
//			String dbFolderPath = homeDirectory + "/.Dz8";
//			new File(dbFolderPath).mkdirs();
//
//			CONNECTION_URL = "jdbc:h2:" + dbFolderPath + "/db";
//		System.out.println("CONNECTION_URL = " + CONNECTION_URL);
//		Flyway flyway = Flyway
//				.configure()
//				.dataSource("jdbc:mysql://localhost:3306/demo?useSSL=false",null, null)
//				.load();
//
//		flyway.migrate();
		SpringApplication.run(Dz8Application.class, args);

	}

}
