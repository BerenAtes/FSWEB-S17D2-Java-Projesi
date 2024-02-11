package com.workintech.S17D2.tax;

import org.springframework.stereotype.Component;

@Component
public class DeveloperTax implements Taxable{
    @Override
    public Double getSimpleTaxRate() {
        return 20d;
    }

    @Override
    public Double getMiddleTaxRate() {
        return 30d;
    }

    @Override
    public Double getUpperTaxRate() {
        return 40d;
    }
}
