/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.BadConsequence;

/**
 *
 * @author danibolanos & jomabose
 */
public class BadConsequenceView extends javax.swing.JPanel {
    
    BadConsequence badConsequenceModel;

    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
        initComponents();
    }
    
    public void setBadConsequence(BadConsequence bc){
       badConsequenceModel = bc;
       
       this.text.setText(badConsequenceModel.getInfo());
  /*     this.levels.setText(Integer.toString(badConsequenceModel.getLevels()));
       
       if(badConsequenceModel instanceof NumericBadConsequence){
          this.randomVT.setText(Integer.toString(((NumericBadConsequence)badConsequenceModel).getNVisibleTreasures()));
          this.randomHT.setText(Integer.toString(((NumericBadConsequence)badConsequenceModel).getNHiddenTreasures()));
       }
       
       if(badConsequenceModel instanceof SpecificBadConsequence){
          this.specificVT.setText(((SpecificBadConsequence)badConsequenceModel).getSpecificVisibleTreasures().toString());
          this.specificHT.setText(((SpecificBadConsequence)badConsequenceModel).getSpecificHiddenTreasures().toString());
       }
       
       if(badConsequenceModel instanceof DeathBadConsequence)
          this.death.setText(Boolean.toString(true));
       else
          this.death.setText(Boolean.toString(false));*/
       
       repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel1.setText("Mal rollo:");

        text.setEditable(false);
        text.setColumns(20);
        text.setRows(5);
        jScrollPane2.setViewportView(text);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
