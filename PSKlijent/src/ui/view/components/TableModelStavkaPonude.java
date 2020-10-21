/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.view.components;

import controller.CommunicationController;
import domain.Artikl;
import domain.Ponuda;
import domain.StavkaPonude;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luka
 */
public class TableModelStavkaPonude extends AbstractTableModel{

    private boolean editable;
    private Ponuda ponuda;
    String[] columnNames = {"Id", "Naziv", "Artikl", "Cena", "Ponuda ID"};
    
    
    public TableModelStavkaPonude(Ponuda ponuda){
        this.ponuda = ponuda;
    }
    
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    @Override
    public boolean isCellEditable(int x, int y) {
        if(!editable){
            return false;
        }
        return y==1 || y==2 || y==3 || y==4 || y==5;
    }
    
    @Override
    public int getRowCount() {
        return ponuda.getStavkePonude().size();
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
        StavkaPonude item = ponuda.getStavkePonude().get(x);
        switch(y){
            case 0:
                return item.getStavkaPonudeID();
            case 1:
                return item.getStavkaPonudeNaziv();
            case 2:
                return item.getArtikl().getArtiklNaziv();
            case 3:
                return item.getCena();
            case 4:
                return ponuda.getPonudaID();
            default:
                return "n/a";
        }
    }
    
    public void removeOfferItem(int rowIndex){
        ponuda.getStavkePonude().remove(rowIndex);
        fireTableDataChanged();
    }
    
    public void addOfferItem(Artikl artikl, String naziv, double cena) throws Exception {
        StavkaPonude stavka = new StavkaPonude();
        stavka.setArtikl(artikl);
        stavka.setCena(cena);
        stavka.setStavkaPonudeNaziv(naziv);
        stavka.setPonuda(ponuda);
        ponuda.getStavkePonude().add(stavka);
        StavkaPonude s = CommunicationController.getInstance().saveOfferItem(stavka);
        stavka.setStavkaPonudeID(s.getStavkaPonudeID());
        fireTableDataChanged();
    }
    
//    public void addOfferItemNew(Artikl artikl, String naziv, double cena) throws Exception {
//        StavkaPonude stavka = new StavkaPonude();
//        stavka.setArtikl(artikl);
//        stavka.setCena(cena);
//        stavka.setStavkaPonudeNaziv(naziv);
//        stavka.setPonuda(ponuda);
//        ponuda.getStavkePonude().add(stavka);
//        stavka.setStavkaPonudeID(stavka.getStavkaPonudeID());
//        fireTableDataChanged();
//    }
    
    public void addOfferItemNew(StavkaPonude stavka) throws Exception {
        stavka.setStavkaPonudeID(stavka.getStavkaPonudeID());
        ponuda.getStavkePonude().add(stavka);
        fireTableDataChanged();
    }
    
    public Ponuda getPonuda(){
        return ponuda;
    }
    
    public StavkaPonude getStavkaPonudeAt(int x){
        return ponuda.getStavkePonude().get(x);
    }
    
}
