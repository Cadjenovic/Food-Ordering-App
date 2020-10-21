/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Luka
 */
public class StavkaPonude implements Serializable, DomainObject{
    
    private Ponuda ponuda;
    private int stavkaPonudeID;
    private String stavkaPonudeNaziv;
    private Artikl artikl;
    private double cena;
    
    public StavkaPonude() {
    }

    public StavkaPonude(Ponuda ponuda, int stavkaPonudeID, String stavkaPonudeNaziv, Artikl artikl, double cena) {
        this.ponuda = ponuda;
        this.stavkaPonudeID = stavkaPonudeID;
        this.stavkaPonudeNaziv = stavkaPonudeNaziv;
        this.artikl = artikl;
        this.cena = cena;
    }

    public Ponuda getPonuda() {
        return ponuda;
    }

    public void setPonuda(Ponuda ponuda) {
        this.ponuda = ponuda;
    }

    public int getStavkaPonudeID() {
        return stavkaPonudeID;
    }

    public void setStavkaPonudeID(int stavkaPonudeID) {
        this.stavkaPonudeID = stavkaPonudeID;
    }

    public String getStavkaPonudeNaziv() {
        return stavkaPonudeNaziv;
    }

    public void setStavkaPonudeNaziv(String stavkaPonudeNaziv) {
        this.stavkaPonudeNaziv = stavkaPonudeNaziv;
    }
    
    public void setArtikl(Artikl artikl){
        this.artikl = artikl;
    }
    
    public Artikl getArtikl(){
        return artikl;
    }
    
    public void setCena(double cena){
        this.cena = cena;
    }
    
    public double getCena(){
        return cena;
    }

    @Override
    public String getTableName() {
        return "StavkaPonude";
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "stavkaponudenaziv, ponudaid, artiklid, cena";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + stavkaPonudeNaziv + "', '" + ponuda.getPonudaID() + "', '" + artikl.getArtiklID() + "', " + cena;
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(int id) {
        setStavkaPonudeID(id);
    }
    
    @Override
    public int getId(){
        return getStavkaPonudeID();
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereConditionOne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DomainObject getOne(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereConditionAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
