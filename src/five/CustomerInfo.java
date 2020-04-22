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
    private final String ADDRESSLINE2;
    private final String CITY;
    private final String STATE;
    private final Integer FAX;
    private final String EMAIL;
    private final Integer CREDIT_LIMIT;

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

    public String getADDRESSLINE2() {
        return ADDRESSLINE2;
    }

    public String getCITY() {
        return CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public Integer getFAX() {
        return FAX;
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
