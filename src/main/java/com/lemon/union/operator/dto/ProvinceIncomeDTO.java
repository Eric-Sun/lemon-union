package com.lemon.union.operator.dto;

public class ProvinceIncomeDTO {

    private String province;
    private int ivrcount = 0;
    private float ivrincome = 0;
    private int smscount = 0;
    private float smsincome = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinceIncomeDTO that = (ProvinceIncomeDTO) o;

        if (province != null ? !province.equals(that.province) : that.province != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return province != null ? province.hashCode() : 0;
    }

    public int getIvrcount() {
        return ivrcount;
    }

    public void setIvrcount(int ivrcount) {
        this.ivrcount = ivrcount;
    }

    public float getIvrincome() {
        return ivrincome;
    }

    public void setIvrincome(float ivrincome) {
        this.ivrincome = ivrincome;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getSmscount() {
        return smscount;
    }

    public void setSmscount(int smscount) {
        this.smscount = smscount;
    }

    public float getSmsincome() {
        return smsincome;
    }

    public void setSmsincome(float smsincome) {
        this.smsincome = smsincome;
    }
}
