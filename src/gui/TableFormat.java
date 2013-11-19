package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class TableFormat {

	
	public static void formatTable(int[] columnsWidth, JTable table){
		
		//set table columns width
		//int[] columnsWidth = { 0, 180, 45, 80 };//columns size
		
        int i = 0;
        for (int width : columnsWidth) {
            TableColumn column = table.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
        
        //table look
        table.setShowGrid(false);//hide table grid
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(new Color(100, 149, 237));
        table.setSelectionForeground(new Color(255, 255, 255));
        table.setForeground(new Color(0, 0, 128));
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.getTableHeader().setBackground(new Color(255, 255, 255));
        table.getTableHeader().setBorder(null);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        table.getTableHeader().setForeground(new Color(25, 25, 112));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
				
		
	}
}
