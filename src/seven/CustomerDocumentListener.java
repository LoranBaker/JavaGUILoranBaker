/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seven;

import java.util.regex.PatternSyntaxException;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PC
 */
public class CustomerDocumentListener implements DocumentListener {

    static final int COLUMN_TO_FILTER = 3;
    
    private JTextField textField;
    private TableRowSorter<CustomerPanel.OurTableModel> tableRowSorter;

    public CustomerDocumentListener(JTextField textField, TableRowSorter<CustomerPanel.OurTableModel> tableRowSorter) {
        this.textField = textField;
        this.tableRowSorter = tableRowSorter;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        filter();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        filter();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        filter();
    }
    
    private void filter() {
        RowFilter<CustomerPanel.OurTableModel, Object> rowFilter = null;
        try {
            rowFilter = RowFilter.regexFilter(textField.getText(), COLUMN_TO_FILTER);
        } catch (PatternSyntaxException exception) {
            return;
        }
        tableRowSorter.setRowFilter(rowFilter);
    }
    
}
