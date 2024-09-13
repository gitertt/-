package pym.project.test2.service;

import org.junit.Test;
import pym.project.test2.domain.Architect;
import pym.project.test2.domain.Designer;
import pym.project.test2.domain.Employee;
import pym.project.test2.domain.Programmer;

import java.time.temporal.TemporalAccessor;
import java.util.Objects;

/**
 * ClassName: TeamService
 * Package: pym.project.test2.service
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/12 16:05
 * @Version: 1.0
 */
//关于开发团队成员的管理类
public class TeamService {

    private static int counter = 1;//为新增成员生成唯一ID
    private final int MAX_MEMBER = 5;//开发成员的最大人数
    //开发成员集合
    private Programmer[] team= new Programmer[MAX_MEMBER];
    //开发成员实际人数
    private int total = 0;
    //团队中已有的程序员
    private int programmerNum = 0;
    //团队中已有的设计师
    private int designerNum = 0;
    //团队中已有的架构师
    private int architectNum = 0;

    //返回当前团队的所有对象
    public Programmer[] getTeam(){
        Programmer[] programmers = new Programmer[total];
        System.arraycopy(team, 0, programmers, 0, total);
        return programmers;
    }
    //向开发团队中添加成员
    public void addMember(Employee employee) throws TeamException{
        if(total>=MAX_MEMBER)
            throw new TeamException("开发团队人数已满");

        //判断该员工是否在休假
        if(employee instanceof Programmer&&((Programmer)employee).getStatus()==Status.VOCATION)
            throw new TeamException("该员工正在休年假");
        //判断团队中是否已有该成员
        boolean flag = false;
        for(int i=0;i<total;i++){
            if(employee==team[i])
                flag = true;
            if(flag==true)
                break;
        }
        if(flag==true)
            throw new TeamException("该员工已是团队成员");

        if(employee instanceof Architect){
            if(architectNum==1)
                throw new TeamException("团队中至多有一名架构师");
            else{
                team[total] = (Architect)employee;
                team[total].setMemberid(counter);
                counter++;
                total++;
                architectNum++;
            }
        }
        else if(employee instanceof Designer){
            if(designerNum==2)
                throw new TeamException("团队中至多有两名设计师");
            else{
                team[total] = (Designer)employee;
                team[total].setMemberid(counter);
                counter++;
                total++;
                designerNum++;
            }
        }
        else if(employee instanceof Programmer){
            if(programmerNum==3)
                throw new TeamException("团队中至多有三名程序员");
            else{
                team[total] = (Programmer)employee;
                team[total].setMemberid(counter);
                counter++;
                total++;
                programmerNum++;
            }
        }
        else
            throw new TeamException(("该员工不是开发人员，无法添加"));


    }

    //从开发团队中根据id移除成员
    public void removeMember(int memberId) throws TeamException{
        int flag = -1;//标记需要删除的成员位置
        for(int i=0;i<total;i++){
            if(team[i].getMemberid() == memberId){
                flag = i;
                break;
            }
        }
        if(flag==-1)
            throw new TeamException("此id的成员不存在！");
        else{
            if(team[flag] instanceof Architect)
                architectNum--;
            else if(team[flag] instanceof Designer)
                designerNum--;
            else
                programmerNum--;

            if (total - 1 - flag >= 0) System.arraycopy(team, flag + 1, team, flag, total - 1 - flag);
            team[total-1] = null;
            total--;
        }
    }

    //单元测试,测试通过
//    @Test
//    public void test(){
//        TeamService teamService = new TeamService();
//        NameListService nameListService = new NameListService();
//        Employee[] employees1 = nameListService.getAllEmployees();
//        for(int i=1;i<4;i++){
//            try {
//                teamService.addMember(employees1[i]);
//
//            } catch (TeamException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            teamService.removeMember(2);
//        } catch (TeamException e) {
//            e.printStackTrace();
//        }
//    }
}
