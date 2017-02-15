package com.bitacademy.ex02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.ex02.vo.Customer;

@Transactional(rollbackFor={Throwable.class})
public interface CustomerDAO extends JpaRepository<Customer, String>
{
	// 더 무언가를 넣어야했는지 잘 기억안난다.
	// 내가 만든 쿼리가 있을때만 추가 했던거 같고
	// 보통 필요한거는 JpaRepository에 만들어져있어서 그거 꺼내썼던거 같다
}
