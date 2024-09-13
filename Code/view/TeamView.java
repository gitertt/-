package pym.project.test2.view;

import pym.project.test2.domain.Architect;
import pym.project.test2.domain.Designer;
import pym.project.test2.domain.Employee;
import pym.project.test2.domain.Programmer;
import pym.project.test2.service.NameListService;
import pym.project.test2.service.TeamException;
import pym.project.test2.service.TeamService;

/**
 * ClassName: TeamView
 * Package: pym.project.test2.view
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/12 17:02
 * @Version: 1.0
 */
//菜单显示类
public class TeamView {
    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
    //所有成员集合：读取数据后，12人
    private NameListService listSvc = new NameListService();
    //开发团队成员集合，初始为空
    private TeamService teamSvc = new TeamService();

    //主界面显示及控制方法
    public void enterMainMenu(){
        boolean flag = true;//标记是否退出系统
        while(flag){
            System.out.println("————————————————开发团队调度系统————————————————");
            listAllEmployees();//列出所有员工信息
            System.out.println("—————————————————————————————————————————————");
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            char choose = TSUtility.readMenuSelection();
            if(choose=='4'){
                flag = false;
                System.out.println("退出调度系统");
            }

            else if(choose=='1'){
                System.out.println("————————————————团队成员列表————————————————");
                getTeam();
                System.out.println("——————————————————————————————————————————");
                TSUtility.readReturn();
            }
            else if(choose=='2'){
                System.out.println("————————————————添加成员————————————————");
                addMember();
                TSUtility.readReturn();
            }
            else {
                System.out.println("————————————————删除成员————————————————");
                deleteMember();
                TSUtility.readReturn();
            }
        }
    }
    //以表格形式列出所有成员
    private void listAllEmployees(){
        Employee[] employees = listSvc.getAllEmployees();
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        for(int i=0;i<employees.length;i++){
            String info = employees[i].getInfo();//获取职位信息
            System.out.print(employees[i].getId()+"\t"
                    +employees[i].getName()+"\t"
                    +employees[i].getAge()+"\t"
                    +employees[i].getSalary()+"\t"
                    +employees[i].getInfo()+"\t");
            if(info=="普通员工"){
                System.out.println();
            }
            else if(info=="程序员"){
                System.out.print(((Programmer)employees[i]).getStatus()+"\t\t\t"
                        +((Programmer)employees[i]).getEquipment().getDescription());
                System.out.println();
            }
            else if(info=="设计师"){
                System.out.print(((Designer)employees[i]).getStatus()+"\t"
                        +((Designer)employees[i]).getBonus()+"\t\t"
                        +((Designer)employees[i]).getEquipment().getDescription());
                System.out.println();
            }
            else{
                System.out.print(((Architect)employees[i]).getStatus()+"\t"
                        +((Architect)employees[i]).getBonus()+"\t"
                        +((Architect)employees[i]).getStock()+"\t"
                        +((Architect)employees[i]).getEquipment().getDescription());
                System.out.println();
            }
        }
    }

    //显示团队成员列表操作
    private void getTeam(){
        Programmer[] programmers = teamSvc.getTeam();
        System.out.println("TDI/ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票");
        for(int i=0;i<programmers.length;i++){
            String teamInfo = programmers[i].getInfo();
            System.out.print(programmers[i].getMemberid()+"/"+programmers[i].getId()+"\t"
                    +programmers[i].getName()+"\t"+programmers[i].getAge()+"\t"
                    +programmers[i].getSalary()+"\t"+programmers[i].getInfo()+"\t"
                    +programmers[i].getStatus()+"\t");
            if(teamInfo=="程序员"){
                System.out.println();
            }
            else if(teamInfo=="设计师"){
                System.out.println(((Designer)programmers[i]).getBonus());
            }
            else{
                System.out.println(((Architect)programmers[i]).getBonus()+"\t"
                        +((Architect)programmers[i]).getStock());
            }
        }
    }

    //添加开发团队成员操作
    public void addMember(){
        //获取需要添加的成员的id
        System.out.println("请输入要添加的员工id");
        int memberId = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(memberId);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            e.printStackTrace();
        }
    }

    //实现删除成员操作
    public void deleteMember(){
        System.out.println("请输入要删除成员的TID: ");
        int tid = TSUtility.readInt();//获取输入的tid
        System.out.println("确认是否删除(Y/N)：");
        char flag = TSUtility.readConfirmSelection();
        if(flag=='Y'){
            try {
                teamSvc.removeMember(tid);
                System.out.println("删除成功");
            } catch (TeamException e) {
                e.printStackTrace();
            }
        }
        else
            return ;
    }

}
