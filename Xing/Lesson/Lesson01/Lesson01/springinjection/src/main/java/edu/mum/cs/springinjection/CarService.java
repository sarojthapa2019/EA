package edu.mum.cs.springinjection;

import edu.mum.cs.springinjection.model.Car;
import edu.mum.cs.springinjection.model.Volkswagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;


@Component
public class CarService {

//    Inject Interface - doesn't work
//    @Resource
//    private Car car1;

//    @Autowired
//    private Car car;
//
//    @Inject
//    private Car car;

//    Field Type - works
//    @Resource
//    private Volkswagen car;
//
//    @Autowired
//    private Volkswagen car;
//
//    @Inject
//    private Volkswagen car;

//    Qualifier name
//    @Resource
//    @Qualifier("volkswagen")
//    private Car car;

//    @Autowired
//    @Qualifier("volkswagen")
//    private Car car;
//
//    @Inject
//    @Qualifier("volkswagen")
//    private Car car;


//    Conflicting Information
//    @Resource
//    @Qualifier("nkl")
//    private Car volkswagen;

//    @Autowired
//    @Qualifier("nkl")
//    private Car volkswagen;
//
//    @Inject
//    @Qualifier("nkl")
//    private Car volkswagen;
}
