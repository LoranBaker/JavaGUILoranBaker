
package six;

import five.*;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class CustomerInfoPanel extends JPanel implements TableModelListener{
    
    private CustomerInfoDao customerDao;
    private JCheckBox rowCheckBox;
    private JCheckBox columnCheckBox;
    private ButtonGroup buttonGroup;
    private JTextArea outputTextArea;


    public CustomerInfoPanel(CustomerInfoDao cid) throws SQLException{
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.customerDao = cid;
        //tabela sa scroll pane
        OurTableModel tableModel = new OurTableModel(cid.getColumnNames(), getAll());
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        
        add(new JLabel("Selection Mode"));
        rowCheckBox = new JCheckBox("Row selection");
        add(rowCheckBox);
        columnCheckBox = new JCheckBox("Column Selection");
        add(columnCheckBox);
        add(new JLabel("Selection Options"));
        JRadioButton singleRadioButton = new JRadioButton("Single selection");
        JRadioButton multipleRadioButton = new JRadioButton("Multiple selection");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(singleRadioButton);
        buttonGroup.add(multipleRadioButton);
        add(singleRadioButton);
        add(multipleRadioButton);
        outputTextArea = new JTextArea(5, 40);
        add(new JScrollPane(outputTextArea));
    
    }
    
    private Vector<Vector<Object>> getAll() throws SQLException {
        Vector<Vector<Object>> data = new Vector<>();
        for (CustomerInfo customerInfo : customerDao.getAll()) {
            Vector<Object> vectorRow = new Vector<>();
            vectorRow.addElement(customerInfo.getCUSTOMER_ID());
            vectorRow.addElement(customerInfo.getNAME());
            vectorRow.addElement(customerInfo.getADDRESSLINE1());
            vectorRow.addElement(customerInfo.getCITY());
            vectorRow.addElement(customerInfo.getSTATE());
            vectorRow.addElement(customerInfo.getZIP());
            vectorRow.addElement(customerInfo.getCREDIT_LIMIT());
            data.addElement(vectorRow);
        }
        return data;
    }
    
     @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel tableModel = (TableModel) e.getSource();
        String columnName = tableModel.getColumnName(column);
        Object data = tableModel.getValueAt(row, column);
        System.out.println("Ime kolone: " + columnName);
        System.out.println(data + " <- podatak koji se promijenio");
    }
    
    private class OurTableModel extends AbstractTableModel {
        
        private final Vector<String> columnNames;
        private final Vector<Vector<Object>> data;

        public OurTableModel(Vector<String> columnNames, Vector<Vector<Object>> data) {
            this.columnNames = columnNames;
            this.data = data;
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
        public Object getValueAt(int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            Object object = rowVector.get(columnIndex);
            return object;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class<?> clazz = getValueAt(0, columnIndex).getClass();
            System.out.println(clazz.getName());
            return getValueAt(0, columnIndex).getClass(); //To change body of generated methods, choose Tools | Templates.
            }
        
         @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            rowVector.remove(columnIndex);
            rowVector.add(columnIndex, aValue);
        }

    }
    
    
    
}
