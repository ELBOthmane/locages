package org.xproc.locages.dao.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String NbrCin;
    private String Name;
    private String LastName;
    private int PhoneNbr;
    private String Email;
    private String DrvLNbr;
    private Date DrvLExpD;
    private String Address;

}

