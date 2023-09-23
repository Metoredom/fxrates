package com.fxwebapp.fxrates.repositories;

import com.fxwebapp.fxrates.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface RatesRepository extends JpaRepository<Rate, Long> {}
