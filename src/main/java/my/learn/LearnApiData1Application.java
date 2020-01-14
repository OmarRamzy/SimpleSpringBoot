package my.learn;
import my.packages.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import my.packages.starter.TopicRepository;

@SpringBootApplication(scanBasePackages = {"my.packages.starter"})
@ComponentScan(basePackageClasses = TopicRepository.class , basePackages = "my.packages.starter")
public class LearnApiData1Application    {

	public static void main(String[] args) {
		SpringApplication.run(LearnApiData1Application.class, args);
	}

}
