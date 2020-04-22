/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package five;

/**
 *
 * @author PC
 */
public class CustomerInfo {
    private final Integer CUSTOMER_ID;
    private final String DISCOUNT_CODE;
    private final Integer ZIP;
    private String NAME;
    private String ADDRESSLINE1;
    private String ADDRESSLINE2;
    private String CITY;
    private String STATE;
    private Integer FAX;
    private String EMAIL;
    private Integer CREDIT_LIMIT;

    public CustomerInfo(Integer CUSTOMER_ID, String DISCOUNT_CODE, Integer ZIP, String NAME, String ADDRESSLINE1, String ADDRESSLINE2, String CITY, String STATE, Integer FAX, String EMAIL, Integer CREDIT_LIMIT) {
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.DISCOUNT_CODE = DISCOUNT_CODE;
        this.ZIP = ZIP;
        this.NAME = NAME;
        this.ADDRESSLINE1 = ADDRESSLINE1;
        this.ADDRESSLINE2 = ADDRESSLINE2;
        this.CITY = CITY;
        this.STATE = STATE;
        this.FAX = FAX;
        this.EMAIL = EMAIL;
        this.CREDIT_LIMIT = CREDIT_LIMIT;
    }
    
    
}
