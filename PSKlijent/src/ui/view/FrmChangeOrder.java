/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.view;

import controller.CommunicationController;
import domain.Korisnik;
import domain.Ponuda;
import domain.Porudzbina;
import domain.StavkaPonude;
import domain.StavkaPorudzbine;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import ui.view.components.TableModelPonudaKorisnik;
import ui.view.components.TableModelPorudzbina;

/**
 *
 * @author Lukaa
 */
public class FrmChangeOrder extends javax.swing.JFrame {

    private Porudzbina p;
    private TableModelPorudzbina model;
    private Korisnik k;
    /**
     * Creates new form FrmChangeOrder
     */
    public FrmChangeOrder(Porudzbina p, Korisnik k, TableModelPorudzbina model) {
        this.p = p;
        this.k = k;
        this.model = model;
        initComponents();
        prepareView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPonude = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPonude.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPonude);

        btnConfirm.setText("Potvrdi");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirm)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        try{    
            model.removeOrder(p);
            CommunicationController.getInstance().deleteOrder(p);
            TableModelPonudaKorisnik model2 = (TableModelPonudaKorisnik) tblPonude.getModel();
            Ponuda ponuda = model2.getPonudatAt(tblPonude.getSelectedRow());
            System.out.println(ponuda.getPonudaNaziv());
            Porudzbina porudzbina = new Porudzbina();
            porudzbina.setPorudzbinaNaziv(ponuda.getPonudaNaziv());
            porudzbina.setPorudzbinaCena(ponuda.getPonudaCena());
            porudzbina.setKorisnikC(k);
            porudzbina.setKorisnikR(ponuda.getKorisnikID());
            porudzbina.setDatumPorudzbine(new Date());
            for(StavkaPonude stavka : ponuda.getStavkePonude()){
                StavkaPorudzbine s = new StavkaPorudzbine();
                s.setStavkaPorudzbineNaziv(stavka.getStavkaPonudeNaziv());
                s.setCena(stavka.getCena());
                s.setPorudzbinaID(p);
                porudzbina.getStavkePorudzbine().add(s);
            }
            porudzbina = CommunicationController.getInstance().saveOrder(porudzbina);
            model.insertPorudzbina(porudzbina);
            model.fireTableDataChanged();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da sacuva novu porudzbinu!", "Greska", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(this, "Uspesna izmena porudzbine!", "Uspesna izmena", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void prepareView() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Promena porudzbine");
        try{
            Korisnik r = p.getKorisnikR();
            List<Ponuda> ponude = CommunicationController.getInstance().getAllOffers(r);
            TableModelPonudaKorisnik model = new TableModelPonudaKorisnik(ponude);
            tblPonude.setModel(model);
        }
        catch(Exception e){
            
        }
        
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPonude;
    // End of variables declaration//GEN-END:variables
}
