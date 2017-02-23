package com.coffee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.vo.Customer;

@Transactional(rollbackFor = {Throwable.class})
public interface CustomerDAO extends JpaRepository<Customer, String>
{

}
