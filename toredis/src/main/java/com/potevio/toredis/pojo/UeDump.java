package com.potevio.toredis.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tuedump")
public class UeDump implements Serializable {
    @Id
    private String imsi;
    private int attachstatus;
    private String ueipaddr;
    private Date uestatuschangetime;
    private int uemacroenbid;
    private int uecellid;
    private String mmeappip;
    private int rgwid;

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public int getAttachstatus() {
        return attachstatus;
    }

    public void setAttachstatus(int attachstatus) {
        this.attachstatus = attachstatus;
    }

    public String getUeipaddr() {
        return ueipaddr;
    }

    public void setUeipaddr(String ueipaddr) {
        this.ueipaddr = ueipaddr;
    }

    public Date getUestatuschangetime() {
        return uestatuschangetime;
    }

    public void setUestatuschangetime(Date uestatuschangetime) {
        this.uestatuschangetime = uestatuschangetime;
    }

    public int getUemacroenbid() {
        return uemacroenbid;
    }

    public void setUemacroenbid(int uemacroenbid) {
        this.uemacroenbid = uemacroenbid;
    }

    public int getUecellid() {
        return uecellid;
    }

    public void setUecellid(int uecellid) {
        this.uecellid = uecellid;
    }

    public String getMmeappip() {
        return mmeappip;
    }

    public void setMmeappip(String mmeappip) {
        this.mmeappip = mmeappip;
    }

    public int getRgwid() {
        return rgwid;
    }

    public void setRgwid(int rgwid) {
        this.rgwid = rgwid;
    }

    @Override
    public String toString() {
        return "UeDump{" +
                "imsi='" + imsi + '\'' +
                ", attachstatus=" + attachstatus +
                ", ueipaddr='" + ueipaddr + '\'' +
                ", uestatuschangetime=" + uestatuschangetime +
                ", uemacroenbid='" + uemacroenbid + '\'' +
                ", uecellid='" + uecellid + '\'' +
                ", mmeappip='" + mmeappip + '\'' +
                ", rgwid='" + rgwid + '\'' +
                '}';
    }
}