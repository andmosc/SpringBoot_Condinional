package ru.andmosc.conditionalapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConditionalAppApplicationTests {
	@Autowired
	private TestRestTemplate testRestTemplate;
	private static final String LOCALHOST = "http://localhost:";
	private static final String PROFILE = "/profile";
	private static final String DEV_RETURN = "Current profile is Dev";
	private static final String PROD_RETURN = "Current profile is production";
	private static Integer mappedDevappPort;
	private static Integer mappedProdappPort;


	@Container
	private static final GenericContainer<?> devApp = new GenericContainer<>("devapp8080:latest")
			.withExposedPorts(8080);
	@Container
	private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp8081:latest")
			.withExposedPorts(8081);
	@BeforeAll
	static void beforeAll() {
		mappedDevappPort = devApp.getMappedPort(8080);
		mappedProdappPort = prodApp.getMappedPort(8081);
	}
	@Test
	void devApp() {
		ResponseEntity<String> responseDev = testRestTemplate
				.getForEntity(LOCALHOST + mappedDevappPort + PROFILE, String.class);
		assertEquals(DEV_RETURN,responseDev.getBody());
	}
	@Test
	void prodApp() {
		ResponseEntity<String> responseProd = testRestTemplate
				.getForEntity(LOCALHOST + mappedProdappPort + PROFILE, String.class);
		assertEquals(PROD_RETURN,responseProd.getBody());
	}
}
