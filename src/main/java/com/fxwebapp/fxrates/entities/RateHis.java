package com.fxwebapp.fxrates.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "rates_his",
        indexes = {@Index(name = "idx_his_ccy", columnList = "ccy_to"),
                @Index(name = "idx_his_date", columnList = "date")})
public class RateHis {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "ccy_from")
    private String ccyFrom;

    @Column(name = "ccy_to")
    private String ccyTo;

    @Column
    private float rate;

    @Column(name = "date")
    private Date date;

}
