package com.udacity.pricing;

import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	PricingService pricingService;

	/**
	 * This test method checks the functionality of the 'contextLoads' function.
	 * It performs an HTTP GET request to the '/services/price' endpoint with a 'vehicleId' parameter.
	 * The test verifies that the response status is 'OK', and it checks specific JSON properties:
	 * - 'vehicleId' should have a value of 1L.
	 * - 'currency' should have a value of "USD".
	 * - 'price' should be a number.
	 */
    @Test
    public void contextLoads() {
		try {
			String urlTemplate = "/services/price?vehicleId=1";
			mockMvc.perform(get(urlTemplate))
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("vehicleId").value(1L))
					.andExpect(MockMvcResultMatchers.jsonPath("currency").value("USD"))
					.andExpect(MockMvcResultMatchers.jsonPath("price").isNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
