package com.maersk.test.solution2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { CurrencyService.class, CurrencyController.class })
@WebMvcTest(controllers = CurrencyController.class)
public class Solution2Tests {

	@Autowired
	private WebApplicationContext applicationContext;

	@Autowired
	private MockMvc mockMvc;

	private List<CurrencyModel> content;

	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
		content = new ArrayList<CurrencyModel>(Arrays.asList(new CurrencyModel() {
			{
				setCurrency("USD");
				setAmount(10F);
			}
		}, new CurrencyModel() {
			{
				setCurrency("USD");
				setAmount(20F);
			}
		}, new CurrencyModel() {
			{
				setCurrency("EUR");
				setAmount(10F);
			}
		}, new CurrencyModel() {
			{
				setCurrency("INR");
				setAmount(10F);
			}
		}, new CurrencyModel() {
			{
				setCurrency("INR");
				setAmount(10F);
			}
		}));

	}

	@Test
	void itShouldGetSummationOfCurrency() throws Exception {

		mockMvc.perform(post("/currency").content(asJsonString(content)).contentType("application/json"))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.USD").value(30))
				.andExpect(MockMvcResultMatchers.jsonPath("$.EUR").value(10))
				.andExpect(MockMvcResultMatchers.jsonPath("$.INR").value(20));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
