package org.example.eventorganizer;

import org.springframework.boot.SpringApplication;

public class TestEventOrganizerApplication{

	public static void main(String[] args){
		SpringApplication.from(EventOrganizerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
