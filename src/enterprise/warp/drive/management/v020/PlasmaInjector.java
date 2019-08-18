package enterprise.warp.drive.management.v020;

public class PlasmaInjector {

    private double operatingFlow;

    private double operationTime;

    private boolean enableInjector;

    private double maxOperatingFlow;

    private double factorLineal;

    public PlasmaInjector() {
        
        setOperatingFlow(100);
        operationTime = 100;
        maxOperatingFlow = 100;
        enableInjector = true;
        
    }

    public void setDamage(double damage) {
        
        maxOperatingFlow = maxOperatingFlow - (damage * maxOperatingFlow) / 100;
        operatingFlow = factorLineal * maxOperatingFlow;
        if (maxOperatingFlow <= 0) {
            operatingFlow = 0;
            maxOperatingFlow = 0;
            enableInjector = false;
        }
        
    }

    public double getOperatingFlow() {
        
        return operatingFlow;
        
    }

    public void setOperatingFlow(double operatingFlowDesired) {
        
        if (operatingFlowDesired > 100) {
            operatingFlowDesired = 100;
        }
        factorLineal = operatingFlowDesired / 100;
        this.operatingFlow = factorLineal * maxOperatingFlow;
        if(operatingFlowDesired<=0){
            enableInjector = false;
        }
        
    }

    public void setExtraFlow(double extraFlow) {
        
        double timeAfectedByFlow;
        if (extraFlow != 0) {
            if (operatingFlow < maxOperatingFlow) {
                timeAfectedByFlow = (extraFlow + operatingFlow) - maxOperatingFlow;
                if (timeAfectedByFlow <= 0) {
                    timeAfectedByFlow = 0;
                }
            } else {
                timeAfectedByFlow = extraFlow;
            }
            if (timeAfectedByFlow > 100) {
                timeAfectedByFlow = 100;
            }
            operatingFlow += extraFlow;
            double timeDamage = timeAfectedByFlow;
            operationTime -= timeDamage;
        }
        
    }

    public double getOperationTime() {
        
        return operationTime;
        
    }

    boolean getEnableInjector() {
        
        return enableInjector;
        
    }

}
