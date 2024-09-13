package pym.project.test2.service;


import org.junit.Test;
import pym.project.test2.domain.*;

/**
 * ClassName: NameListService
 * Package: pym.project.test2.service
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/11 20:40
 * @Version: 1.0
 */
//员工管理类
public class NameListService {
    private Employee[] employees;//员工数组，包含公司所有员工

    //改进方法：相同代码提前，分模块处理；
    // 不同类（employee、programmer、designer等）共有的属性先提取出来，
    //然后再根据不同类进行switch... case...;
    //生成equipment类的部分代码可以另外声明个函数来生成，不然显得太繁杂。

    //利用Data中数据进行构造，包含12个成员
    public NameListService() {
        employees = new Employee[12];
        //读取Data类中的信息
        for(int i=0;i<12;i++){
            String[] employee_info = Data.EMPLOYEES[i];//获取职工的字符串信息
            String[] equipment_info = Data.EQUIPMENTS[i];//获取设备的字符串信息
            int flag = Integer.parseInt(employee_info[0]);//获取第一个字符串信息，转化为整数型
            //根据flag判断职工类型
            switch (flag){
                case Data.EMPLOYEE : {//添加普通员工
                    int id = Integer.parseInt(employee_info[1]);
                    String name = employee_info[2];
                    int age = Integer.parseInt(employee_info[3]);
                    double salary = (double) Integer.parseInt(employee_info[4]);
                    employees[i] = new Employee(id, name, age, salary);//添加职工信息
                    break;
                }
                case Data.PROGRAMMER: {//添加程序员
                    int id = Integer.parseInt(employee_info[1]);
                    String name = employee_info[2];
                    int age = Integer.parseInt(employee_info[3]);
                    double salary = (double) Integer.parseInt(employee_info[4]);
                    //获取Equipment数据
                    int equipmentType = Integer.parseInt(equipment_info[0]);
                    switch(equipmentType){
                        case Data.PC:{//设备为PC
                            String model = equipment_info[1];
                            String display = equipment_info[2];
                            PC pc = new PC(model,display);
                            employees[i] = new Programmer(id,name,age,salary,0,pc);
                            break;
                        }
                        case Data.NOTEBOOK:{//设备为笔记本
                            String model = equipment_info[1];
                            double price = (double)Integer.parseInt(equipment_info[2]);
                            NoteBook noteBook = new NoteBook(model,price);
                            employees[i] = new Programmer(id,name,age,salary,0,noteBook);
                            break;
                        }
                        case Data.PRINTER:{//设备为打印机
                            String equipName = equipment_info[1];
                            String type = equipment_info[2];
                            Printer printer = new Printer(equipName,type);
                            employees[i] = new Programmer(id,name,age,salary,0,printer);
                            break;
                        }
                    }
                    break;
                }
                case Data.DESIGNER:{//添加设计员工
                    int id = Integer.parseInt(employee_info[1]);
                    String name = employee_info[2];
                    int age = Integer.parseInt(employee_info[3]);
                    double salary = (double) Integer.parseInt(employee_info[4]);
                    double bonus = (double) Integer.parseInt(employee_info[5]);
                    //获取Equipment数据
                    int equipmentType = Integer.parseInt(equipment_info[0]);
                    switch(equipmentType){
                        case Data.PC:{//设备为PC
                            String model = equipment_info[1];
                            String display = equipment_info[2];
                            PC pc = new PC(model,display);
                            employees[i] = new Designer(id,name,age,salary,0,pc,bonus);
                            break;
                        }
                        case Data.NOTEBOOK:{//设备为笔记本
                            String model = equipment_info[1];
                            double price = (double)Integer.parseInt(equipment_info[2]);
                            NoteBook noteBook = new NoteBook(model,price);
                            employees[i] = new Designer(id,name,age,salary,0,noteBook,bonus);
                            break;
                        }
                        case Data.PRINTER:{//设备为打印机
                            String equipName = equipment_info[1];
                            String type = equipment_info[2];
                            Printer printer = new Printer(equipName,type);
                            employees[i] = new Designer(id,name,age,salary,0,printer,bonus);
                            break;
                        }
                    }
                    break;
                }
                case Data.ARCHITECT:{//添加架构师
                    int id = Integer.parseInt(employee_info[1]);
                    String name = employee_info[2];
                    int age = Integer.parseInt(employee_info[3]);
                    double salary = (double) Integer.parseInt(employee_info[4]);
                    double bonus = (double) Integer.parseInt(employee_info[5]);
                    int stock = Integer.parseInt(employee_info[6]);
                    //获取Equipment数据
                    int equipmentType = Integer.parseInt(equipment_info[0]);
                    switch(equipmentType){
                        case Data.PC:{//设备为PC
                            String model = equipment_info[1];
                            String display = equipment_info[2];
                            PC pc = new PC(model,display);
                            employees[i] = new Architect(id,name,age,salary,0,pc,bonus,stock);
                            break;
                        }
                        case Data.NOTEBOOK:{//设备为笔记本
                            String model = equipment_info[1];
                            double price = (double)Integer.parseInt(equipment_info[2]);
                            NoteBook noteBook = new NoteBook(model,price);
                            employees[i] = new Architect(id,name,age,salary,0,noteBook,bonus,stock);
                            break;
                        }
                        case Data.PRINTER:{//设备为打印机
                            String equipName = equipment_info[1];
                            String type = equipment_info[2];
                            Printer printer = new Printer(equipName,type);
                            employees[i] = new Architect(id,name,age,salary,0,printer,bonus,stock);
                            break;
                        }
                    }
                    break;
                }
            }

        }
    }

    //获取所有员工信息数组
    public Employee[] getAllEmployees(){
        return employees;
    }

    //获取指定ID的员工对象
    public Employee getEmployee(int id) throws TeamException{
        if(id<1||id>12)
            throw new TeamException("id输入不合理，请输入id(0——12)： ");
        //返回员工对象
        return employees[id-1];
    }


    //单元测试，测试通过
//    @Test
//    public void test(){
//        NameListService nameListService = new NameListService();
//        Employee[] employees1 = nameListService.getAllEmployees();
//        try {
//            Employee employee = nameListService.getEmployee(13);
//            System.out.println(employee);
//        } catch (TeamException e) {
//            e.printStackTrace();
//        }
//    }
}
