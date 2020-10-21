/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.view.components;

import domain.Artikl;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luka
 */
public class TableModelArtikl extends AbstractTableModel{

    private boolean editable;
    private List<Artikl> artikli;
    private String[] columnNames = {"ID", "Naziv", "Cena"};
    
    public TableModelArtikl(List<Artikl> artikli){
        this.artikli = artikli;
    }
    
    @Override
    public int getRowCount() {
        return artikli.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }
    
    @Override
    public Object getValueAt(int x, int y) {
        Artikl artikl = artikli.get(x);
        switch(y){
            case 0: return artikl.getArtiklID();
            case 1: return artikl.getArtiklNaziv();
            case 2: return artikl.getAriklCena();
            default: return "n/a";
        }
    }
    
    public Artikl getArtiklAt(int x){
        return artikli.get(x);
    }
    
}
