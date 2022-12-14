package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Hello from me")
	public void testHelloStartpoint() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello from me")));
	}

	@Test
	@DisplayName("the hello greeting should be correct when returned by the server endpoint")
	public void testHelloEndpoint() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello!")));
	}

	@Test
	@DisplayName("the hello greeting with name should be correct when returned by the server endpoint")
	public void testHelloWithNameEndpoint() throws Exception {
		mockMvc.perform(get("/hello/John"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello!, John")));
	}
}
