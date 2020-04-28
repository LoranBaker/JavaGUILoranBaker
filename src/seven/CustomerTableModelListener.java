/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seven;
import five.CustomerInfo;
import five.CustomerInfoDao;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class CustomerTableModelListener implements TableModelListener {

    private CustomerInfoDao customerInfoDao;

    public CustomerTableModelListener(CustomerInfoDao customerInfoDao) {
        this.customerInfoDao = customerInfoDao;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        CustomerPanel.OurTableModel tableModel = (CustomerPanel.OurTableModel) e.getSource();
        String columnName = tableModel.getColumnName(column);
        Object data = tableModel.getValueAt(row, column);
        Vector<Object> rowVector = tableModel.getRowData(row);
        int CUSTOMER_ID = (int) rowVector.get(0);
            String DISCOUNT_CODE = (String) rowVector.get(1);
            int ZIP = (int) rowVector.get(2);
            String NAME = (String) rowVector.get(3);
            String ADDRESSLINE1 = (String) rowVector.get(4);
            String CITY = (String) rowVector.get(5);
            String STATE = (String) rowVector.get(6);
            String EMAIL = (String) rowVector.get(7);
            int CREDIT_LIMIT = (int) rowVector.get(8);
            CustomerInfo customerInfo = new CustomerInfo(CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, CITY, STATE, EMAIL, CREDIT_LIMIT);
        try {
            customerInfoDao.update(customerInfo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}