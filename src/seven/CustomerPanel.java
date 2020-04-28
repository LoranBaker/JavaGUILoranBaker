/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seven;

import five.CustomerInfo;
import five.CustomerInfoDao;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;


public class CustomerPanel extends JPanel {

    private final CustomerInfoDao customerDao;

    private JTextField addressTextField;
    private TableRowSorter<OurTableModel> tableRowSorter;
    private JTable table;


    public CustomerPanel(CustomerInfoDao customerDao) throws SQLException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.customerDao = customerDao;
        OurTableModel tableModel = new OurTableModel(customerDao.getColumnNames(), getCustomers());
        this.tableRowSorter = new TableRowSorter<>(tableModel);
        JPanel form = new JPanel(new GridLayout(1, 1));
        JLabel addressLabel = new JLabel("Filter by sport:", SwingConstants.TRAILING);
        form.add(addressLabel);
        addressTextField = new JTextField();
        CustomerDocumentListener documentListener = new CustomerDocumentListener(addressTextField , tableRowSorter);
        addressTextField.getDocument().addDocumentListener(documentListener);
        addressLabel.setLabelFor(addressTextField);
        form.add(addressTextField);

        this.table = new JTable(tableModel);
        this.table.setRowSorter(tableRowSorter);
        this.table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        this.table.setFillsViewportHeight(true);
        this.table.getModel().addTableModelListener(new CustomerTableModelListener(customerDao));
        //
        add(form);
        add(new JScrollPane(table));
    
    }

    private Vector<Vector<Object>> getCustomers() throws SQLException {
        Vector<Vector<Object>> dataRows = new Vector<>();
        for (CustomerInfo customerInfo : customerDao.getAll()) {
            Vector<Object> vectorRow = new Vector<>();
            vectorRow.addElement(customerInfo.getCUSTOMER_ID());
            vectorRow.addElement(customerInfo.getDISCOUNT_CODE());
            vectorRow.addElement(customerInfo.getZIP());
            vectorRow.addElement(customerInfo.getNAME());
            vectorRow.addElement(customerInfo.getADDRESSLINE1());
            vectorRow.addElement(customerInfo.getCITY());
            vectorRow.addElement(customerInfo.getSTATE());
            vectorRow.addElement(customerInfo.getEMAIL());
            vectorRow.addElement(customerInfo.getCREDIT_LIMIT());
            dataRows.addElement(vectorRow);
        }
        return dataRows;
    }

    class OurTableModel extends AbstractTableModel {

        private Vector<String> columnNames;
        private Vector<Vector<Object>> data;

        public OurTableModel(Vector<String> columnNames, Vector<Vector<Object>> data) {
            this.columnNames = columnNames;
            this.data = data;
        }
        
        public Vector<Object> getRowData(int rowNumber){
            return data.get(rowNumber);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class<?> clazz = getValueAt(0, columnIndex).getClass();
            System.out.println(clazz);
            return clazz;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            Object object = rowVector.get(columnIndex);
            System.out.println(object);
            return object;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            rowVector.remove(columnIndex);
            rowVector.add(columnIndex, aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
            
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
                customerDao.update(customerInfo);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}