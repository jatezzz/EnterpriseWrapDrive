package enterprise.warp.drive.management.v020;

public class StarshipEnterprise {

    private PlasmaInjector[] injectors;

    private double maxOperatingFlow;

    private int countInjectorsEnabled;

    private int actualOperatingFlow;

    private boolean shipEnergized;

    private double speratingTime;

    public StarshipEnterprise() {

        injectors = new PlasmaInjector[3];

        for (int i = 0; i < 3; i++) {
            injectors[i] = new PlasmaInjector();
        }
        shipEnergized = true;
        setMaxOperatingFlowWithSpeedLigth(100);
        
    }

    void setDamage(double damageADesired, double damageBDesired, double damageCDesired) {
        
        injectors[0].setDamage(damageADesired);
        injectors[1].setDamage(damageBDesired);
        injectors[2].setDamage(damageCDesired);
        
    }

    void setMaxOperatingFlowWithSpeedLigth(double speedLigth) {
        
        maxOperatingFlow = speedLigth * 3;
        double individualOperationFlow = maxOperatingFlow / 3;
        for (PlasmaInjector injector : injectors) {
            injector.setOperatingFlow(individualOperationFlow);
        }
        
    }

    void setExtraIndividualFlow(double individualAdjust) {
        
        for (PlasmaInjector injector : injectors) {
            if (injector.getEnableInjector()) {
                injector.setExtraFlow(individualAdjust);
            }
        }
        
    }

    int getInjectorsEnabled() {
        
        evaluateState();
        return countInjectorsEnabled;
        
    }

    double getActualOperatingFlow() {
        
        evaluateState();
        return actualOperatingFlow;
        
    }

    private void evaluateState() {
        
        countInjectorsEnabled = 0;
        actualOperatingFlow = 0;
        for (PlasmaInjector injector : injectors) {
            if (injector.getEnableInjector()) {
                countInjectorsEnabled++;
                actualOperatingFlow += injector.getOperatingFlow();
            }
        }
        
    }

    double[] getInjectorsOperatingTime() {
        
        double result[] = new double[3];
        for (int i = 0; i < injectors.length; i++) {
            result[i] = injectors[i].getOperationTime();
        }
        return result;
        
    }

    double[] getInjectorsOperatingFlow() {
        
        double result[] = new double[3];
        for (int i = 0; i < injectors.length; i++) {
            result[i] = injectors[i].getOperatingFlow();
        }
        return result;
        
    }

    double getMaxOperatingFlow() {
        
        return maxOperatingFlow;
        
    }

    void setSperatingTime(double speratingTimeDesired) {
        
        speratingTime = speratingTimeDesired;
        
    }

    double getSperatingTime() {
        
        return speratingTime;
        
    }
    
    public boolean isShipEnergized() {
        
        return shipEnergized;
        
    }

    public void setShipEnergized(boolean shipEnergized) {
        
        this.shipEnergized = shipEnergized;
        
    }

}
