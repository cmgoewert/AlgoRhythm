/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorhythm;

import java.util.ArrayList;
import javax.swing.table.*;

/**
 *
 * @author cmg5831
 */
public class MediaTableModel extends AbstractTableModel{
    
    private static String[] columnNames={"Genre","Title","Artist","Year","Link"};;
    private ArrayList<Song> mediaTableData;
    
    public MediaTableModel(ArrayList<Song> theMediaTableData){
        this.mediaTableData = theMediaTableData;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public int getRowCount(){
       return mediaTableData.size();

    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col){
        Object objectToReturn = new Object();
        switch(col){
            case 0: objectToReturn = mediaTableData.get(row).getGenre();break;
            case 1: objectToReturn = mediaTableData.get(row).getTitle();break;
            case 2: objectToReturn = mediaTableData.get(row).getArtist();break;
            case 3: objectToReturn = mediaTableData.get(row).getYear();break;
            case 4: objectToReturn = mediaTableData.get(row).getURL();break;
        }
        return objectToReturn;
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    
    
   // public boolean isCellEditable
}
