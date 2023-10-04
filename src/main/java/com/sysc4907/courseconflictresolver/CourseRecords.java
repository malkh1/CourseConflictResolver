package com.sysc4907.courseconflictresolver;

import jakarta.persistence.Entity;

/**
 * This class defines every single column in the database
 * that was taken straight from the excel sheet.
 * Each attribute also has a getter and setter.
 * @author Mohammad
 */
@Entity
public class CourseRecords {


    public CourseRecords() {}
    
    private String FAC;
    private String DEPT;
    private String TERM;
    private String CRN;
    private String SUBJ;
    private String CRSE;
    private String SEQ;
    private String CATALOG_TITLE;
    private String LEVL;
    private String BILLINGHRS;
    private String ATTENMET;
    private String SSIND;
    private String X_L_CRSE;
    private String X_L_CODE;
    private String STATUS;
    private String LNK_ID;
    private String LNK_CONN;
    private String INSTR_TYPE;
    private String DAYS;
    private String START_TIME;
    private String END_TIME;
    private String BLDG;
    private String ROOM;
    private String START_DATE;
    private String END_DATE;
    private String COMB_MAX_ENR;
    private String COMB_ACT_ENRL;
    private String MAX_ENR;
    private String ACT_ENR;
    private String ROOM_CAP;
    private String COVID_CAPACITY;
    private String WAIT_MAX;
    private String WAIT_ACT;
    private String WAIT_REM;
    private String PARTITION_PREFERENCES;
    private String ROOM_ATTRIBUTES;
    private String VOICE_AVAIL;
    private String TUI_WAIVER;
    private String GRDBL_IND;
    private String SESS_CD;
    private String SESS_DESC;
    private String CREDITHRS;
    private String CAMP;
    private String SSASECT_TITLE;
    private String CRSE_PREREQ;
    private String SEC_PREREQ;
    private String SEC_FEES;
    private String ATTIBUTES;
    private String PTRM;
    private String LAST_DROP_DATE;
    
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

    public String getSEQ() {
        return SEQ;
    }

    public void setSEQ(String SEQ) {
        this.SEQ = SEQ;
    }

    public String getCATALOG_TITLE() {
        return CATALOG_TITLE;
    }

    public void setCATALOG_TITLE(String CATALOG_TITLE) {
        this.CATALOG_TITLE = CATALOG_TITLE;
    }

    public String getLEVL() {
        return LEVL;
    }

    public void setLEVL(String LEVL) {
        this.LEVL = LEVL;
    }

    public String getBILLINGHRS() {
        return BILLINGHRS;
    }

    public void setBILLINGHRS(String BILLINGHRS) {
        this.BILLINGHRS = BILLINGHRS;
    }

    public String getATTENMET() {
        return ATTENMET;
    }

    public void setATTENMET(String ATTENMET) {
        this.ATTENMET = ATTENMET;
    }

    public String getSSIND() {
        return SSIND;
    }

    public void setSSIND(String SSIND) {
        this.SSIND = SSIND;
    }

    public String getX_L_CRSE() {
        return X_L_CRSE;
    }

    public void setX_L_CRSE(String X_L_CRSE) {
        this.X_L_CRSE = X_L_CRSE;
    }

    public String getX_L_CODE() {
        return X_L_CODE;
    }

