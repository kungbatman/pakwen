package com.fileTest.Entity;

public class TextContent {

    private String id; //记录的唯一值，以防重复传输。
    private String houseCode; // 用户编号
    private String ownerName; //用户名称
    private String csbh; //厂商编号，99代表虚拟厂商编号
    private String bh; //当前表号
    private Double ljrl; //表数
    private String cbsj; //上次抄表时间（只有大于系统内的时间时才更新）
    private Double yl;  //用量
    private Double wbts;  //无表天数(计量预付费的情况传0即可)
    private String cjsj; //采集时间（精确到秒）

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCsbh() {
        return csbh;
    }

    public void setCsbh(String csbh) {
        this.csbh = csbh;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public Double getLjrl() {
        return ljrl;
    }

    public void setLjrl(Double ljrl) {
        this.ljrl = ljrl;
    }

    public String getCbsj() {
        return cbsj;
    }

    public void setCbsj(String cbsj) {
        this.cbsj = cbsj;
    }

    public Double getYl() {
        return yl;
    }

    public void setYl(Double yl) {
        this.yl = yl;
    }

    public Double getWbts() {
        return wbts;
    }

    public void setWbts(Double wbts) {
        this.wbts = wbts;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }


}
