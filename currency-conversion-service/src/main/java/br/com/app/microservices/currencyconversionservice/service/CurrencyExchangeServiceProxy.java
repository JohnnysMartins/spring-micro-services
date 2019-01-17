package br.com.app.microservices.currencyconversionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.app.microservices.currencyconversionservice.dto.CurrencyConvertionDTO;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConvertionDTO retriveExchange(@PathVariable("from") String from, @PathVariable("to") String to);
}
