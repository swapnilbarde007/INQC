package com.example.tax;

public class IncomeTax implements Tax {
    /*
     * 1. Create the following attributes.
     * a. taxableAmount (double)
     * b. taxAmount (double)
     * c. isTaxPayed (boolean)
     * 2. Make this class an implementation of Tax interface and override the
     * interface methods.
     * 3. Using constructor initialize the isTaxPayed boolean false.
     */
    double taxableAmount;
    double taxAmount;
    boolean isTaxPayed;

    public IncomeTax() {
        this.isTaxPayed = false;
    }

    @Override
    public void setTaxableAmount(int amount) {
        this.taxableAmount = amount;
    }

    @Override
    public void calculateTaxAmount() {
        double quo = 0d;
        if (this.taxableAmount >= 0 && this.taxableAmount < 300000d) {
            //
        } else if (this.taxableAmount >= 300000d && this.taxableAmount < 600000d) {
            quo = 0.05d;
        } else if (this.taxableAmount >= 600000d && this.taxableAmount < 900000d) {
            quo = 0.1d;
        } else if (this.taxableAmount >= 900000d && this.taxableAmount < 1200000d) {
            quo = 0.15d;
        } else if (this.taxableAmount >= 1200000d && this.taxableAmount < 1500000d) {
            quo = 0.20d;
        } else if (this.taxableAmount >= 1500000d) {
            quo = 0.30d;
        }
        this.taxAmount = quo * taxableAmount;

    }

    @Override
    public double getTaxAmount() {
        return this.taxAmount;
    }

    @Override
    public String getTaxType() {
        return "income";
    }

    @Override
    public boolean isTaxPayed() {
        return this.isTaxPayed;
    }

    @Override
    public void payTax() {
        if (this.isTaxPayed == false) {
            System.out.println("Your Payment for income tax Rs." + this.taxAmount + " is successfully processed.");
            this.isTaxPayed = true;
        }

    }

}
