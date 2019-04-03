package com.example.hssdemo.domain;

import java.util.Date;

public class UeDump {
    private String imsi;
    private int attachstatus;
    private String ueipaddr;
    private Date uestatuschangetime;
    private String uemacroenbid;
    private String uecellid;
    private String mmeappip;
    private String rgwid;

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

    public String getUemacroenbid() {
        return uemacroenbid;
    }

    public void setUemacroenbid(String uemacroenbid) {
        this.uemacroenbid = uemacroenbid;
    }

    public String getUecellid() {
        return uecellid;
    }

    public void setUecellid(String uecellid) {
        this.uecellid = uecellid;
    }

    public String getMmeappip() {
        return mmeappip;
    }

    public void setMmeappip(String mmeappip) {
        this.mmeappip = mmeappip;
    }

    public String getRgwid() {
        return rgwid;
    }

    public void setRgwid(String rgwid) {
        this.rgwid = rgwid;
    }
}

/*
imsi, attachstatus, ueipaddr, uestatuschangetime, uemacroenbid, uecellid, mmeappip, rgwid
 */