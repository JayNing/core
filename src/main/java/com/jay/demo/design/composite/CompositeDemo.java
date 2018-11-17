package com.jay.demo.design.composite;

/**
 * @Author JAY
 * @Date 2018/11/17 22:58
 * @Description 组合模式demo
 **/
public class CompositeDemo {

    public static void main(String[] args) {
        ChildCompany root = new ChildCompany("北京总公司");
        //给分公司添加两个枝叶（两个部门）
        HRDepartment hrDepartment = new HRDepartment("北京总公司人事部");
        FinanceDepartment financeDepartment = new FinanceDepartment("北京总公司财务部");
        root.add(hrDepartment);
        root.add(financeDepartment);

        ChildCompany childCompany = new ChildCompany("苏州分公司");
        //给分公司添加两个枝叶（两个部门）
        HRDepartment hrDepartment1 = new HRDepartment("苏州分公司人事部");
        FinanceDepartment financeDepartment1 = new FinanceDepartment("苏州分公司财务部");
        childCompany.add(hrDepartment1);
        childCompany.add(financeDepartment1);
        root.add(childCompany);

        root.display(1);
        root.lineOfDuty();
    }

}
