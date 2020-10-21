/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Ponuda;
import domain.StavkaPonude;

/**
 *
 * @author Luka
 */
public class SODeletePonuda extends SystemOperation{

    public SODeletePonuda(Ponuda p) {
        super();
        odo = p;
    }
    @Override
    protected void operation() throws Exception {
        
        Ponuda p = (Ponuda) odo;
        odo = dbbr.delete(odo);
    }
    
}
