package com.fxwebapp.fxrates.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "currencies",
        indexes = {@Index(name = "idx_ccy_ccy", columnList="ccy")})
public class Currency {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "ccy")
    private String ccy;

    @Column(name = "name")
    private String name;

}
