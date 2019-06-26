package Employee;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

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
    	Connection connection = conn;
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
        String[] addressTableColumn = {"EmpId", "Department", "Join-Date", "Address-Id", "Room-No", "Area", "City", "Pincode", "State"};
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
        deletedEmployee.setBounds(10, 80, 575, 40);
        
        DefaultTableModel addressTableModel = new DefaultTableModel();
        for(String columnName : addressTableColumn)
        	addressTableModel.addColumn(columnName);
        deleteEmployeeAddressTable = new JTable(addressTableModel);
        TableColumnModel columnModel1 = deleteEmployeeAddressTable.getColumnModel();
        columnModel1.getColumn(0).setMaxWidth(50);
        columnModel1.getColumn(5).setMaxWidth(40);
        columnModel1.getColumn(6).setMaxWidth(50);
        columnModel1.getColumn(7).setMaxWidth(50);
        JScrollPane deletedEmployeeAddress = new JScrollPane(deleteEmployeeAddressTable);
        deletedEmployeeAddress.setBounds(10, 120, 575, 40);
        
        	//ALL_DELETED_EMPLOYEE_TABLE
        allDeletedEmployeeTable = new JTable(tableModel);
        TableColumnModel columnModelAll = allDeletedEmployeeTable.getColumnModel();
        columnModelAll.getColumn(0).setMaxWidth(50);
        columnModelAll.getColumn(3).setMaxWidth(60);
        columnModelAll.getColumn(4).setMaxWidth(50);
        columnModelAll.getColumn(6).setMaxWidth(60);
        columnModelAll.getColumn(7).setMaxWidth(70);
        JScrollPane deleted = new JScrollPane(allDeletedEmployeeTable);
        deleted.setBounds(10, 215, 575, 100);
        
        allDeletedEmployeeAdressTable = new JTable(addressTableModel);
        TableColumnModel columnModelAll1 = allDeletedEmployeeAdressTable.getColumnModel();
        columnModelAll1.getColumn(0).setMaxWidth(50);
        columnModelAll1.getColumn(5).setMaxWidth(50);
        columnModelAll1.getColumn(6).setMaxWidth(50);
        columnModelAll1.getColumn(7).setMaxWidth(50);
        JScrollPane deleted1 = new JScrollPane(allDeletedEmployeeAdressTable);
        deleted1.setBounds(10, 320, 575, 100);
        
        	//ADDING ACTION_LISTENER to the BUTTONS
        searchBtn.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				try
        				{
        					PreparedStatement pst;
        					pst = conn.prepareStatement("select * from Employee, ");
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





