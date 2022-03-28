package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class SalesForceAccountModel {
    private String accountName;
    private String phone;
    private String fax;
    private String annualRevenue;
    private String type;
    private String website;
    private String industry;
    private String employees;
    private String description;
    private String billingStreet;
    private String shoppingStreet;
    private String billingCity;
    private String billingState;
    private String shippingCity;
    private String shippingState;
    private String billingPostalCode;
    private String billingCountry;
    private String shippingZipCode;
    private String shippingCountry;
}
