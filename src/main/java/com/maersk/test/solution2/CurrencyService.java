package com.maersk.test.solution2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
	public Map<String, Double> getSumBasedOnCurrency(List<CurrencyModel> currencyModelList) {

		return currencyModelList.stream().collect(
				Collectors.groupingBy(CurrencyModel::getCurrency, Collectors.summingDouble(CurrencyModel::getAmount)));
	}
}
