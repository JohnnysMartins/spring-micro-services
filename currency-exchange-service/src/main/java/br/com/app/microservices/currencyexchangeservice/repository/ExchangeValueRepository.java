package br.com.app.microservices.currencyexchangeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app.microservices.currencyexchangeservice.model.Exchange;

@Repository
public interface ExchangeValueRepository extends JpaRepository<Exchange, Long> {
	Optional<Exchange> findByFromAndTo(String from, String to);
}
