package com.example.tax;

public class PropertyTax implements Tax {

    double taxableAmount;
    double taxAmount;
    boolean isTaxPayed;

    public PropertyTax() {
        this.isTaxPayed = false;
    }

    @Override
    public void setTaxableAmount(int amount) {
        this.taxableAmount = amount;
    }

    @Override
    public void calculateTaxAmount() {
        this.taxAmount = 0.05d * this.taxableAmount;
    }

    @Override
    public double getTaxAmount() {
        return this.taxAmount;
    }

    @Override
    public String getTaxType() {
        return "property";
    }

    @Override
    public boolean isTaxPayed() {
        return this.isTaxPayed;
    }

    @Override
    public void payTax() {
        if (this.isTaxPayed == false) {
            System.out.println("Your Payment for property tax Rs." + this.taxAmount + " is successfully processed.");
            this.isTaxPayed = true;
        }

    }
    /*
     * 1. Create the following attributes.
     * a. taxableAmount (double)
     * b. taxAmount (double)
     * c. isTaxPayed (boolean)
     * 2. Make this class an implementation of Tax interface and override the
     * interface methods.
     * 3. Using constructor initialize the isTaxPayed boolean false.
     */
}
