package com.baya.smartfarm.sponsor;

import com.baya.smartfarm.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "sponsors", indexes = {@Index(name = "indx_sponsor", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sponsor extends BaseEntity {

    @Column(name="first_name", length = 45)
    private String firstName;

    @Column(name="last_name", length = 45)
    private String lastName;

    @Column(name = "id_number", unique = true, length = 10)
    private String idNumber;

    @Column(name="msisdn", unique = true, nullable = false, length = 12)
    private String msisdn;

    @Column(name="sponsor_type", unique = true, nullable = false, length = 45)
    private SponsorType sponsorType;

    @Column(name="organization", length = 45)
    private String organization;
}
