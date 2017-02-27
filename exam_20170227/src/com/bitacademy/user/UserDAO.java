package com.bitacademy.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Throwable.class}) // 맞나
public interface UserDAO extends JpaRepository<User, String>
{

}
