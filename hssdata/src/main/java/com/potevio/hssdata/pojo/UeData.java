package com.potevio.hssdata.pojo;

import javax.persistence.*;
import java.io.Serializable;


//@Entity
//@Table(name = "tuedata")
public class UeData implements Serializable {
    //    @Id
    private String imsi;
    private String mmeaddr;
    private int ispurged;
    private int ueambruL;
    private int ueambrdL;
    private String homestationaddr;
    private String homestationport;
    private int serviceareaind;
    private int uerohcind;
    private int freqind;
    private int algepc;
    private String ueipaddr;
    private int qci;
    private int apnambrul;
    private int apnambrdl;
    private int rgwidentity;
    private int pdntype;
    private String apn;

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMmeaddr() {
        return mmeaddr;
    }

    public void setMmeaddr(String mmeaddr) {
        this.mmeaddr = mmeaddr;
    }

    public int getIspurged() {
        return ispurged;
    }

    public void setIspurged(int ispurged) {
        this.ispurged = ispurged;
    }

    public int getUeambruL() {
        return ueambruL;
    }

    public void setUeambruL(int ueambruL) {
        this.ueambruL = ueambruL;
    }

    public int getUeambrdL() {
        return ueambrdL;
    }

    public void setUeambrdL(int ueambrdL) {
        this.ueambrdL = ueambrdL;
    }

    public String getHomestationaddr() {
        return homestationaddr;
    }

    public void setHomestationaddr(String homestationaddr) {
        this.homestationaddr = homestationaddr;
    }

    public String getHomestationport() {
        return homestationport;
    }

    public void setHomestationport(String homestationport) {
        this.homestationport = homestationport;
    }

    public int getServiceareaind() {
        return serviceareaind;
    }

    public void setServiceareaind(int serviceareaind) {
        this.serviceareaind = serviceareaind;
    }

    public int getUerohcind() {
        return uerohcind;
    }

    public void setUerohcind(int uerohcind) {
        this.uerohcind = uerohcind;
    }

    public int getFreqind() {
        return freqind;
    }

    public void setFreqind(int freqind) {
        this.freqind = freqind;
    }

    public int getAlgepc() {
        return algepc;
    }

    public void setAlgepc(int algepc) {
        this.algepc = algepc;
    }

    public String getUeipaddr() {
        return ueipaddr;
    }

    public void setUeipaddr(String ueipaddr) {
        this.ueipaddr = ueipaddr;
    }

    public int getQci() {
        return qci;
    }

    public void setQci(int qci) {
        this.qci = qci;
    }

    public int getApnambrul() {
        return apnambrul;
    }

    public void setApnambrul(int apnambrul) {
        this.apnambrul = apnambrul;
    }

    public int getApnambrdl() {
        return apnambrdl;
    }

    public void setApnambrdl(int apnambrdl) {
        this.apnambrdl = apnambrdl;
    }

    public int getRgwidentity() {
        return rgwidentity;
    }

    public void setRgwidentity(int rgwidentity) {
        this.rgwidentity = rgwidentity;
    }

    public int getPdntype() {
        return pdntype;
    }

    public void setPdntype(int pdntype) {
        this.pdntype = pdntype;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }
}
