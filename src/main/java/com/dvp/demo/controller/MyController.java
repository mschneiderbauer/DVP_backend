package com.dvp.demo.controller;

import com.dvp.demo.daos.*;
import com.dvp.demo.models.PatientenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http:/localhost:**")
@RestController
public class MyController {

    @Autowired
    PatientenRepo PatientenRepo;

    //alleKunden
    @RequestMapping(value = "/allePatienten" ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<PatientenEntity> getAlleKunden(/*@RequestBody UserTokenContainer utc*/){
        //if(Checktoken(utc.getSecretKey())){
            List <PatientenEntity> entities = (List<PatientenEntity>) PatientenRepo.findAll();
            return entities;
        //} else return null;
    }
}
