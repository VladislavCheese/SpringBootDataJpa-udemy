package com.springboot.jpa.spring_data_jpa.controller;

import com.springboot.jpa.spring_data_jpa.entity.PeopleEntity;
import com.springboot.jpa.spring_data_jpa.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private PeopleService peopleService;

    @Autowired
    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public List<PeopleEntity> showAllPeople(){
        return peopleService.getAllPeople();
    }

    @GetMapping("/people/{id}")
    public PeopleEntity getPerson(@PathVariable int id){
        PeopleEntity person = peopleService.getPerson(id);
        return person;
    }

    @PostMapping("/people")
    public PeopleEntity addNewPerson(@RequestBody PeopleEntity person){
        peopleService.savePerson(person);
        return person;
    }

    @PutMapping("/people")
    public PeopleEntity updatePerson(@RequestBody PeopleEntity person){
        peopleService.savePerson(person);
        return person;
    }

    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable int id){
        peopleService.deletePerson(id);
        return "Person with ID = " + id + " was deleted";
    }
    @GetMapping("/people/name/{name}")
    public List<PeopleEntity> showAllPeopleByName(@PathVariable String name){
        List<PeopleEntity> peopleEntityList = peopleService.findAllByName(name);
        return peopleEntityList;
    }
}
