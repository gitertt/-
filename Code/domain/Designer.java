package pym.project.test2.domain;

import pym.project.test2.service.Status;

/**
 * ClassName: Designer
 * Package: pym.project.test2.domain
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/11 20:01
 * @Version: 1.0
 */
//设计师类
public class Designer extends Programmer{
    private double bonus;//奖金

    public Designer(int id, String name, int age, double salary, int memberid,
                     Equipment equipment, double bonus) {
        super(id, name, age, salary, memberid, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    //返回职位信息
    @Override
    public String getInfo(){
        return "设计师";
    }
    @Override
    public String toString() {
        return "Designer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                "memberid=" + getMemberid() +
                ", status=" + getStatus() +
                ", equipment=" + getEquipment().getDescription() +
                ", bonus=" + bonus +
                '}';
    }
}
