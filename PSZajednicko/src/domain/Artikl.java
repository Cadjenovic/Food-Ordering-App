/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luka
 */
public class Artikl implements Serializable, DomainObject{
    
    private int artiklID;
    private String artiklNaziv;
    private double ariklCena;


    public Artikl() {
    }

    public Artikl(int artiklID, String artiklNaziv, double ariklCena) {
        this.artiklID = artiklID;
        this.artiklNaziv = artiklNaziv;
        this.ariklCena = ariklCena;

    }

    public int getArtiklID() {
        return artiklID;
    }

    public void setArtiklID(int artiklID) {
        this.artiklID = artiklID;
    }

    public String getArtiklNaziv() {
        return artiklNaziv;
    }

    public void setArtiklNaziv(String artiklNaziv) {
        this.artiklNaziv = artiklNaziv;
    }

    public double getAriklCena() {
        return ariklCena;
    }

    public void setAriklCena(double ariklCena) {
        this.ariklCena = ariklCena;
    }

    @Override
    public String getTableName() {
        return "artikl";
    }

    @Override
    public String getAttributeNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAttributeValuesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getId(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) {
        List<DomainObject> artikli = new ArrayList<DomainObject>();
        try{
            while(rs.next()){
                Artikl a = new Artikl();
                a.setArtiklID(rs.getInt("artiklid"));
                a.setArtiklNaziv(rs.getString("artiklnaziv"));
                a.setAriklCena(rs.getDouble("artiklcena"));
                artikli.add(a);
            }
        }catch(Exception e){
            
        }
        return artikli;
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
