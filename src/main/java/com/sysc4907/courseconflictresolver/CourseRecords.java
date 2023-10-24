package com.sysc4907.courseconflictresolver;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * This class defines every single column in the database
 * that was taken straight from the excel sheet.
 * Each attribute also has a getter and setter.
 *
 * @author Mohammad
 */
@Entity
public class CourseRecords {

    @Id
    @GeneratedValue
    private Long Id;
    private String FAC;
    private String DEPT;
    private String TERM;
    private String CRN;
    private String SUBJ;
    private String CRSE;
    private String CATALOG_TITLE;
    private String STATUS;
    private String LNK_ID;
    private String LNK_CONN;
    private String DAYS;
    private String START_TIME;
    private String END_TIME;
    private String BLDG;
    private String ROOM;
    private String START_DATE;
    private String END_DATE;
    private String MAX_ENR;
    private String ACT_ENR;
    private String ROOM_CAP;
    private String VOICE_AVAIL;
    
    public CourseRecords() {
        super();
    }

    public String getFAC() {
        return FAC;
    }

    public void setFAC(String FAC) {
        this.FAC = FAC;
    }

    public String getDEPT() {
        return DEPT;
    }

    public void setDEPT(String DEPT) {
        this.DEPT = DEPT;
    }

    public String getTERM() {
        return TERM;
    }

    public void setTERM(String TERM) {
        this.TERM = TERM;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    public String getSUBJ() {
        return SUBJ;
    }

    public void setSUBJ(String SUBJ) {
        this.SUBJ = SUBJ;
    }

    public String getCRSE() {
        return CRSE;
    }

    public void setCRSE(String CRSE) {
        this.CRSE = CRSE;
    }

    public String getCATALOG_TITLE() {
        return CATALOG_TITLE;
    }

    public void setCATALOG_TITLE(String CATALOG_TITLE) {
        this.CATALOG_TITLE = CATALOG_TITLE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getLNK_ID() {
        return LNK_ID;
    }

    public void setLNK_ID(String LNK_ID) {
        this.LNK_ID = LNK_ID;
    }

    public String getLNK_CONN() {
        return LNK_CONN;
    }

    public void setLNK_CONN(String LNK_CONN) {
        this.LNK_CONN = LNK_CONN;
    }

    public String getDAYS() {
        return DAYS;
    }

    public void setDAYS(String DAYS) {
        this.DAYS = DAYS;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(String START_TIME) {
        this.START_TIME = START_TIME;
    }

    public String getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(String END_TIME) {
        this.END_TIME = END_TIME;
    }

    public String getBLDG() {
        return BLDG;
    }

    public void setBLDG(String BLDG) {
        this.BLDG = BLDG;
    }

    public String getROOM() {
        return ROOM;
    }

    public void setROOM(String ROOM) {
        this.ROOM = ROOM;
    }

    public String getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(String START_DATE) {
        this.START_DATE = START_DATE;
    }

    public String getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(String END_DATE) {
        this.END_DATE = END_DATE;
    }

    public String getMAX_ENR() {
        return MAX_ENR;
    }

    public void setMAX_ENR(String MAX_ENR) {
        this.MAX_ENR = MAX_ENR;
    }

    public String getACT_ENR() {
        return ACT_ENR;
    }

    public void setACT_ENR(String ACT_ENR) {
        this.ACT_ENR = ACT_ENR;
    }

    public String getROOM_CAP() {
        return ROOM_CAP;
    }

    public void setROOM_CAP(String ROOM_CAP) {
        this.ROOM_CAP = ROOM_CAP;
    }

    public String getVOICE_AVAIL() {
        return VOICE_AVAIL;
    }

    public void setVOICE_AVAIL(String VOICE_AVAIL) {
        this.VOICE_AVAIL = VOICE_AVAIL;
    }

}
