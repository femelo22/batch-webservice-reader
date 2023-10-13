package br.com.lf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BatchWebserviceReaderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BatchWebserviceReaderApplication.class, args);
		context.close();
	}

}
