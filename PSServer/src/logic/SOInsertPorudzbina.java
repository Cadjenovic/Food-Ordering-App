/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Porudzbina;
import domain.StavkaPorudzbine;

/**
 *
 * @author Luka
 */
public class SOInsertPorudzbina extends SystemOperation{
    
    public SOInsertPorudzbina(Porudzbina porudzbina) {
        super();
        odo=porudzbina;
    }

    
    
    @Override
    protected void operation() throws Exception {
        odo=dbbr.insert(odo);
        Porudzbina porudzbina = (Porudzbina) odo;
        for (StavkaPorudzbine stavka : porudzbina.getStavkePorudzbine()) {
            stavka.setPorudzbinaID(porudzbina);
            dbbr.insert(stavka);
        }
    }
    
    
    
}
