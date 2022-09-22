package com.sony.springbootbasics;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// any component in the package "com.sony.springbootbasics" or any of its subpackages
// will automatically be scanned and loaded into the spring container
@Slf4j
@Component
public class HelloWorld {

	public HelloWorld() {
		log.info("HelloWorld() called");
	}
}
