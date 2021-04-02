package com.springboot.jpa.spring_data_jpa.service;

import com.springboot.jpa.spring_data_jpa.dao.PeopleRepository;
import com.springboot.jpa.spring_data_jpa.entity.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImpl implements PeopleService{

    private PeopleRepository peopleRepository;

    @Autowired
    public void setPeopleDAO(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    @Transactional
    public List<PeopleEntity> getAllPeople(){
        return peopleRepository.findAll();
    }

    @Override
    @Transactional
    public void savePerson(PeopleEntity person) {
        peopleRepository.save(person);
    }

    @Override
    @Transactional
    public PeopleEntity getPerson(int peopleId) {
        PeopleEntity person = null;
        Optional<PeopleEntity> opt = peopleRepository.findById(peopleId);
        if(opt.isPresent()) person = opt.get();
        return person;
    }

    @Override
    @Transactional
    public void deletePerson(int personId) {
        peopleRepository.deleteById(personId);
    }

    @Override
    public List<PeopleEntity> findAllByName(String name) {
        List<PeopleEntity> people = peopleRepository.findAllByName(name);
        return people;
    }
}
