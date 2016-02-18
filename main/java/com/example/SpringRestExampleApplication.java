package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestExampleApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringRestExampleApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(SpringRestExampleApplication.class, args);
        
    }
    
    @Bean
    public static CommandLineRunner demo(PersonRepository repository){
		
    	return (args) -> {
    					// save a list of persons with firstName and lastName
    					repository.save(new Person("Jack", "Palmer"));
    					repository.save(new Person("Chloe", "Palmer"));
    					repository.save(new Person("Kim", "Patrick"));
    					repository.save(new Person("David", "Palmer"));
    					repository.save(new Person("Michelle", "Dessler"));

    					// fetch all persons
    					log.info("Persons found with findAll():");
    					log.info("-------------------------------");
    					repository.findAll().stream().
    									forEach((person) -> {
    															log.info(person.toString());
    														});
    					
    					/*
    					 for (Person person : repository.findAll()) {
    					 
    						log.info(person.toString());
    					}
    					*/
    					
    		            log.info("");

    					// fetch an individual customer by ID
    		            Person person = repository.findOne(1L);
    					log.info("Person found with findOne(1L):");
    					log.info("--------------------------------");
    					log.info(person.toString());
    		            log.info("");

    					// fetch customers by last name
    					log.info("Person found with findByLastName('Bauer'):");
    					log.info("--------------------------------------------");
    					repository.findByLastName("Bauer").stream().
		    							forEach((bauer) -> {
		    													log.info(bauer.toString());
		    												});
    					
    					/*
    					for (Person bauer : repository.findByLastName("Bauer")) {
    						log.info(bauer.toString());
    					}
    					*/
    		            log.info("");
    	};
    	
    }
}
