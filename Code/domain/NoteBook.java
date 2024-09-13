package pym.project.test2.domain;

/**
 * ClassName: NoteBook
 * Package: pym.project.test2.domain
 * Description:
 *
 * @Author: pym
 * @Create: 2024/9/11 19:31
 * @Version: 1.0
 */
//设备：笔记本
public class NoteBook implements Equipment{
    private String model;
    private double price;
    public NoteBook(String model,double price){
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //实现接口的抽象方法，输出描述信息
    @Override
    public String getDescription(){
        return model+"("+price+")";
    }
}
