package OOD.principle.dependence_inversion;

public class Test {
    public static void main(String[] args) {
       /* Edward edward = new Edward();
        Switch aSwitch = new Switch();
        edward.buySwitch(aSwitch);*/

        //Edward edward = new Edward();
        IGame g1 = new XBOX();
        IGame g2 = new Switch();
        IGame g3 = new PS5();
        /*edward.buy(g1);
        edward.buy(g2);
        edward.buy(g3);*/

        /*edward.setIgame(g1);
        edward.buy();
        edward.setIgame(g2);
        edward.buy();
        edward.setIgame(g3);
        edward.buy();*/

        Edward edward = new Edward(g1);
        edward.buy();
        edward = new Edward(g2);
        edward.buy();
        edward = new Edward(g3);
        edward.buy();
    }
}
