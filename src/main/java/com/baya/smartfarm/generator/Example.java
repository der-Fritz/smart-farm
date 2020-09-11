package com.baya.smartfarm.generator;////package com.bayah.smartmanager.generator;
////
////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
////import lombok.Getter;
////import lombok.Setter;
////import lombok.ToString;
////import org.hibernate.annotations.GenericGenerator;
////import org.hibernate.annotations.Parameter;
////
////import javax.persistence.*;
////
////@Entity
////@Table(name = "examples", indexes = {@Index(name = "indx_example", columnList = "id", unique = true)})
////@Getter
////@Setter
////@ToString
////@Access(AccessType.FIELD)
////@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
////public class Example {
////    @Id
////    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "example_seq")
////    @GenericGenerator(
////            name = "example_seq",
////            strategy = "CustomIdGenerator",
////            parameters = {
////                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
////                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "B_"),
////                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
////    private String id;
//
//}
