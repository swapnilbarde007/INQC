package com.insurance.covermate.Covermate.Impl;

import com.insurance.covermate.Covermate.Entities.Insurance;

public class HealthInsurance implements Insurance {
    double insurance=10000d;
    boolean isSmoker,isDrinker,previousConditions;

    @Override
    public double getInsurancePremium() {
        return this.insurance;
    }


    public void setInsurenceDetails(boolean isSmoker, boolean isDrinker, boolean previousConditions) {
        this.isSmoker=isSmoker;
        this.isDrinker=isDrinker;
        this.previousConditions=previousConditions;

        double multiFactor=1d;
        if(this.isSmoker||this.isDrinker){
            multiFactor+=0.5d;
        }
        if(previousConditions){
            multiFactor+=2d;
        }
        this.insurance=insurance*multiFactor;
    }

    @Override
    public String getInsuranceName() {
        return "Health Insurance";
    }
}
