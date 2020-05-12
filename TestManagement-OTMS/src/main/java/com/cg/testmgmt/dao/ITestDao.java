package com.cg.testmgmt.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.testmgmt.entities.Test;

public interface ITestDao extends JpaRepository<Test,BigInteger>{

}
