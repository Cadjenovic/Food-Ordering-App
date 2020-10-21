/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.view.components;

import domain.Ponuda;
import domain.Porudzbina;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luka
 */
public class TableModelPorudzbinaRestoran extends AbstractTableModel{

    boolean editable;
    List<Porudzbina> porudzbine;
    String[] columnNames=new String[]{"ID", "Naziv", "Cena", "Korisnik", "Vreme porucivanja"};
    
    public TableModelPorudzbinaRestoran(List<Porudzbina> porudzbine){
        this.porudzbine = porudzbine;
    }
    
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    @Override
    public int getRowCount() {
        return porudzbine.size();
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
        Porudzbina porudzbina = porudzbine.get(x);
        switch(y){
            case 0: return porudzbina.getPorudzbinaID();
            case 1: return porudzbina.getPorudzbinaNaziv();
            case 2: return porudzbina.getPorudzbinaCena();
            case 3: return porudzbina.getKorisnikC().getNazivKorisnika();
            case 4: return porudzbina.getDatumPorudzbine();
            default: return "n/a";
        }
    }
    
    public void insertPorudzbina(Porudzbina p){
        porudzbine.add(0, p);
    }
    
    public void removeOrder(int x){
        porudzbine.remove(x);
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
    
    public Porudzbina getPorudzbinatAt(int rowIndex){
        return porudzbine.get(rowIndex);
    }
    
}
