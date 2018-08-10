package net.stelmaszak.homeworkcms.filter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReqInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String browser;
    private String dataCzas;
    private int reqTime;
    private String ipAdress;

    public ReqInfo() {
    }

    public ReqInfo(String browser, String dataCzas, int reqTime, String ipAdress) {
        this.browser = browser;
        this.dataCzas = dataCzas;
        this.reqTime = reqTime;
        this.ipAdress = ipAdress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getDataCzas() {
        return dataCzas;
    }

    public void setDataCzas(String dataCzas) {
        this.dataCzas = dataCzas;
    }

    public int getReqTime() {
        return reqTime;
    }

    public void setReqTime(int reqTime) {
        this.reqTime = reqTime;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }
}
