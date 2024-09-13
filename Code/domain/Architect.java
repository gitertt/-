package pym.project.test2.domain;

import pym.project.test2.service.Status;

/**
 * ClassName: Architect
 * Package: pym.project.test2.domain
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/11 20:02
 * @Version: 1.0
 */
//架构师类
public class Architect extends Designer{
    private int stock;//公司奖励的股票数量

    public Architect(int id, String name, int age, double salary,
                     int memberid, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, memberid, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //返回职位信息
    @Override
    public String getInfo(){
        return "架构师";
    }

    @Override
    public String toString() {
        return "Architect{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                "memberid=" + getMemberid() +
                ", status=" + getStatus() +
                ", equipment=" + getEquipment().getDescription() +
                ", bonus=" + getBonus() +
                ", stock=" + stock +
                '}';
    }
}
