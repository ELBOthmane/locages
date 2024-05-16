package org.xproc.locages.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Type;
    private Date date;
    private Double MaintenancePrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Car_id") // This is the foreign key column in the Maintenance table
    private Car car;
}