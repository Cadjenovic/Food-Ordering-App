/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.DomainObject;
import domain.Korisnik;
import java.util.List;

/**
 *
 * @author Luka
 */
public class SOSelectRestorane extends SystemOperation{

    public List<DomainObject> restorani;
    
    public SOSelectRestorane(Korisnik k){
        super();
        odo = k;
    }
    
    @Override
    protected void operation() throws Exception {
        restorani = dbbr.getAllWithCondition(odo);
    }
    
    public List<DomainObject> getRestorani(){
        return restorani;
    }
    
}
