package com.dvp.demo.controller;

import com.dvp.demo.daos.*;
//import com.dvp.demo.models.PatientenEntity;
import com.dvp.demo.models.*;
import com.dvp.demo.models.containers.*;
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

    @Autowired
    LeistungserbringerRepo leistungserbringerRepo;


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
        diagnoseRepo.save(el);
    }

    @RequestMapping(value = "/createLeistungserbringer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createLeistungserbringer(@RequestBody List<LeistungserbringerEntity> el) {
        leistungserbringerRepo.save(el);
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
    public void setSendungId(@RequestBody VerordnungIdSendungContainer visc) {
        VerordnungEntity ve = verordnungRepo.findByvidAndKundennummer(visc.vid, visc.kundennummer);
        ve.setSendungid(visc.sid);
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
        leistungserbringerRepo.deleteByVid(vikc.vid);
        return true;
    }

    @RequestMapping(value = "/getPeriodenByKundennummer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<SendungEntity> getPeriodenByKundennummer(@RequestBody KundennummerContainer kc){
        System.out.println(""+kc.kundennummer);
        return sendungRepo.findBykundennummer(kc.kundennummer);
    }

    @RequestMapping(value = "/getVerordnungContainer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VerordnungContainer getVerordnungContainer(@RequestBody VerordnungIdKundennummerContainer vikc){

        VerordnungContainer vc = new VerordnungContainer();

        vc.bewilligungEntities = bewilligungRepo.findByVid(vikc.vid);
        for(BewilligungEntity b : vc.bewilligungEntities){
            b.setVid(0);
        }
        vc.diagnoseEntities = diagnoseRepo.findByVid(vikc.vid);
        for(DiagnoseEntity d : vc.diagnoseEntities){
            d.setVid(0);
        }

        vc.leistungEntities = leistungRepo.findByVid(vikc.vid);
        for(LeistungEntity l : vc.leistungEntities){
            l.setVid(0);
        }

        vc.leistungserbringerEntities = leistungserbringerRepo.findByVid(vikc.vid);
        for(LeistungserbringerEntity l : vc.leistungserbringerEntities){
            l.setVid(0);
        }

        vc.verordnungEntity = verordnungRepo.findByvidAndKundennummer(vikc.vid,vikc.kundennummer);
        return vc;
    }

    /*@RequestMapping(value = "/copyVerordnung", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public boolean copyVerordnung(@RequestBody VerordnungIdKundennummerContainer vikc) {

        VerordnungEntity ve = verordnungRepo.findByvidAndKundennummer(vikc.vid,vikc.kundennummer);
        long vid = createVerordnung(ve);

        List<BewilligungEntity> be = bewilligungRepo.findByVid(vikc.vid);
        for(BewilligungEntity b : be){
            b.setVid(vid);
        }
        createBewilligungen(be);

        List<DiagnoseEntity> de = diagnoseRepo.findByVid(vikc.vid);
        for(DiagnoseEntity d : de){
            d.setVid(vid);
        }
        createDiagnosen(de);

        List<LeistungserbringerEntity> le =  leistungserbringerRepo.findByVid(vikc.vid);
        for(LeistungserbringerEntity l : le){
            l.setVid(vid);
        }
        createLeistungserbringer(le);

        return true;
    }*/



}
