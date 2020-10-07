package com.baya.smartfarm.merchant;

import com.baya.smartfarm.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "merchant", indexes = {@Index(name = "indx_index", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Merchant extends BaseEntity {

    @Column(name = "name", length = 50, unique = false, nullable = false)
    private String name;


    @Column(name = "msisdn", length = 50, nullable = false)
    private String msisdn;

    @Column(name = "merchant_type", length = 50, nullable = false)
    private MerchantType merchantType;


    @Column(name = "longitude", length = 50, nullable = true)
    private String longitude;

    @Column(name = "latitude", length = 50, nullable = true)
    private String latitude;

    @Column(name = "growth_point", length = 50, nullable = false)
    private String growthPoint;

}
