package com.bitacademy.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
@Transactional(rollbackFor={Throwable.class})
public interface CustomerDAO extends JpaRepository<Customer, String>{ // customer에 id는 String타입

}
