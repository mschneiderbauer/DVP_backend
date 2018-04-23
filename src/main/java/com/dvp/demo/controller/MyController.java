package com.dvp.demo.controller;

import com.dvp.demo.daos.*;
//import com.dvp.demo.models.PatientenEntity;
import com.dvp.demo.models.*;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:**")
@RestController
public class MyController {

    @Autowired
    PatientenRepo patientenRepo;

    @Autowired
    VerordnungRepo verordnungRepo;

    @Autowired
    KostentraegerRepo kostentraegerRepo;

    @Autowired
    BewilligungRepo bewilligungRepo;

    @Autowired
    DiagnoseRepo diagnoseRepo;

    @Autowired
    LeistungRepo leistungRepo;

    @Autowired
    SendungRepo sendungRepo;


    @RequestMapping(value = "/alleKostentraeger", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<KostentraegerEntity> getAlleKostentraeger() {
        List<KostentraegerEntity> entities = (List<KostentraegerEntity>) kostentraegerRepo.findAll();
        return entities;
    }

    @RequestMapping(value = "/patientById", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientenEntity getPatientById(@RequestBody PatientIdContainer ct) {
        PatientenEntity pe = patientenRepo.findByvsnrpAndKundennummer(ct.vsnrp,ct.kundennummer);
        return pe;
    }

    @RequestMapping(value = "/createPatient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPatient(@RequestBody PatientenEntity pe) {
        patientenRepo.save(pe);
    }

    @RequestMapping(value = "/createLeistungen", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createLeistungen(@RequestBody List<LeistungEntity> el) {
        leistungRepo.save(el);
    }

    @RequestMapping(value = "/createDiagnosen", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createDiagnosen(@RequestBody List<DiagnoseEntity> el) {
        System.out.println(JSONArray.toJSONString(el));
        diagnoseRepo.save(el);
    }

    @RequestMapping(value = "/createBewilligungen", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBewilligungen(@RequestBody List<BewilligungEntity> el) {
        bewilligungRepo.save(el);
    }

    @RequestMapping(value = "/createVerordnung", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public long createVerordnung(@RequestBody VerordnungEntity ve) {
        verordnungRepo.save(ve);
        return ve.getVid();
    }

    @RequestMapping(value = "/getVerordnungenByVSNRP", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<VerordnungEntity> getVerordnungByVSNRP(@RequestBody PatientIdContainer pic) {
        List<VerordnungEntity> el = verordnungRepo.findByvsnrpAndKundennummer(pic.vsnrp, pic.kundennummer);
        return el;
    }

    @RequestMapping(value = "/getVerordnungenBysendungid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<VerordnungEntity> getVerordnungBysendungid(@RequestBody SendungIdKundennummerContainer sikc) {
        List<VerordnungEntity> el = verordnungRepo.findBysendungidAndKundennummer(sikc.sendungid, sikc.kundennummer);
        return el;
    }

    @RequestMapping(value = "/createSendung", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSendung(@RequestBody SendungEntity se) {
        sendungRepo.save(se);
    }

    @RequestMapping(value = "/setSendungId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setSendungId(@RequestBody long vid, long sId) {
        VerordnungEntity ve = verordnungRepo.findOne(vid);
        ve.setSendungid(sId);
        verordnungRepo.save(ve);
    }

    @RequestMapping(value = "/setKostentraeger_id", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setKostentraeger_id(@RequestBody KostentraegerPatientContainer kpc) {
        PatientenEntity pe = patientenRepo.findByvsnrpAndKundennummer(kpc.vsnrp,kpc.kundennummer);
        pe.setKostentraeger_id(kpc.kostentraeger_id);
        patientenRepo.save(pe);
    }

    @RequestMapping(value = "/deleteVerordnung", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public boolean deleteVerordnung(@RequestBody VerordnungIdKundennummerContainer vikc) {
        verordnungRepo.deleteByVidAndKundennummer(vikc.vid,vikc.kundennummer);
        bewilligungRepo.deleteByVid(vikc.vid);
        diagnoseRepo.deleteByVid(vikc.vid);
        leistungRepo.deleteByVid(vikc.vid);
        return true;
    }

}
