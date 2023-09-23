package com.fxwebapp.fxrates.repositories;

import com.fxwebapp.fxrates.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface CurrenciesRepository extends JpaRepository<Currency, Long> {

    List<Currency> findByCcy(String ccy_to);

}
