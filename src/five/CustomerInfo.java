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
    private final String NAME;
    private final String ADDRESSLINE1;
    private final String CITY;
    private final String STATE;
    private final String EMAIL;
    private final Integer CREDIT_LIMIT;

    public CustomerInfo(Integer CUSTOMER_ID, String DISCOUNT_CODE, Integer ZIP, String NAME, String ADDRESSLINE1, String CITY, String STATE, String EMAIL, Integer CREDIT_LIMIT) {
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.DISCOUNT_CODE = DISCOUNT_CODE;
        this.ZIP = ZIP;
        this.NAME = NAME;
        this.ADDRESSLINE1 = ADDRESSLINE1;
        this.CITY = CITY;
        this.STATE = STATE;
        this.EMAIL = EMAIL;
        this.CREDIT_LIMIT = CREDIT_LIMIT;
    }

    public Integer getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public String getDISCOUNT_CODE() {
        return DISCOUNT_CODE;
    }

    public Integer getZIP() {
        return ZIP;
    }

    public String getNAME() {
        return NAME;
    }

    public String getADDRESSLINE1() {
        return ADDRESSLINE1;
    }

    public String getCITY() {
        return CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public Integer getCREDIT_LIMIT() {
        return CREDIT_LIMIT;
    }

    @Override
    public String toString() {
        return NAME;
    }
     
    
    
}
