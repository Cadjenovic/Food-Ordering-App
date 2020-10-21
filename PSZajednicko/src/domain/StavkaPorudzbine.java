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
public class StavkaPorudzbine implements Serializable, DomainObject{
    
    private Porudzbina porudzbinaID;
    private int stavkaPorudzbineID;
    private String stavkaPorudzbineNaziv;
    private double cena;

    public StavkaPorudzbine() {
    }

    public StavkaPorudzbine(Porudzbina porudzbinaID, int stavkaPorudzbineID, String stavkaPorudzbineNaziv, double cena) {
        this.porudzbinaID = porudzbinaID;
        this.stavkaPorudzbineID = stavkaPorudzbineID;
        this.stavkaPorudzbineNaziv = stavkaPorudzbineNaziv;
        this.cena = cena;
    }

    public Porudzbina getPorudzbinaID() {
        return porudzbinaID;
    }

    public void setPorudzbinaID(Porudzbina porudzbinaID) {
        this.porudzbinaID = porudzbinaID;
    }

    public int getStavkaPorudzbineID() {
        return stavkaPorudzbineID;
    }

    public void setStavkaPorudzbineID(int stavkaPorudzbineID) {
        this.stavkaPorudzbineID = stavkaPorudzbineID;
    }

    public String getStavkaPorudzbineNaziv() {
        return stavkaPorudzbineNaziv;
    }

    public void setStavkaPorudzbineNaziv(String stavkaPorudzbineNaziv) {
        this.stavkaPorudzbineNaziv = stavkaPorudzbineNaziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    

    @Override
    public String getTableName() {
        return "stavkaporudzbine";
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "stavkaporudzbineid, stavkaporudzbinenaziv, porudzbinaid, cena";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return getStavkaPorudzbineID() + ", '" + getStavkaPorudzbineNaziv() + "', " + getPorudzbinaID().getId() + ", " + getCena();
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(int id) {
        setStavkaPorudzbineID(id);
    }
    
    @Override
    public int getId(){
        return getStavkaPorudzbineID();
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
