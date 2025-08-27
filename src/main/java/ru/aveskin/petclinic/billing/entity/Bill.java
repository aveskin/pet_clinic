package ru.aveskin.petclinic.billing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.aveskin.petclinic.visit.entity.Visit;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "bills", schema = "pet_clinic")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "visit_id", nullable = false)
    private Visit visit;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillStatus status;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

}