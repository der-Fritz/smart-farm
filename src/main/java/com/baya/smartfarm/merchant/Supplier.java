package com.baya.smartfarm.merchant;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.location.District;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "suppliers", indexes = {@Index(name = "indx_supplier", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supplier extends BaseEntity {

    @Column(name = "name", length = 50, unique = false, nullable = false)
    private String name;

    @Column(name = "msisdn", length = 50, nullable = false)
    private String msisdn;

    @Column(name = "merchant_type", length = 50, nullable = false)
    private MerchantType merchantType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "district_id", nullable = false)
    @JsonIgnore
    private District district;

    @Column(name = "longitude", length = 50, nullable = true)
    private String longitude;

    @Column(name = "latitude", length = 50, nullable = true)
    private String latitude;

    @Column(name = "growth_point", length = 50, nullable = false)
    private String growthPoint;
}
