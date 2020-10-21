/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import database.DatabaseBroker;
import domain.DomainObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luka
 */
public abstract class SystemOperation {
   
    DatabaseBroker dbbr;
    DomainObject odo;

    public SystemOperation() {
        dbbr=new DatabaseBroker();
    }
    
    protected void connectStorage() throws Exception{
        dbbr.connect();
    }
    
    protected void disconnectStorage() throws Exception{
        dbbr.disconnect();
    }
    
    protected abstract void operation()throws Exception;
    
    public void execute() throws Exception{
        connectStorage();
        try {
            operation();
            dbbr.commit();
        } catch (Exception ex) {
            dbbr.rollback();
            throw ex;
        }finally{
            disconnectStorage();
        }
    }

    public DomainObject getDomainObject() {
        return odo;
    }
    
    
    
}
