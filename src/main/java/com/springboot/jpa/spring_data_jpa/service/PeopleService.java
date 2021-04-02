package com.springboot.jpa.spring_data_jpa.service;

import com.springboot.jpa.spring_data_jpa.entity.PeopleEntity;

import java.util.List;

public interface PeopleService {
    List<PeopleEntity> getAllPeople();

    void savePerson(PeopleEntity person);

    PeopleEntity getPerson(int peopleId);

    void deletePerson(int personId);

    List<PeopleEntity> findAllByName(String name);

}
