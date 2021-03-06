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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import ui.view.components.TableModelPonudaKorisnik;
import ui.view.components.TableModelPorudzbina;

/**
 *
 * @author Luka
 */
public class FrmNewOrder extends javax.swing.JFrame {

    private Porudzbina p;
    private Korisnik k;
    private TableModelPorudzbina model;
    /**
     * Creates new form FrmNewOrder
     */
    public FrmNewOrder(Porudzbina p, Korisnik k, TableModelPorudzbina model) {
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

        cbRestaurants = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPonude = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbRestaurants.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRestaurants.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRestaurantsItemStateChanged(evt);
            }
        });
        cbRestaurants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRestaurantsActionPerformed(evt);
            }
        });
        cbRestaurants.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbRestaurantsPropertyChange(evt);
            }
        });

        jLabel1.setText("Restoran:");

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

        jLabel2.setText("Meni ponuda:");

        btnOrder.setText("Poruci");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRestaurants, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRestaurants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnOrder)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRestaurantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRestaurantsActionPerformed
        try{
            Korisnik k = (Korisnik) cbRestaurants.getSelectedItem();
            List<Ponuda> ponude = CommunicationController.getInstance().getAllOffers(k);
            TableModelPonudaKorisnik model = new TableModelPonudaKorisnik(ponude);
            tblPonude.setModel(model);
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_cbRestaurantsActionPerformed

    private void cbRestaurantsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbRestaurantsPropertyChange
    }//GEN-LAST:event_cbRestaurantsPropertyChange

    private void cbRestaurantsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRestaurantsItemStateChanged
    }//GEN-LAST:event_cbRestaurantsItemStateChanged

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        try{
            if(tblPonude.getSelectedRow() == -1){
                throw new Exception("Izaberite ponudu!");
            }
            TableModelPonudaKorisnik model2 = (TableModelPonudaKorisnik) tblPonude.getModel();
            Ponuda ponuda = model2.getPonudatAt(tblPonude.getSelectedRow());
            p.setPorudzbinaNaziv(ponuda.getPonudaNaziv());
            p.setPorudzbinaCena(ponuda.getPonudaCena());
            p.setKorisnikC(k);
            p.setKorisnikR(ponuda.getKorisnikID());
            p.setDatumPorudzbine(new Date());
            p.setStatus(false);
            for(StavkaPonude stavka : ponuda.getStavkePonude()){
                StavkaPorudzbine s = new StavkaPorudzbine();
                s.setStavkaPorudzbineNaziv(stavka.getStavkaPonudeNaziv());
                s.setCena(stavka.getCena());
                s.setPorudzbinaID(p);
                p.getStavkePorudzbine().add(s);
            }
            p = CommunicationController.getInstance().saveOrder(p);
            model.insertPorudzbina(p);
            model.fireTableDataChanged();
            JOptionPane.showMessageDialog(this, "Uspesna kreirana porudzbina!", "Uspesna porudzbina", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnOrderActionPerformed

    private void prepareView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Nova porudzbina");
        fillRestaurants();
        
        
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrder;
    private javax.swing.JComboBox cbRestaurants;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPonude;
    // End of variables declaration//GEN-END:variables

    private void fillRestaurants() {
        try{
            List<Korisnik> restorani = CommunicationController.getInstance().getAllRestaurants(); 
            cbRestaurants.removeAllItems();
            for(Korisnik k : restorani){
                cbRestaurants.addItem(k);
            }
            
        }
        catch(Exception e){
            
        }
    }
}
