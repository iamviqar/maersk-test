package com.maersk.test.solution2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@PostMapping
	public Map<String, Double> getSumBasedOnCurrency(@RequestBody List<CurrencyModel> inputCurrency) {

		return currencyService.getSumBasedOnCurrency(inputCurrency);
	}

}
