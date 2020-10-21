/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Artikl;
import domain.DomainObject;
import java.util.List;

/**
 *
 * @author Luka
 */
public class SOSelectArtikle extends SystemOperation{

    private List<DomainObject> artikli;
    
    public SOSelectArtikle(Artikl artikl) throws Exception{
        super();
        odo = artikl;
    }

    
    
    @Override
    protected void operation() throws Exception {
        artikli = dbbr.getAll(odo);
    }
    
    public List<DomainObject> getArtikle(){
        return artikli;
    }
    
}
