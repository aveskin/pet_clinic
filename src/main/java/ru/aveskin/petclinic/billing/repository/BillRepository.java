package ru.aveskin.petclinic.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aveskin.petclinic.billing.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
}