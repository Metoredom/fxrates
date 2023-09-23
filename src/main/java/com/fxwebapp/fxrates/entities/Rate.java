package com.fxwebapp.fxrates.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "rates",
        indexes = {@Index(name = "idx_ccy", columnList="ccy_from, ccy_to"),
                @Index(name = "idx_date", columnList="date")})
public class Rate {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "ccy_from")
    private String ccyFrom;

    @Column(name = "ccy_to")
    private String ccyTo;

    @Column
    private float rate;

    @Column
    private Date date;

}
