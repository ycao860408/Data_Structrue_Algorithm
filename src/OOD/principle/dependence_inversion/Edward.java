package OOD.principle.dependence_inversion;

public class Edward {
    /*public void buySwitch(Switch aSwitch) {
        aSwitch.playSwitch();
    }*/

    /* 借口声明对象
    public void buy(IGame game) {
        game.play();
    }*/

    /* setter 传递依赖对象
    private IGame igame;

    public void setIgame(IGame igame) {
        this.igame = igame;
    }

    public void buy() {
        igame.play();
    }*/
    // 构造函数传递依赖对象
    private IGame igame;

    public Edward(IGame igame) {
        this.igame = igame;
    }

    public void buy() {
        igame.play();
    }

}
