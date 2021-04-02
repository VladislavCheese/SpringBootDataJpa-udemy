package com.springboot.jpa.spring_data_jpa.dao;

import com.springboot.jpa.spring_data_jpa.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<PeopleEntity, Integer> {
    List<PeopleEntity> findAllByName(String name);
}
