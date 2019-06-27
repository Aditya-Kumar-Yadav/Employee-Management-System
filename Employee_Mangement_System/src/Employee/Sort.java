package Employee;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Sort
{
    static JLabel titleLbl;
    static JTable firstTable, secondTable, thirdTable;
    static JPanel sort()
    {
        //rightPanel is the DISPLAY_PANEL that have to be returned to the MainPage. 
            //DISPLAY_PANEL setup
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(255, 255, 153));
        rightPanel.setBounds(200, 40, 600, 460);

            //TITLE_LABEL setup
        titleLbl = new JLabel("All Employees");
        titleLbl.setBounds(200, 0,200, 30);
        titleLbl.setFont(new Font(null, Font.BOLD, 18));
        
		      //3 DISPLAY is going to be created so we need all 3 tables COLUMN_NAME.
				//FIRST_DISPLAY_COLUMN_NAME
		String[] first = {"EmpId", "FirstName", "LastName", "Father", "Gender", "Nationality"};
				//SECOND_DISPLAY_COLUMN_NAME
		String[] second = {"Birth-Date", "Mobie No.", "Qualification", "Department", "Join-Date"};
				//THIRD_DISPLAY_COLUMN_NAME
		String[] third = {"Address-Id", "Room-No", "Area", "City", "Pincode", "State"};
		
					//FIRST_DISPLAY
			//DEFAULT_TABLE_MODEL create to make a TABLE_FORMATTED_DISPLAY
		DefaultTableModel firstTableModel = new DefaultTableModel();
			//all COLUMN_NAMES are set by using SET_COLUMN_IDENTIFIERS_METHOD
		firstTableModel.setColumnIdentifiers(first);
			//now we INITILIZE our display with TABLE_FORMATTED_DISPLAY
		firstTable = new JTable(firstTableModel);
			//we need JSCROLLPANE if data is more than the TABLE_SIZE
			//so JSCROLLPANE is created and INTIALIZED with our DISPLAY
		JScrollPane firstShowTable = new JScrollPane(firstTable);
			//SETBOUNDS is used to set the CO-ORDINATES and SIZE of DISPLAY
		firstShowTable.setBounds(10, 90, 570, 100);
		
					//SECOND_DISPLAY
			//DEFAULT_TABLE_MODEL create to make a TABLE_FORMATTED_DISPLAY
		DefaultTableModel secondTableModel = new DefaultTableModel();
			//all COLUMN_NAMES are set by using SET_COLUMN_IDENTIFIERS_METHOD
		secondTableModel.setColumnIdentifiers(second);
			//now we INITILIZE our display with TABLE_FORMATTED_DISPLAY
		secondTable = new JTable(secondTableModel);
			//we need JSCROLLPANE if data is more than the TABLE_SIZE
			//so JSCROLLPANE is created and INTIALIZED with our DISPLAY
		JScrollPane secondShowTable = new JScrollPane(secondTable);
			//SETBOUNDS is used to set the CO-ORDINATES and SIZE of DISPLAY
		secondShowTable.setBounds(10, 200, 570, 100);
		
					//THIRD_DISPLAY
			//DEFAULT_TABLE_MODEL create to make a TABLE_FORMATTED_DISPLAY
		DefaultTableModel thirdTableModel = new DefaultTableModel();
			//all COLUMN_NAMES are set by using SET_COLUMN_IDENTIFIERS_METHOD
		thirdTableModel.setColumnIdentifiers(third);
			//now we INITILIZE our display with TABLE_FORMATTED_DISPLAY
		thirdTable = new JTable(thirdTableModel);
			//we need JSCROLLPANE if data is more than the TABLE_SIZE
			//so JSCROLLPANE is created and INTIALIZED with our DISPLAY
		JScrollPane thirdShowTable = new JScrollPane(thirdTable);
			//SETBOUNDS is used to set the CO-ORDINATES and SIZE of DISPLAY
		thirdShowTable.setBounds(10, 310, 570, 100);

            //Adding COMPONENTS to the DISPLAY_PANEL
        rightPanel.add(titleLbl);
        rightPanel.add(firstShowTable);
        rightPanel.add(secondShowTable);
        rightPanel.add(thirdShowTable);
        
            //RETURNING the completed DISPLAY_PANEL
        return rightPanel;
    }
}
