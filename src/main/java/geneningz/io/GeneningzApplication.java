package geneningz.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@SpringBootApplication(scanBasePackages = {
//		"geneningz.io.aspect",
//		"geneningz.io.dao",
//		"geneningz.io.handler",
//		"geneningz.io.interceptor",
//		"geneningz.io.po",
//		"geneningz.io.service",
//		"geneningz.io.util",
//		"geneningz.io.web",
//		"geneningz.io.web.admin"
//})
//@SpringBootApplication(scanBasePackages = {"geneningz.io.service"})
//@ComponentScan(basePackages = {"geneningz.io.service"})

@SpringBootApplication
public class GeneningzApplication {

	public static void main(String[] args) {

		SpringApplication.run(GeneningzApplication.class, args);
	}

}

