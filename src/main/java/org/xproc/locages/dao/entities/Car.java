package org.xproc.locages.dao.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cars")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String NbrPlate;
    private int KmDriven;
    private String Color;
    private Double RentPrice;
    private int NbrSeats;
    private String Type;
    private boolean Availability;
    private String Cmodel;
    private String Make;
    private double CarPrice;
    private double CarGains;
    @ManyToMany
    @JoinTable(
            name = "Car_Employee",
            joinColumns = @JoinColumn(name = "Cars_id"),
            inverseJoinColumns = @JoinColumn(name = "employer_id")
    )
    private Set<Employee> employees = new HashSet<>();




}