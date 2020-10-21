package main;


import javax.swing.JFrame;
import ui.view.FrmWelcome;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luka
 */
public class Main {
    public static void main(String[] args) {
        //Controller controller=new Controller();
        //JFrame forma=new FrmLogIn(controller);
        JFrame form=new FrmWelcome();
        form.setVisible(true);
    }
}
