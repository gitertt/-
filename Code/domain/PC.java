package pym.project.test2.domain;

/**
 * ClassName: PC
 * Package: pym.project.test2.domain
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/11 19:36
 * @Version: 1.0
 */
//设备：电脑
public class PC implements Equipment{
    private String model;
    private String display;

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
    //实现接口的抽象方法，输出描述信息
    @Override
    public String getDescription(){
        return model+"("+display+")";
    }
}
