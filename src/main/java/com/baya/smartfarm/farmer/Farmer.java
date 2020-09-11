package com.baya.smartfarm.farmer;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.location.District;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "farmers", indexes = {@Index(name = "indx_farmers", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Farmer extends BaseEntity {

    @Column(name="first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "id_number", unique = true, nullable = false, length = 10)
    private String idNumber;

    @Column(name="msisdn", unique = true, nullable = false, length = 12)
    private String msisdn;

    @Column(name="latitude", length = 45)
    private String latitude;

    @Column(name="longitude", length = 45)
    private String longitude;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "district_id", nullable = false)
    @JsonIgnore
    private District district;

    @Column(name="village", length = 45)
    private String village;

}
