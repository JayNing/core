package com.jay.demo.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/17 22:51
 * @Description 子公司
 **/
public class ChildCompany extends Company {

    private List<Company> companyList = new ArrayList<>();

    public ChildCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        this.companyList.add(company);
    }

    @Override
    public void remove(Company company) {
        this.companyList.remove(company);
    }

    @Override
    public void display(int depty) {
        System.out.println("深度：" + depty + "，名称：" + name);
        for (Company company1 : companyList) {
            company1.display(depty + 1);
        }
    }

    @Override
    public void lineOfDuty() {
        for (Company company : companyList) {
            company.lineOfDuty();
        }
    }
}
