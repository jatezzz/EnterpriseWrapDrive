package enterprise.warp.drive.management.v020;

public class Scotty {

    public static void main(String[] args) {
        /*
        Scotty Ingresa de manera individual los posibles
        estados y observa la respuesta del sistema.
        */
        
        Computer computer = new Computer();
        computer.SetState(0, 0, 0, 0);
        System.out.println(computer.getReportInjectors());
        System.out.println(computer.getTimeReportInjectors());

    }
}
