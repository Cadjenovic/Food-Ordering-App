/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.view.components;

import domain.Ponuda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luka
 */
public class TableModelPonuda extends AbstractTableModel{

    boolean editable;
    List<Ponuda> ponude;
    String[] columnNames=new String[]{"ID", "Naziv", "Cena", "Korisnik"};
    
    public TableModelPonuda(List<Ponuda> ponude){
        this.ponude = ponude;
    }
    
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    @Override
    public int getRowCount() {
        return ponude.size();
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
        Ponuda ponuda = ponude.get(x);
        switch(y){
            case 0: return ponuda.getPonudaID();
            case 1: return ponuda.getPonudaNaziv();
            case 2: return ponuda.getPonudaCena();
            case 3: return ponuda.getKorisnikID().getNazivKorisnika();
            default: return "n/a";
        }
    }
    
    public void insertPonuda(Ponuda p){
        ponude.add(p);
    }
    
    public void removeOffer(int x){
        ponude.remove(x);
        fireTableDataChanged();
    }
    
//    @Override
//    public void setValueAt(Object value, int x, int y) {
//        Ponuda ponuda = ponude.get(x);
//        switch(y){
//            case 0: ponuda.setPonudaID(new Integer(value.toString())); break;
//            case 1: ponuda.setPonudaNaziv(value.toString());
//            case 2: ponuda.setKorisnikID(new Integer(value.toString())); break;
//
//        }
//    }
    
    public Ponuda getPonudatAt(int rowIndex){
        return ponude.get(rowIndex);
    }
    
}
