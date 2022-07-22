package de.mobile.repository;


import de.mobile.model.MobileCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<MobileCustomer, Long> {
}
