/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Ponuda;
import domain.StavkaPonude;
import validator.Validator;
import validator.impl.ValidatorPonuda;

/**
 *
 * @author Luka
 */
public class SOInsertPonuda extends SystemOperation{

    private Validator validator;
    
    public SOInsertPonuda(Ponuda ponuda) throws Exception{
        super();
        odo=ponuda;
        validator=new ValidatorPonuda();
        validator.validate(ponuda);
    }

    
    
    @Override
    protected void operation() throws Exception {
        odo=dbbr.insert(odo);
        Ponuda ponuda = (Ponuda) odo;
        for (StavkaPonude stavka : ponuda.getStavkePonude()) {
            stavka.setPonuda(ponuda);
            dbbr.insert(stavka);
        }
    }
    
}
