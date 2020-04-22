
package five;

import java.sql.SQLException;
import java.util.Vector;
import java.util.stream.Collectors;
import javax.swing.JPanel;

public class CustomerInfoPanel extends JPanel{
    
    private final CustomerInfoDao customerDao;

    public CustomerInfoPanel(CustomerInfoDao cid) {
        this.customerDao = cid;
    }
    
    private Vector<CustomerInfo> getAll() throws SQLException{
        return customerDao.getAll().stream().collect(Collectors.toCollection(Vector::new));
        
        
    }
    
    
    
}
