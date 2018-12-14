package br.com.app.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.microservices.limitsservice.bean.LimitsConfiguration;
import br.com.app.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfiguration() {
		return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

}
