package br.com.app.microservices.currencyexchangeservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.microservices.currencyexchangeservice.exception.ExchangeNotFoundException;
import br.com.app.microservices.currencyexchangeservice.model.Exchange;
import br.com.app.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public Exchange retriveExchange(@PathVariable String from, @PathVariable String to) throws Exception {
		Optional<Exchange> exchangeValue = repository.findByFromAndTo(from, to);
		environment.getProperty("local.server.port");
		return exchangeValue.orElseThrow(() -> new ExchangeNotFoundException(
				String.format("exchange value from %s to %s doesn't exist on this database", from, to)));
	}
}
