package com.reaction.JavaReactor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "TAXPAYERS")
@Entity
public class TaxPayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    private String costCenter;
    private String subheaderItem;
    private double balance;
    private String periodName;
    private String vote;
}
