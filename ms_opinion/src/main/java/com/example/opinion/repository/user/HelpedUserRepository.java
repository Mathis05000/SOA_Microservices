package com.example.opinion.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.opinion.entity.user.HelpedUser;

@Repository
public interface HelpedUserRepository extends JpaRepository<HelpedUser, Long> {

}