/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfcheckout.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import selfcheckout.mysql.MySQLConn;

/**
 *
 * @author Vocany
 */
public class SearchResultGUI extends javax.swing.JFrame 
{
    TransactionGUI tr;
    String searchWord;
    double totalPrice;
    GridLayout searchLayout;
    //Connecting to the MySQL DB
    MySQLConn connection = new MySQLConn();
    Connection conn = null;
    /**
     * Creates new form SearchResultGUI
     */
    public SearchResultGUI() {
        initComponents();
        
        //GridLayout to store the buttons for each Dairy product
        searchLayout = new GridLayout(0,4);
        
        //Set the GridLayout as the layout for the panel
        jPanel1.setLayout(searchLayout);
        
        //Adjust the horizontal and vertical gaps between buttons
        searchLayout.setHgap(10);
        searchLayout.setVgap(10);
        
        //Preferred Size of the buttons
        JButton b = new JButton("Just a fake button");
        Dimension buttonSize = b.getPreferredSize();
        jPanel1.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 3.5) + 10,
            (int)(buttonSize.getHeight() * 3.5) + 10 * 2));
    }

    public SearchResultGUI(TransactionGUI tr) 
    {
        initComponents();
        this.tr = tr;

        //GridLayout to store the buttons for each Dairy product
        searchLayout = new GridLayout(0,4);
        
        //Set the GridLayout as the layout for the panel
        jPanel1.setLayout(searchLayout);
        
        //Adjust the horizontal and vertical gaps between buttons
        searchLayout.setHgap(10);
        searchLayout.setVgap(10);
        
        //Preferred Size of the buttons
        JButton b = new JButton("Just a fake button");
        Dimension buttonSize = b.getPreferredSize();
        jPanel1.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 3.5) + 10,
            (int)(buttonSize.getHeight() * 3.5) + 10 * 2));
    }
    
    //Method to display the search results
    public void DisplaySearch(String word)
    {
        //Number of rows for the result set
        int rows = 0;
        try
        {
            //Connect and open the connection to the DB
            conn = connection.DBUtils();

            //Create the query and the result set to get the results
            String query = "SELECT * FROM SelfCheckOut.Products WHERE Name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, "%" + word + "%");
            ResultSet rs = stmt.executeQuery();
            rs.next();

            //Find the number of rows
            if(rs.last())
            {
                rows = rs.getRow();
                //Move the cursor to the beginning
                rs.beforeFirst();
            }

            //Create Buttons for each product that matches the search word
            for(int i = 0; i < rows; i++)
            {
                if(rs.next() != false)
                {
                    String name = rs.getString("Name");
                    JButton button = new JButton(name);
                    button.addActionListener(addToCart);
                    jPanel1.add(button);
                }
            }

        }catch (Exception ex)
        {
            Logger.getLogger(SearchResultGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Action listener to take input from the search bar
    private ActionListener addToCart = new ActionListener()
    {
        double priceOfProduct;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String selectedProduct = e.getActionCommand();  //Retrieves the name of the selected product
            
            try
            {
                //Connect and open the connection the the DB
                conn = connection.DBUtils();
                
                //Create the query and result set to get the results
                String query = "SELECT Price FROM SelfCheckOut.Products WHERE Name=?";
                PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                stmt.setString(1, selectedProduct);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                
                //Get the price of the product
                priceOfProduct = rs.getDouble("Price");
                
                //Add the name of the product and the price to the cart
                tr.AddToItems(selectedProduct);
                tr.AddToPrice(priceOfProduct);
                
                rs.close();
                conn.close();
            }catch (Exception ex)
            {
                Logger.getLogger(SearchResultGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Update the total price
            totalPrice = Double.parseDouble(tr.getTotal()) + priceOfProduct;
            tr.setTotal("" + totalPrice);
            jPanel1.removeAll();
            SearchResultGUI.this.dispose();
        }
    };
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel1.removeAll();
        SearchResultGUI.this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchResultGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchResultGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchResultGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchResultGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchResultGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
