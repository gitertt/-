package pym.project.test2.domain;

/**
 * ClassName: Printer
 * Package: pym.project.test2.domain
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/11 19:38
 * @Version: 1.0
 */
//设备：打印机
public class Printer implements Equipment{
    private String name;
    private String type;

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //实现接口的抽象方法，输出描述信息
    @Override
    public String getDescription(){
        return name+"("+type+")";
    }
}
