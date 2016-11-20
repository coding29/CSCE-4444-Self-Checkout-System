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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.text.StyledDocument;
import selfcheckout.mysql.MySQLConn;

/**
 *
 * @author Vocany
 */
public class ProductGUI extends javax.swing.JFrame
{
    TransactionGUI tr;  
    double totalPrice;
    //Selected product category
    String product;                     
    
    //Connecting to the MySQL database
    MySQLConn connect = new MySQLConn();
    Connection conn = null;
    
    /**
     * Creates new form ProductGUI
     */
    public ProductGUI()
    {
        initComponents();
        
        //GridLayout to store the buttons for each product
        GridLayout dairyLayout = new GridLayout(0,4);
        
        //Set the GridLayout as the layout for the panel
        jPanel1.setLayout(dairyLayout);
        
        //Adjust the horizontal and vertical gaps between buttons
        dairyLayout.setHgap(10);
        dairyLayout.setVgap(10);
        
        //Preferred Size of the buttons
        JButton b = new JButton("Just a fake button");
        Dimension buttonSize = b.getPreferredSize();
        jPanel1.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 3.5) + 10,
            (int)(buttonSize.getHeight() * 3.5) + 10 * 2));
        
        //Display the items
        DisplayItems();
    }
    
    public ProductGUI(TransactionGUI tr, String product)
    {
        initComponents();
        this.tr = tr;
        this.product = product;
        
        //GridLayout to store the buttons for each product
        GridLayout dairyLayout = new GridLayout(0,4);
        
        //Set the GridLayout as the layout for the panel
        jPanel1.setLayout(dairyLayout);
        
        //Adjust the horizontal and vertical gaps between buttons
        dairyLayout.setHgap(10);
        dairyLayout.setVgap(10);
        
        //Preferred Size of the buttons
        JButton b = new JButton("Just a fake button");
        Dimension buttonSize = b.getPreferredSize();
        jPanel1.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 3.5) + 10,
            (int)(buttonSize.getHeight() * 3.5) + 10 * 2));
        
        //Display the items
        DisplayItems();
    }
    
    //Will disdplay all the items in the selected category
    private void DisplayItems()
    {
        try
        {
            //Number of rows for the ResultSet
            int rows = 0;
            //Connect and open the connection to the database
            conn = connect.DBUtils();
            
            //Create the query and result set to get the results
            String query = "SELECT Name FROM SelfCheckOut.Products WHERE Type=?";
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, this.product);
            ResultSet rs = stmt.executeQuery();
            
            //Find the number of rows
            if(rs.last())
            {
                rows = rs.getRow();
                //Move the cursor to the beginning
                rs.beforeFirst();
            }
            
            //Create buttons for each product
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
            
            //Close the connections
            rs.close();
            conn.close();
            
            
        }catch (Exception ex)
        {
            Logger.getLogger(ProductGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //This ActionListener responds to the buttons on the product list menu
    //and adds them to the cart
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
                conn = connect.DBUtils();
                
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
                Logger.getLogger(ProductGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Update the total price
            totalPrice = Double.parseDouble(tr.getTotal()) + priceOfProduct;
            tr.setTotal("" + totalPrice);
            ProductGUI.this.dispose();
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
        jPanel4 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        backButton.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        backButton.setText("BACK");
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backButtonActionPerformed
    {//GEN-HEADEREND:event_backButtonActionPerformed
        // TODO add your handling code here:
        ProductGUI.this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ProductGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
