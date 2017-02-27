package com.bitacademy.chat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatmsgDAO extends JpaRepository<Chatmsg, Long>
{

}
