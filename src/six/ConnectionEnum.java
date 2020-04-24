/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package six;

public enum ConnectionEnum {

    URL("jdbc:derby://localhost:1527/CustomerInfo"),
    USERNAME("root"),
    PASSWORD("root");
    
    private String value;
    
    private ConnectionEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    
}
