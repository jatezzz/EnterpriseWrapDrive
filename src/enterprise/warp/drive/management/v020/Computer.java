package enterprise.warp.drive.management.v020;

public class Computer {

    private StarshipEnterprise starshipEnterprise;

    private PowerManagementSystem powerManagementSystem;

    public Computer() {
        
        starshipEnterprise = new StarshipEnterprise();
        powerManagementSystem = new PowerManagementSystem();  
        
    }

    public void SetState(double damageAPresented, double damageBPresented,
            double damageCPresented, double speedLigthDesired) {
        
        starshipEnterprise.setMaxOperatingFlowWithSpeedLigth(speedLigthDesired);
        starshipEnterprise.setDamage(damageAPresented, damageBPresented, damageCPresented);
        powerManagementSystem.EvaluateState(starshipEnterprise);
        
    }

    public String getReportInjectors() {
        
        String report = powerManagementSystem.getReportInjectors(starshipEnterprise);
        return report;
        
    }

    public String getTimeReportInjectors() {
        
        String report = powerManagementSystem.getTimeReportInjectors(starshipEnterprise);
        return report;
        
    }

}
