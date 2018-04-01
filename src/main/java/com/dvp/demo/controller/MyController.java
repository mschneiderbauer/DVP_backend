package com.dvp.demo.controller;

import com.dvp.demo.daos.*;
//import com.dvp.demo.models.PatientenEntity;
import com.dvp.demo.models.KostentraegerEntity;
import com.dvp.demo.models.PatientenEntity;
import com.dvp.demo.models.PatientenId;
import com.dvp.demo.models.VerordnungEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:**")
@RestController
public class MyController {

    @Autowired
    PatientenRepo PatientenRepo;

    @Autowired
    VerordnungRepo VerordnungRepo;

    @Autowired
    KostentraegerRepo KostentreagerRepo;

    @RequestMapping(value = "/alleVerordnungen" ,method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public List<VerordnungEntity> getAlleVerordnungen(/*@RequestBody UserTokenContainer utc*/){
        //if(Checktoken(utc.getSecretKey())){
            List <VerordnungEntity> entities = (List<VerordnungEntity>) VerordnungRepo.findAll();
            return entities;
        //} else return null;
    }

    @RequestMapping(value = "/alleKostentraeger" ,method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public List<KostentraegerEntity> getAlleKostentraeger(){
        List <KostentraegerEntity> entities = (List<KostentraegerEntity>) KostentreagerRepo.findAll();
        return entities;
    }

    @RequestMapping(value = "/patientById" ,method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public PatientenEntity getPatientById(@RequestBody PatientenId id){
        PatientenEntity pe = PatientenRepo.findOne(id);
        return pe;
    }


    @RequestMapping(value = "/createPatient" ,method = RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public void createPatient(@RequestBody PatientenEntity pe){

        //folgende Zeilen sind zum Testen
        ObjectMapper map = new ObjectMapper();

        try {
            System.out.println(map.writeValueAsString(pe));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        PatientenRepo.save(pe);
    }
}
