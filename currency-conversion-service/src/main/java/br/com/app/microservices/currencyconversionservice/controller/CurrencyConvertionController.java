package br.com.app.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.app.microservices.currencyconversionservice.dto.CurrencyConvertionDTO;
import br.com.app.microservices.currencyconversionservice.service.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConvertionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-convertion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionDTO convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) throws Exception {

		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		ResponseEntity<CurrencyConvertionDTO> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from//{from}/to/{to}", CurrencyConvertionDTO.class, uriVariable);

		CurrencyConvertionDTO response = responseEntity.getBody();
		
		System.out.println(response.getFrom());

		return new CurrencyConvertionDTO(response.getId(), response.getFrom(), response.getTo(),
				response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()));

	}
	
	@GetMapping("/currency-convertion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionDTO convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) throws Exception {

		CurrencyConvertionDTO response = proxy.retriveExchange(from, to);

		return new CurrencyConvertionDTO(response.getId(), response.getFrom(), response.getTo(),
				response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()));

	}
}
