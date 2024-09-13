package pym.project.test2.domain;

import org.junit.Test;

/**
 * ClassName: Employee
 * Package: pym.project.test2.domain
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/11 19:44
 * @Version: 1.0
 */
//职工类
public class Employee {
    private int id;//职工id
    private String name;//职工名字
    private int age;//职工年龄
    private double salary;//职工薪资

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //返回职位信息
    public String getInfo(){
        return "普通员工";
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
