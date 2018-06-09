package com.dvp.demo.controller;

import com.dvp.demo.daos.*;
//import com.dvp.demo.models.PatientenEntity;
import com.dvp.demo.models.*;
import com.dvp.demo.models.containers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
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

    @RequestMapping(value = "/getSendung", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SendungEntity getSendung(@RequestBody PeriodeKundennummerContainer pkc) {
       SendungEntity se = sendungRepo.findByperiodeAndKundennummer(pkc.periode, pkc.kundennummer);
       return se;
    }

    @RequestMapping(value = "/getVerordnungenByPeriodeAndKundennummer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<VerordnungEntity> getVerordnungByPeriodeAndKundennummer(@RequestBody PeriodeKundennummerContainer pkc) {
        List<VerordnungEntity> el = verordnungRepo.findByperiodeAndKundennummer(pkc.periode, pkc.kundennummer);
        return el;
    }

    @RequestMapping(value = "/createSendung", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean createSendung(@RequestBody SendungEntity se) {
        se.setDatum(new Timestamp(new java.util.Date().getTime()));
        sendungRepo.save(se);
        return true;
    }

    @RequestMapping(value = "/setPeriode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean setPeriode(@RequestBody VerordnungIdSendungContainer visc) {
        VerordnungEntity ve = verordnungRepo.findByvidAndKundennummer(visc.vid, visc.kundennummer);
        ve.setPeriode(visc.periode);
        verordnungRepo.save(ve);
        return true;
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
        return sendungRepo.findBykundennummerOrderByDatumDesc(kc.kundennummer);
    }

    @RequestMapping(value = "/getOffenePerioden", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<SendungEntity> getOffenePerioden(@RequestBody KundennummerContainer kc){
        return sendungRepo.findBykundennummerAndStatusEqualsOrderByDatumDesc(kc.kundennummer,0);
    }

    @RequestMapping(value = "/completeSendung", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean completeSendung(@RequestBody PeriodeKundennummerContainer pkc){
        SendungEntity se = sendungRepo.findByperiodeAndKundennummer(pkc.periode, pkc.kundennummer);
        se.setStatus(1);
        List<VerordnungEntity> vl = verordnungRepo.findByperiodeAndKundennummer(pkc.periode, pkc.kundennummer);
        for(int i = 0; i<vl.size(); i++){
            vl.get(i).setStatus(1);
        }
        verordnungRepo.save(vl);

        return true;
    }

    @RequestMapping(value = "/getVerordnungContainer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VerordnungContainer getVerordnungContainer(@RequestBody VerordnungIdKundennummerContainer vikc){

        VerordnungContainer vc = new VerordnungContainer();

        vc.bewilligungen = bewilligungRepo.findByvid(vikc.vid);
        vc.diagnosen = diagnoseRepo.findByvid(vikc.vid);
        vc.leistungen = leistungRepo.findByvid(vikc.vid);
        vc.leistungserbringer = leistungserbringerRepo.findByvid(vikc.vid);
        vc.vo = verordnungRepo.findByvidAndKundennummer(vikc.vid,vikc.kundennummer);
        System.out.println(vc.toString());
        return vc;
    }

    @RequestMapping(value = "/copyVerordnung", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public VerordnungContainer copyVerordnung(@RequestBody VerordnungIdKundennummerContainer vikc) {

        VerordnungContainer vc = new VerordnungContainer();

        vc.bewilligungen = bewilligungRepo.findByvid(vikc.vid);
        if(vc.bewilligungen!=null&&!vc.bewilligungen.isEmpty()) {
            for (int i = 0; i < vc.leistungserbringer.size(); i++) {
                vc.bewilligungen.get(i).setVid(0);
            }
        }

        vc.diagnosen = diagnoseRepo.findByvid(vikc.vid);
        if(vc.diagnosen!=null&&!vc.diagnosen.isEmpty()) {
            for (int i = 0; i < vc.diagnosen.size(); i++) {
                vc.diagnosen.get(i).setVid(0);
            }
        }

        vc.leistungen = null; //werden nicht kopiert

        vc.leistungserbringer = leistungserbringerRepo.findByvid(vikc.vid);
        if(vc.leistungserbringer!=null&&!vc.leistungserbringer.isEmpty()) {
            for (int i = 0; i < vc.leistungserbringer.size(); i++) {
                vc.leistungserbringer.get(i).setVid(0);
            }
        }

        vc.vo = verordnungRepo.findByvidAndKundennummer(vikc.vid,vikc.kundennummer);
        if(vc.vo!=null) {
            vc.vo.setVid(0);
        }

        return vc;
    }



}
