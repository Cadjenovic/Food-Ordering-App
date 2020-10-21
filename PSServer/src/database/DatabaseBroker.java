/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.DomainObject;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luka
 */
public class DatabaseBroker {
    Connection connection;
    private String driver;
    private String url;
    private String user;
    private String password;
    public void connect() throws Exception{
        try {
//            FileInputStream in=new FileInputStream("db.properties");
//            Properties props=new Properties();
//            props.load(in);
//            String driver=props.getProperty("driver");
//            String url=props.getProperty("url");
//            String user=props.getProperty("user");
//            String password=props.getProperty("password");
            
            driver="com.mysql.jdbc.Driver";
            url="jdbc:mysql://localhost:3306/psprojekat";
            user="root";
            password="";
            Class.forName(driver);
            
            connection=DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom uspostavljanja konekcije sa bazom!\n" + ex.getMessage());
        }
    }
    
    public void disconnect() throws Exception {
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            throw new Exception("Greska prilikom raskidanja konekcije sa bazom!\n" + ex.getMessage());
            }
        }
    }
    
    public void commit() throws Exception{
        if(connection!=null){
            try {
                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            throw new Exception("Greska prilikom potvrdjivanja transakcije!\n"+ex.getMessage());
            }
        }
    }
    
    public void rollback() throws Exception{
        if(connection!=null){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            throw new Exception("Greska prilikom ponistavanja transakcije!\n"+ex.getMessage());
            }
        }
    }
    
    public DomainObject insert(DomainObject odo) throws Exception{
        try {
            String upit="INSERT INTO "+odo.getTableName()+" ("+odo.getAttributeNamesForInsert()+") VALUES ("+odo.getAttributeValuesForInsert()+")";
            System.out.println(upit);
            Statement statement=connection.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
            
            if(odo.isAutoincrement()){
                ResultSet rs=statement.getGeneratedKeys();
                if(rs.next()){
                    odo.setObjectId(rs.getInt(1));
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja "+odo.getTableName()+" u bazi!\n");
        }
        return odo;
    }
    
    public DomainObject delete(DomainObject odo) throws Exception{
        try{
            String upit = "DELETE FROM " + odo.getTableName() + " WHERE " +odo.getTableName() + "id = " + odo.getId();
            Statement statement=connection.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja "+odo.getTableName()+" u bazi!\n");
        }
        return odo;
    }
    
    public DomainObject update(DomainObject odo) throws Exception{
        try{
            String upit = "UPDATE " + odo.getTableName() + " SET " + odo.getUpdate();
            Statement statement=connection.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom izmene "+odo.getTableName()+" u bazi!\n");
        }
        return odo;
    }
    
    public List<DomainObject> getAll(DomainObject odo) throws Exception{
        try{
            String upit = "SELECT * FROM " + odo.getTableName();
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            List<DomainObject> lista = odo.getList(rs);
            return lista;

        }catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom izmene "+odo.getTableName()+" u bazi!\n");
        }
    }
    
    public DomainObject getOne(DomainObject odo) throws Exception{
        try{
            String upit = "SELECT * FROM " + odo.getTableName() + " WHERE " + odo.getWhereConditionOne();
            System.out.println(upit);
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            odo = odo.getOne(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return odo;
    }
    
    public List<DomainObject> getAllWithCondition(DomainObject odo) throws Exception{
        try{
            String upit = "SELECT * FROM " + odo.getTableName() + " WHERE " + odo.getWhereConditionAll();
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            List<DomainObject> lista = odo.getList(rs);
            return lista;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getLocalizedMessage()+"Greska prilikom izmene "+odo.getTableName()+" u bazi!\n");
        }
    }
    
    public List<DomainObject> getAllWithJoinCondition(DomainObject odo1, DomainObject odo2) throws Exception{
        try{
            String upit = "SELECT * FROM " + odo1.getTableName() + odo1.getJoin() + " WHERE " + odo1.getWhereConditionOne() + odo2.getId();
            System.out.println(upit);
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            List<DomainObject> lista = odo1.getList(rs);
            return lista;
        }catch(Exception e){
            throw new Exception(e.getLocalizedMessage()+"Greska prilikom izmene "+odo1.getTableName()+" u bazi!\n");
        }
    }
    
    public List<DomainObject> getAllWithJoin(DomainObject odo) throws Exception{
        try{
            String upit = "SELECT * FROM " + odo.getTableName() + odo.getJoin();
            System.out.println(upit);
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            List<DomainObject> lista = odo.getList(rs);
            return lista;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getLocalizedMessage()+"Greska prilikom izmene "+odo.getTableName()+" u bazi!\n");
        }
    }
    
}
