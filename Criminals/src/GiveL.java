
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class GiveL extends javax.swing.JFrame {
    
    private int id;
    private Connection conn;
    boolean up = false;
    
    public GiveL() {
        initComponents();
    }
    GiveL(int id,Connection conn){
        this.id = id;
        this.conn = conn;
        initComponents();
    }

    private String[] start(){
        int ipc = -1;
        String crim = null;
        ArrayList<String> answer = new ArrayList<String>();
        String query2;
        query2 = String.format("SELECT ipc,description from crime;");
        try {
            PreparedStatement ps = conn.prepareStatement(query2);
            ResultSet rs = ps.executeQuery();
            answer.add("0 - None");
            while(rs.next()){
            crim = rs.getString(2);
            ipc = rs.getInt(1);
            answer.add(ipc+" - "+crim);
            }
            
            rs.close();
         }catch (SQLException ex) {
            Logger.getLogger(citizen_register.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] ans = new String[answer.size()];
        for(int q=0;q<answer.size();q++){
            ans[q] = answer.get(q);
        }
        return ans;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        time = new datechooser.beans.DateChooserCombo();
        add = new javax.swing.JButton();
        applyupdate = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lead = new javax.swing.JTextField();
        crime = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Add/Update Lead");

        jLabel2.setText("Location");

        jLabel3.setText("Date");

        jLabel4.setText("Crime");

        jLabel5.setText("Description");

        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        add.setText("add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        applyupdate.setText("Apply Changes");
        applyupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyupdateActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel6.setText("Lead ID");

        crime.setModel(new DefaultComboBoxModel<>(start()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update)
                    .addComponent(applyupdate)
                    .addComponent(add)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(location, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(crime, javax.swing.GroupLayout.Alignment.LEADING, 0, 129, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(lead, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(crime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(add)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(applyupdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(update)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if(up){
            JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Update in progress, cannot add.");
            return;
        }
        String loc = location.getText();
        String desc = description.getText();
        String cri = crime.getSelectedItem().toString().trim();
            
        int x = (int)(cri.charAt(0))-48;
        if (x==0){
            x = -1;
        }
        if(loc == null || desc == null || cri == null){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Please fill all fields.");
            return;
        }
        
        Date date = time.getSelectedDate().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String addDate = dateFormat.format(date); 
        
        
        System.out.println("Converted String: " + addDate);
        String query1;  
        query1 = String.format("INSERT INTO leads (citizen_id, location, report_date, description, ipc) VALUES('%d','%s','%s','%s','%d');", 
                id,loc,addDate,desc,x);
         try {
            Statement addq = conn.createStatement();
            JFrame f = new JFrame();
            addq.executeUpdate(query1);
            JOptionPane.showMessageDialog(f, "Lead added successfully");
            Citizen c = new Citizen(id,conn);
            c.setVisible(true);
         }catch (SQLException ex) {
            Logger.getLogger(citizen_register.class.getName()).log(Level.SEVERE, null, ex);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Could not add lead, try again.");
        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(up){
                String loc = location.getText();
                String desc = description.getText();
                String cri = crime.getSelectedItem().toString().trim();
                String leadid = lead.getText().toString().trim();
                int x = (int)(cri.charAt(0))-48;
                if (x==0){
                    x = -1;
                }
                if(loc == null || desc == null || cri == null){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please fill all fields.");
                    return;
                }

                Date date = time.getSelectedDate().getTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
                String addDate = dateFormat.format(date); 


                System.out.println("Converted String: " + addDate);
                String query1;  
                query1 = String.format("UPDATE leads set citizen_id = '%d', location = '%s', report_date = '%s', description = '%s', ipc = '%d' WHERE lead_id = '%s' ;", 
                        id,loc,addDate,desc,x,leadid);
                 try {
                    Statement addq = conn.createStatement();
                    JFrame f = new JFrame();
                    addq.executeUpdate(query1);
                    JOptionPane.showMessageDialog(f, "Lead updated successfully");
                    Citizen c = new Citizen(id,conn);
                    c.setVisible(true);
                 }catch (SQLException ex) {
                    Logger.getLogger(citizen_register.class.getName()).log(Level.SEVERE, null, ex);
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Could not update lead, try again.");
                }
            }
            else{
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Give a valid lead_id and set update.");
            }
    }//GEN-LAST:event_updateActionPerformed

    private void applyupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyupdateActionPerformed
        String leadid = lead.getText().toString().trim();
        up = true;
        if(leadid == null){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Enter a valid lead_id");
                    return;
                }
        int cit = -1;
            String q = String.format("SELECT * FROM leads where lead_id = '%s';",leadid);
            try{
                Statement addq = conn.createStatement();
                ResultSet re = addq.executeQuery(q);
                while(re.next()){
                    cit = re.getInt("citizen_id");
                    if(cit != id){
                    up=false;
                    break;}
                    location.setText(re.getString("location"));
                    Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(re.getString("report_date")); 
                    Calendar aDate = Calendar.getInstance();
                    aDate.setTime(date1);
                    time.setSelectedDate(aDate);
                    crime.setSelectedIndex(re.getInt("ipc"));
                    description.setText(re.getString("description"));
                }
                if(!up){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "You're not allowed to access this lead.");
                }
                else{
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Lead data uploaded, make changes and submit update.");
                }
            }
            catch(SQLException | ParseException err){
                JFrame f = new JFrame();
                System.out.println("Err is "+err);
                JOptionPane.showMessageDialog(f, "Couldn't Update, try again.");
            }
    }//GEN-LAST:event_applyupdateActionPerformed

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
            java.util.logging.Logger.getLogger(GiveL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiveL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiveL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiveL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiveL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton applyupdate;
    private javax.swing.JComboBox<String> crime;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lead;
    private javax.swing.JTextField location;
    private datechooser.beans.DateChooserCombo time;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
