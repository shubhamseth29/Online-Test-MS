package com.cg.testmgmt.dao;

import com.cg.testmgmt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long> {

}
