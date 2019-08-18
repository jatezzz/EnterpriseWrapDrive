package enterprise.warp.drive.management.v020;

public class PowerManagementSystem {
    
    private final int topSperatingTime=100;

    public PowerManagementSystem() {
    }

    void EvaluateState(StarshipEnterprise starshipEnterprise) {
        
        MaximeOperatingTime(starshipEnterprise);
        CalculateOperatingTime(starshipEnterprise);
        
    }

    private void MaximeOperatingTime(StarshipEnterprise starshipEnterprise) {
        
        int countInjectorsEnabled = starshipEnterprise.getInjectorsEnabled();
        double actualOperatingTime = starshipEnterprise.getActualOperatingFlow();
        if (countInjectorsEnabled == 0) {
            starshipEnterprise.setShipEnergized(false);
        }
        double deltaFlow = starshipEnterprise.getMaxOperatingFlow() - actualOperatingTime;
        double individualAdjust = deltaFlow / countInjectorsEnabled;
        starshipEnterprise.setExtraIndividualFlow(individualAdjust);

    }

    private void CalculateOperatingTime(StarshipEnterprise starshipEnterprise) {
        
        double speratingTime = topSperatingTime;
        double [] injectorsOperatingTime = starshipEnterprise.getInjectorsOperatingTime();
        for (int i = 0; i < injectorsOperatingTime.length; i++) {
            if (injectorsOperatingTime[i] <= 0) {
                speratingTime = 0;
                break;
            }
        }
        if (speratingTime != 0) {
            double minTimeInjector = injectorsOperatingTime[0];
            for (int i = 1; i < injectorsOperatingTime.length; i++) {
                if (minTimeInjector > injectorsOperatingTime[i]) {
                    minTimeInjector = injectorsOperatingTime[i];
                }
            }
            speratingTime = minTimeInjector;
        }
        if (speratingTime <= 0) {
            speratingTime = 0;
            starshipEnterprise.setShipEnergized(false);
        }
        starshipEnterprise.setSperatingTime(speratingTime);

    }

    String getReportInjectors(StarshipEnterprise starshipEnterprise) {
        
        String report;
        double [] injectorsOperatingFlow = starshipEnterprise.getInjectorsOperatingFlow();
        
        if (!starshipEnterprise.isShipEnergized()) {
            report = "Unable to comply";
        } else {
            report = "A: " + (int) injectorsOperatingFlow[0] + " mg/s, "
                    + "B: " + (int) injectorsOperatingFlow[1] + " mg/s, "
                    + "C: " + (int) injectorsOperatingFlow[2] + " mg/s";
        }
        return report;
        
    }

    String getTimeReportInjectors(StarshipEnterprise starshipEnterprise) {
        
        String report;
        int speratingTime= (int) starshipEnterprise.getSperatingTime();
        if (speratingTime == topSperatingTime) {
            report = "Infinite";
        } else {
            report = String.valueOf(speratingTime) + " min";
        }
        return report;
        
    }

}
