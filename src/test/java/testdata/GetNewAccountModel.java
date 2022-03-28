package testdata;
import models.SalesForceAccountModel;
import utilities.GenerateFakeMessage;

public class GetNewAccountModel {
    public static SalesForceAccountModel getAccountWithAllFields() {
        return SalesForceAccountModel
                .builder()
                .accountName(GenerateFakeMessage.getAccountName())
                .phone(GenerateFakeMessage.getPhone())
                .type("Analyst")
                .fax("1233321")
                .website("www.wget.com")
                .industry("Banking")
                .employees("13")
                .annualRevenue("$13.436.456")
                .billingStreet("Red Oak blv")
                .shoppingStreet("West Side 13/45")
                .billingCity("East Falls")
                .billingState("AR")
                .description("this is description")
                .shippingCity("East Brooks")
                .shippingState("NJ")
                .billingPostalCode("07074")
                .billingCountry("USA")
                .shippingZipCode("08435")
                .shippingCountry("USA")
                .build();
    }
}
