package com.insurance.covermate.Covermate.Impl;

import com.insurance.covermate.Covermate.Entities.Insurance;

public class TermInsurance implements Insurance {
    double insurance=5000d;
    boolean isMarried,hasChidren,isSalaried;


    public void setInsurenceDetails(boolean isSalaried, boolean isMarried, boolean hasChidren) {
        this.isSalaried=isSalaried;
        this.isMarried=isMarried;
        this.hasChidren=hasChidren;

        double multiFactor=1d;
        if(this.isMarried||this.isSalaried){
           multiFactor+=0.5d;
        }
        if(hasChidren){
            multiFactor+=2d;
        }
        this.insurance=insurance*multiFactor;

    }

    @Override
    public double getInsurancePremium() {
        return this.insurance;
    }

    @Override
    public String getInsuranceName() {
        return "Term Insurance";
    }
}
