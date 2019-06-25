package Employee;

import java.awt.*;
import javax.swing.*;

class Delete
{
    static JLabel titleLbl;
    static JPanel delete()
    {
        //rightPanel is the DISPLAY_PANEL that have to be returned to the MainPage. 
            //DISPLAY_PANEL setup
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(255, 255, 153));
        rightPanel.setBounds(200, 40, 600, 460);

            //TITLE_LABEL setup
        titleLbl = new JLabel("Delete Employee");
        titleLbl.setBounds(200, 0,200, 30);
        titleLbl.setFont(new Font(null, Font.BOLD, 18));

            //Adding COMPONENTS to the DISPLAY_PANEL
        rightPanel.add(titleLbl);
        
            //RETURNING the completed DISPLAY_PANEL
        return rightPanel;
    }
}
