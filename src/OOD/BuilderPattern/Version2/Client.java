package OOD.BuilderPattern.Version2;

public class Client {
    public static void main(String[] args) {

        CEO jobs = new CEO(new Factory1());
        System.out.println(jobs.makeIPhone());

        jobs = new CEO(new Factory2());
        System.out.println(jobs.makeIPhone());
    }
}
