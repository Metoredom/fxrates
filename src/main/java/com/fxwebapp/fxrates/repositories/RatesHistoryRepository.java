package com.fxwebapp.fxrates.repositories;

import com.fxwebapp.fxrates.entities.RateHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface RatesHistoryRepository extends JpaRepository<RateHis, Long> {

    @Query(value = "SELECT rate FROM RateHis rate WHERE rate.ccyTo = :ccy_to")
    List<RateHis> findByCcyTo(String ccy_to);

}
