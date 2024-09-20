package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ApplicationTests {
	
	@Test
	void FluxTest() {
		
		Flux<String> item = Flux.just("Mobile","Laptop","Cable")
							    .map(s->s.concat("Devices")) // Data Tranformation
								//.concatWith(Flux.error(new RuntimeException("Exception occured")))
								.log();
		
		item.subscribe(System.out::println , 
							(e) -> System.err.println("Exception :"+ e),
							()->System.out.println("Completed"));
	}
	
	@Test
	void MonoTest() {
		
		Mono<?> item = Mono.just("MobileMono")
				.then(Mono.error(new RuntimeException("Exception Occured"))) .log();
							  //  .map(s->s.concat("Devices")) // Data Tranformation
								//.concatWith(Flux.error(new RuntimeException("Exception occured")))
		item.subscribe(System.out::println, (e)->System.out.println(e.getMessage()));
	}

}
