package com.mycode.bms.theatremgmt;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@ComponentScan(basePackages = {"com.mycode.bms.theatremgmt"})
@EnableAutoConfiguration
@SpringBootApplication
public class TheatreMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreMgmtApplication.class, args);
	}

}