    public void setX_L_CODE(String X_L_CODE) {
        this.X_L_CODE = X_L_CODE;
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

    public String getINSTR_TYPE() {
        return INSTR_TYPE;
    }

    public void setINSTR_TYPE(String INSTR_TYPE) {
        this.INSTR_TYPE = INSTR_TYPE;
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

    public String getCOMB_MAX_ENR() {
        return COMB_MAX_ENR;
    }

    public void setCOMB_MAX_ENR(String COMB_MAX_ENR) {
        this.COMB_MAX_ENR = COMB_MAX_ENR;
    }

    public String getCOMB_ACT_ENRL() {
        return COMB_ACT_ENRL;
    }

    public void setCOMB_ACT_ENRL(String COMB_ACT_ENRL) {
        this.COMB_ACT_ENRL = COMB_ACT_ENRL;
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

    public String getCOVID_CAPACITY() {
        return COVID_CAPACITY;
    }

    public void setCOVID_CAPACITY(String COVID_CAPACITY) {
        this.COVID_CAPACITY = COVID_CAPACITY;
    }

    public String getWAIT_MAX() {
        return WAIT_MAX;
    }

    public void setWAIT_MAX(String WAIT_MAX) {
        this.WAIT_MAX = WAIT_MAX;
    }

    public String getWAIT_ACT() {
        return WAIT_ACT;
    }

    public void setWAIT_ACT(String WAIT_ACT) {
        this.WAIT_ACT = WAIT_ACT;
    }

    public String getWAIT_REM() {
        return WAIT_REM;
    }

    public void setWAIT_REM(String WAIT_REM) {
        this.WAIT_REM = WAIT_REM;
    }

    public String getPARTITION_PREFERENCES() {
        return PARTITION_PREFERENCES;
    }

    public void setPARTITION_PREFERENCES(String PARTITION_PREFERENCES) {
        this.PARTITION_PREFERENCES = PARTITION_PREFERENCES;
    }

    public String getROOM_ATTRIBUTES() {
        return ROOM_ATTRIBUTES;
    }

    public void setROOM_ATTRIBUTES(String ROOM_ATTRIBUTES) {
        this.ROOM_ATTRIBUTES = ROOM_ATTRIBUTES;
    }

    public String getVOICE_AVAIL() {
        return VOICE_AVAIL;
    }

    public void setVOICE_AVAIL(String VOICE_AVAIL) {
        this.VOICE_AVAIL = VOICE_AVAIL;
    }

    public String getTUI_WAIVER() {
        return TUI_WAIVER;
    }

    public void setTUI_WAIVER(String TUI_WAIVER) {
        this.TUI_WAIVER = TUI_WAIVER;
    }

    public String getGRDBL_IND() {
        return GRDBL_IND;
    }

    public void setGRDBL_IND(String GRDBL_IND) {
        this.GRDBL_IND = GRDBL_IND;
    }

    public String getSESS_CD() {
        return SESS_CD;
    }

    public void setSESS_CD(String SESS_CD) {
        this.SESS_CD = SESS_CD;
    }

    public String getSESS_DESC() {
        return SESS_DESC;
    }

    public void setSESS_DESC(String SESS_DESC) {
        this.SESS_DESC = SESS_DESC;
    }

    public String getCREDITHRS() {
        return CREDITHRS;
    }

    public void setCREDITHRS(String CREDITHRS) {
        this.CREDITHRS = CREDITHRS;
    }

    public String getCAMP() {
        return CAMP;
    }

    public void setCAMP(String CAMP) {
        this.CAMP = CAMP;
    }

    public String getSSASECT_TITLE() {
        return SSASECT_TITLE;
    }

    public void setSSASECT_TITLE(String SSASECT_TITLE) {
        this.SSASECT_TITLE = SSASECT_TITLE;
    }

    public String getCRSE_PREREQ() {
        return CRSE_PREREQ;
    }

    public void setCRSE_PREREQ(String CRSE_PREREQ) {
        this.CRSE_PREREQ = CRSE_PREREQ;
    }

    public String getSEC_PREREQ() {
        return SEC_PREREQ;
    }

    public void setSEC_PREREQ(String SEC_PREREQ) {
        this.SEC_PREREQ = SEC_PREREQ;
    }

    public String getSEC_FEES() {
        return SEC_FEES;
    }

    public void setSEC_FEES(String SEC_FEES) {
        this.SEC_FEES = SEC_FEES;
    }

    public String getATTIBUTES() {
        return ATTIBUTES;
    }

    public void setATTIBUTES(String ATTIBUTES) {
        this.ATTIBUTES = ATTIBUTES;
    }

    public String getPTRM() {
        return PTRM;
    }

    public void setPTRM(String PTRM) {
        this.PTRM = PTRM;
    }

    public String getLAST_DROP_DATE() {
        return LAST_DROP_DATE;
    }

    public void setLAST_DROP_DATE(String LAST_DROP_DATE) {
        this.LAST_DROP_DATE = LAST_DROP_DATE;
    }
      
}
