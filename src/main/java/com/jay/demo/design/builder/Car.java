package com.jay.demo.design.builder;

/**
 * @Author JAY
 * @Date 2018/11/11 11:00
 * @Description 汽车类
 **/
public class Car {

    public String lunTai;//论胎

    private String faDongJi;

    private String cheChuang;

    public String getLunTai() {
        return lunTai;
    }

    public void setLunTai(String lunTai) {
        this.lunTai = lunTai;
    }

    public String getFaDongJi() {
        return faDongJi;
    }

    public void setFaDongJi(String faDongJi) {
        this.faDongJi = faDongJi;
    }

    public String getCheChuang() {
        return cheChuang;
    }

    public void setCheChuang(String cheChuang) {
        this.cheChuang = cheChuang;
    }

    @Override
    public String toString() {
        return "Car{" +
                "lunTai='" + lunTai + '\'' +
                ", faDongJi='" + faDongJi + '\'' +
                ", cheChuang='" + cheChuang + '\'' +
                '}';
    }
}
