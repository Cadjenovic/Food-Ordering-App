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
public class TipKorisnika implements Serializable, DomainObject{
    
    private int TipKorisnikaID;
    private String TipKorisnikaNaziv;

    public TipKorisnika() {
    }
    
    public TipKorisnika(int TipKorisnikaID, String TipKorisnikaNaziv) {
        this.TipKorisnikaID = TipKorisnikaID;
        this.TipKorisnikaNaziv = TipKorisnikaNaziv;
    }

    public int getTipKorisnikaID() {
        return TipKorisnikaID;
    }

    public void setTipKorisnikaID(int TipKorisnikaID) {
        this.TipKorisnikaID = TipKorisnikaID;
    }

    public String getTipKorisnikaNaziv() {
        return TipKorisnikaNaziv;
    }

    public void setTipKorisnikaNaziv(String TipKorisnikaNaziv) {
        this.TipKorisnikaNaziv = TipKorisnikaNaziv;
    }

    @Override
    public String toString() {
        return TipKorisnikaNaziv;
    }

    @Override
    public String getTableName() {
        return "tipkorisnika";
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "tipkorisnikaid, tipkorisnikanaziv";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return getTipKorisnikaID() + ", '" + getTipKorisnikaNaziv() + "'";
    }

    @Override
    public boolean isAutoincrement() {
        return false;
    }

    @Override
    public void setObjectId(int id) {
        this.setTipKorisnikaID(id);
    }
    
    @Override
    public int getId(){
        return getTipKorisnikaID();
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
