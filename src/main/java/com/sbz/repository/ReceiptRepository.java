package com.sbz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbz.models.Customer;
import com.sbz.models.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long>{

	List<Receipt> findByCustomer(Customer c);

}
