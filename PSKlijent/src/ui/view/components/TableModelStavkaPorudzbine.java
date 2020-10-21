/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.view.components;

import domain.Porudzbina;
import domain.StavkaPorudzbine;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luka
 */
public class TableModelStavkaPorudzbine extends AbstractTableModel{
    
    boolean editable;
    private Porudzbina porudzbina;
    String[] columnNames=new String[]{"ID", "Naziv", "Cena", "PorudzbinaID"};
    
    public TableModelStavkaPorudzbine(Porudzbina porudzbina){
        this.porudzbina = porudzbina;
    }
    
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    @Override
    public int getRowCount() {
        return porudzbina.getStavkePorudzbine().size();
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
    public boolean isCellEditable(int x, int y) {
        if(!editable){
            return false;
        }
        return y==1 || y==2 || y==3 || y==4 || y==5;
    }

    @Override
    public Object getValueAt(int x, int y) {
        StavkaPorudzbine stavka = porudzbina.getStavkePorudzbine().get(x);
        switch(y){
            case 0: return stavka.getStavkaPorudzbineID();
            case 1: return stavka.getStavkaPorudzbineNaziv();
            case 2: return stavka.getCena();
            case 3: return porudzbina.getId();
            default: return "n/a";
        }
    }
    
//    public void insertPorudzbina(Porudzbina p){
//        porudzbine.add(p);
//    }
    
//    public void removeOrder(int x){
//        porudzbine.remove(x);
//        fireTableDataChanged();
//    }
//    
//    public Porudzbina getPorudzbinatAt(int rowIndex){
//        return porudzbine.get(rowIndex);
//    }
    
}
