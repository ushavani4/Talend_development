package com.edi;

import com.edi.service.EdifactParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.edi"})
@EnableAutoConfiguration
public class EdifactParserApplication {



	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(EdifactParserApplication.class, args);
		try {
			context.getBean("edifactParser", EdifactParser.class).useScanner();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
