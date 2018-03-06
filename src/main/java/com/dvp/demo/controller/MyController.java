package com.dvp.demo.controller;

import com.dvp.demo.daos.*;
//import com.dvp.demo.models.PatientenEntity;
import com.dvp.demo.models.VerordnungEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:**")
@RestController
public class MyController {

    //@Autowired
    //PatientenRepo PatientenRepo;

    @Autowired
    VerordnungRepo VerordnungRepo;

    //alleKunden
    @RequestMapping(value = "/alleVerordnungen" ,method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public List<VerordnungEntity> getAlleVerordnungen(/*@RequestBody UserTokenContainer utc*/){
        //if(Checktoken(utc.getSecretKey())){
            List <VerordnungEntity> entities = (List<VerordnungEntity>) VerordnungRepo.findAll();
            return entities;
        //} else return null;
    }
}
