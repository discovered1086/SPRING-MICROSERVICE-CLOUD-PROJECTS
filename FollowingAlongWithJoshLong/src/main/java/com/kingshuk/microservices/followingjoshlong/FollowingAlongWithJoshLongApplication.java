package com.kingshuk.microservices.followingjoshlong;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SpringBootApplication
public class FollowingAlongWithJoshLongApplication {
	
	//We need some data when we want to bootstrap our application
	@Bean
	CommandLineRunner runner(StudentRepository studentRepository) {
		return args -> {
			Arrays.asList(new Student("Kingshuk", "a@b.com"), new Student("Deeksha","c@d.com"))
			.forEach(studentRepository::save);
			
			studentRepository.findAll().forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(FollowingAlongWithJoshLongApplication.class, args);
	}

}

@RestController
@RefreshScope
class MyRestController{
	
	@Value("${message.kingshuk}")
	private String message;
	
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}
}

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
class Student{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String email;
}


//We want to expose this repository over the web, so we'll use the annotation
@RepositoryRestResource
interface StudentRepository extends JpaRepository<Student, Long>{
	
	//We also  want to  map this finder method over a web service, so we'll go
	@RestResource(path="by-name")
	//And we also want to map the parameter to an HTTP request parameter, so we'll annotate the parameter as well
	Collection<Student> findByName(@Param("studentName") String studentName);
}













