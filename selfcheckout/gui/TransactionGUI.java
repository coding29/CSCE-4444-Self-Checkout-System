/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfcheckout.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Vocany
 */
public class TransactionGUI extends javax.swing.JFrame 
{
    SearchResultGUI sr = new SearchResultGUI(this);
    ProductGUI pg;
    StyledDocument doc;
    StyledDocument prc;
    String word;

    /**
     * Creates new form TransactionGUI
     */
    
    public TransactionGUI(SearchResultGUI sr) {
        initComponents();
        this.sr = sr;
        
        //Changes the background color of the main screen
        Container content = this.getContentPane();
        content.setBackground(Color.gray);
    }
    
    public TransactionGUI() {
        initComponents();
        
        //Changes the background color of the main screen
        Container content = this.getContentPane();
        content.setBackground(Color.gray);
        
        //Add ActionListener to the search button
        searchButton.addActionListener(keywordSearch);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemsTextPane = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        priceTextPane = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        totalTextPane = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        dairyButton = new javax.swing.JButton();
        frozenButton = new javax.swing.JButton();
        produceButton = new javax.swing.JButton();
        meatButton = new javax.swing.JButton();
        alcoholtobaccoButton = new javax.swing.JButton();
        otherButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        payButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane3.setBorder(null);

        itemsTextPane.setEditable(false);
        itemsTextPane.setBorder(null);
        jScrollPane3.setViewportView(itemsTextPane);

        jScrollPane4.setBorder(null);

        priceTextPane.setEditable(false);
        priceTextPane.setBorder(null);
        jScrollPane4.setViewportView(priceTextPane);

        totalTextPane.setEditable(false);
        totalTextPane.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        totalTextPane.setText("0.00");
        totalTextPane.setFocusable(false);
        jScrollPane1.setViewportView(totalTextPane);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("TOTAL $");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(183, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane3)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );

        searchTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        searchButton.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        searchButton.setText("SEARCH");

        dairyButton.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        dairyButton.setText("DAIRY");
        dairyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dairyButtonActionPerformed(evt);
            }
        });

        frozenButton.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        frozenButton.setText("FROZEN");
        frozenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frozenButtonActionPerformed(evt);
            }
        });

        produceButton.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        produceButton.setText("PRODUCE");
        produceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produceButtonActionPerformed(evt);
            }
        });

        meatButton.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        meatButton.setText("MEAT");
        meatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meatButtonActionPerformed(evt);
            }
        });

        alcoholtobaccoButton.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        alcoholtobaccoButton.setText("ALCOHOL/TOBACCO");
        alcoholtobaccoButton.setToolTipText("");
        alcoholtobaccoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alcoholtobaccoButtonActionPerformed(evt);
            }
        });

        otherButton.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        otherButton.setText("OTHER");
        otherButton.setBorder(null);

        helpButton.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        helpButton.setText("HELP");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        payButton.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        payButton.setText("PAY");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dairyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alcoholtobaccoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(meatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(frozenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(otherButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(produceButton, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dairyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frozenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alcoholtobaccoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(otherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dairyButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dairyButtonActionPerformed
    {//GEN-HEADEREND:event_dairyButtonActionPerformed
        // TODO add your handling code here:
        pg = new ProductGUI(this, "Dairy");
        pg.setVisible(true);
    }//GEN-LAST:event_dairyButtonActionPerformed

    private void frozenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frozenButtonActionPerformed
        // TODO add your handling code here:
        pg = new ProductGUI(this, "Frozen");
        pg.setVisible(true);
    }//GEN-LAST:event_frozenButtonActionPerformed

    private void produceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produceButtonActionPerformed
        // TODO add your handling code here:
        pg = new ProductGUI(this, "Produce");
        pg.setVisible(true);
    }//GEN-LAST:event_produceButtonActionPerformed

    private void alcoholtobaccoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alcoholtobaccoButtonActionPerformed
        // TODO add your handling code here:
        pg = new ProductGUI(this, "Alcohol/Tobacco");
        pg.setVisible(true);
    }//GEN-LAST:event_alcoholtobaccoButtonActionPerformed

    private void meatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meatButtonActionPerformed
        // TODO add your handling code here:
        pg = new ProductGUI(this, "Meat");
        pg.setVisible(true);
    }//GEN-LAST:event_meatButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_helpButtonActionPerformed

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        // TODO add your handling code here:
        String tp = totalTextPane.getText();
        if(!tp.equals("0.00"))
        {
            PayGUI pay = new PayGUI(tp, this);
            pay.setVisible(true);
        }
    }//GEN-LAST:event_payButtonActionPerformed

    //Public method to add items to the cart
    public void AddToItems(String item)
    {        
        try
        {
            doc = this.itemsTextPane.getStyledDocument();
            doc.insertString(doc.getLength(),item + "\n", null);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    //Public method to add the price to the cart
    public void AddToPrice(Double price)
    {
        try
        {
            prc = this.priceTextPane.getStyledDocument();
            prc.insertString(prc.getLength(), price + "\n", null);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    //Public method to reveal the total price
    public String getTotal()
    {
        return totalTextPane.getText();
    }
    
    //Public method to set the total price
    public void setTotal(String total)
    {
        totalTextPane.setText(total); 
    }

    //Action listener for doing searches
    public ActionListener keywordSearch = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            word = searchTextField.getText(); // this varible stores the word the customer searched for
            
            if(word.length() > 0)//only show product page if a search word is entered
            {
                //sr.searchWord = word;
                sr.setVisible(true);
                sr.DisplaySearch(word);
            }
        }
    };
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransactionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alcoholtobaccoButton;
    private javax.swing.JButton dairyButton;
    private javax.swing.JButton frozenButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JTextPane itemsTextPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton meatButton;
    private javax.swing.JButton otherButton;
    private javax.swing.JButton payButton;
    private javax.swing.JTextPane priceTextPane;
    private javax.swing.JButton produceButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTextPane totalTextPane;
    // End of variables declaration//GEN-END:variables
}
