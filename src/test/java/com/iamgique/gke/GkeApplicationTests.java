package com.iamgique.gke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class GkeApplicationTests {

	@InjectMocks
	GkeApplication app;

	private MockMvc mvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		app = new GkeApplication();
		mvc = MockMvcBuilders.standaloneSetup(app)
				.build();
	}

	@DisplayName("Test get hello with PathVariable success")
	@Test
	void testGetHelloWithPathVariableSuccess() throws Exception {
		MvcResult mvcResult = mvc.perform(get("/hello/Gique"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello Gique"))
				.andReturn();
	}
}
