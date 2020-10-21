/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.DomainObject;
import domain.Porudzbina;
import java.util.List;

/**
 *
 * @author Luka
 */
public class SOSelectPorudzbine extends SystemOperation{

    private List<DomainObject> porudzbine;

    public SOSelectPorudzbine(Porudzbina p) {
        odo = p;
    }
    
    @Override
    protected void operation() throws Exception {
        porudzbine = dbbr.getAllWithJoin(odo);
    }
    
    public List<DomainObject> getPorudzbine(){
        return porudzbine;
    }
    
}
