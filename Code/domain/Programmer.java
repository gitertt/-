package pym.project.test2.domain;

import pym.project.test2.service.Status;

/**
 * ClassName: Programmer
 * Package: pym.project.test2.domain
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/11 19:53
 * @Version: 1.0
 */
//职工：程序员
public class Programmer extends Employee{
    private int memberid;//记录成员加入开发团队后，在团队中的id
    private Status status = Status.FREE;//职工目前状态
    private Equipment equipment;//职工领取的设备

    public Programmer(int id, String name, int age, double salary,
                      int memberid,Equipment equipment) {
        super(id, name, age, salary);
        this.memberid = memberid;
        this.equipment = equipment;
    }

    //返回职位信息
    @Override
    public String getInfo(){
        return "程序员";
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                "memberid=" + memberid +
                ", status=" + status +
                ", equipment=" + equipment.getDescription() +
                '}';
    }
}
