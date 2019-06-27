package Employee;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


class Delete
{
    static JLabel titleLbl, empIdLbl;
    static JTextField empIdTxt;
    static JButton searchBtn, deleteBtn, showDeletedRecordBtn;
    static JTable deleteEmployeeTable, deleteEmployeeAddressTable, allDeletedEmployeeTable, allDeletedEmployeeAdressTable;
    
    static JPanel delete(Connection conn)
    {
        //rightPanel is the DISPLAY_PANEL that have to be returned to the MainPage. 
            //DISPLAY_PANEL setup
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(255, 255, 153));
        rightPanel.setBounds(200, 40, 600, 460);

            //TITLE_LABEL setup
        titleLbl = new JLabel("Delete Employee Record");
        titleLbl.setBounds(170, 0,250, 30);
        titleLbl.setFont(new Font(null, Font.BOLD, 18));
        
        	//EMPLOYEE_ID_LABEL
        empIdLbl = new JLabel("Enter Employee Id");
        empIdLbl.setBounds(100, 50, 120, 20);
        
        	//EMPLOYEE_ID_TEXTFIELD
        empIdTxt = new JTextField();
        empIdTxt.setBounds(220, 50, 120, 20);
        
        	//SEARCH_BUTTON
        searchBtn = new JButton("Search");
        searchBtn.setBounds(350, 50, 80, 20);
        
        	//DELETE_BUTTON
        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(500, 160, 80, 20);
        deleteBtn.setForeground(Color.red);
        
        	//SHOW_DELETED_RECORD_BUTTON
        showDeletedRecordBtn = new JButton("Show All Deleted Records");
        showDeletedRecordBtn.setBounds(180, 185, 220, 20);
        
        String[] tableColumn = {"EmpId", "FirstName", "LastName", "Father", "Gender", "Nationality", "Birth-Date", "Mobie No.", "Qualification"};
        String[] addressTableColumn = {"Department", "Join-Date", "Address-Id", "Room-No", "Area", "City", "Pincode", "State"};
        	//DELETE_EMPLOYEE_TABLE
        DefaultTableModel tableModel = new DefaultTableModel();
        for(String columnName : tableColumn)
        	tableModel.addColumn(columnName);
        deleteEmployeeTable = new JTable(tableModel);
        TableColumnModel columnModel = deleteEmployeeTable.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(50);
        columnModel.getColumn(3).setMaxWidth(60);
        columnModel.getColumn(4).setMaxWidth(50);
        columnModel.getColumn(6).setMaxWidth(60);
        columnModel.getColumn(7).setMaxWidth(70);
        JScrollPane deletedEmployee = new JScrollPane(deleteEmployeeTable);
        deletedEmployee.setBounds(10, 80, 570, 40);
        
        DefaultTableModel addressTableModel = new DefaultTableModel();
        for(String columnName : addressTableColumn)
        	addressTableModel.addColumn(columnName);
        deleteEmployeeAddressTable = new JTable(addressTableModel);
        JScrollPane deletedEmployeeAddress = new JScrollPane(deleteEmployeeAddressTable);
        deletedEmployeeAddress.setBounds(10, 120, 570, 40);
        
        	//ALL_DELETED_EMPLOYEE_TABLE
        DefaultTableModel allTableModel = new DefaultTableModel();
        for(String columnName : tableColumn)
        	allTableModel.addColumn(columnName);
        allDeletedEmployeeTable = new JTable(allTableModel);
        TableColumnModel columnModelAll = allDeletedEmployeeTable.getColumnModel();
        columnModelAll.getColumn(0).setMaxWidth(50);
        columnModelAll.getColumn(3).setMaxWidth(60);
        columnModelAll.getColumn(4).setMaxWidth(50);
        columnModelAll.getColumn(6).setMaxWidth(60);
        columnModelAll.getColumn(7).setMaxWidth(70);
        JScrollPane deleted = new JScrollPane(allDeletedEmployeeTable);
        deleted.setBounds(10, 215, 570, 100);
        
        DefaultTableModel allAddressTableModel = new DefaultTableModel();
        for(String columnName : addressTableColumn)
        	allAddressTableModel.addColumn(columnName);
        allDeletedEmployeeAdressTable = new JTable(allAddressTableModel);
        JScrollPane deleted1 = new JScrollPane(allDeletedEmployeeAdressTable);
        deleted1.setBounds(10, 320, 570, 100);
        
        	//ADDING ACTION_LISTENER to the BUTTONS
        searchBtn.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				try
        				{
        					if(tableModel.getRowCount() != 0)
        					{
        						tableModel.removeRow(0);
        						addressTableModel.removeRow(0);
        					}
        						
        					PreparedStatement st = conn.prepareStatement("SELECT EMPLOYEE_TABLE.EMP_ID, EMPLOYEE_TABLE.FIRST_NAME, EMPLOYEE_TABLE.LAST_NAME, EMPLOYEE_TABLE.FATHER_NAME, EMPLOYEE_TABLE.GENDER, EMPLOYEE_TABLE.NATIONALITY, EMPLOYEE_TABLE.DATE_OF_BIRTH, EMPLOYEE_TABLE.MOBILE_NUMBER, EMPLOYEE_TABLE.HIGHEST_QUALIFICATION, EMPLOYEE_TABLE.DEPARTMENT, EMPLOYEE_TABLE.DATE_OF_JOINING, ADDRESS_TABLE.ADD_ID, ADDRESS_TABLE.ROOM_NUMBER, ADDRESS_TABLE.AREA, ADDRESS_TABLE.CITY, ADDRESS_TABLE.PINCODE, ADDRESS_TABLE.STATE FROM EMPLOYEE_TABLE, ADDRESS_TABLE WHERE (EMPLOYEE_TABLE.EMP_ID = ? AND EMPLOYEE_TABLE.EMP_ID = ADDRESS_TABLE.EMP_ID)");
        					st.setString(1, empIdTxt.getText());
        					
        					ResultSet rs = st.executeQuery();
        					
        					Object[] employeeTableData = new Object[9];
        					Object[] employeeAddressTableData = new Object[9];
        					int k = 1;
        					int i = 0;
        					int j = 0;
        					rs.next();
        					while(k <= 17)
        					{
        						if(i < 9)
        						{
        							employeeTableData[i] = rs.getString(k);
        						}
        						else if(j < 8)
        						{
        							employeeAddressTableData[j] = rs.getString(k);
        							j++;	
        						}
        						i++;
        						k++;
        					}
        					
        					tableModel.addRow(employeeTableData);
        					addressTableModel.addRow(employeeAddressTableData);
        					
        					
        				}
        				catch(SQLException sqle)
        				{
        					System.out.println(sqle);
        				}
        			}
        		});
        //deleteBtn.addActionListener();
        //showDeletedRecordBtn.addActionListener();
        
            //Adding COMPONENTS to the DISPLAY_PANEL
        rightPanel.add(titleLbl);
        rightPanel.add(empIdLbl);
        
        rightPanel.add(empIdTxt);
        
        rightPanel.add(deletedEmployee);
        rightPanel.add(deletedEmployeeAddress);
        
        rightPanel.add(searchBtn);
        rightPanel.add(deleteBtn);
        rightPanel.add(showDeletedRecordBtn);
        rightPanel.add(deleted);
        rightPanel.add(deleted1);
        
            //RETURNING the completed DISPLAY_PANEL
        return rightPanel;
    }
}





