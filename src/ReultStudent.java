
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class ReultStudent extends javax.swing.JFrame {

    public ReultStudent(int n){
        setIconImage(new ImageIcon("F:\\photos\\download2.jpg").getImage());
           initComponents();
           String p=" ",c=" ",m=" ",tm=" ",fn=" ",ct=" ";
        String name=" ";
           String dbURL = "jdbc:mysql://localhost:3306/jeedb";
            String username ="root";
            String password = "12345678";
        String query="select * from student where rollno="+n;
        String q = "select *from marks where roll = "+n;
        Connection conn = null;
        Statement state = null;
        Statement state1 = null;
        Statement state2 = null;
        try{            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query); 
                ResultSet res;
                res= state.executeQuery(query);
                while(res.next()){
                 name=  res.getString("name");
                 fn=  res.getString("fname");
                 ct=  res.getString("ctg");
                }
                state1 = conn.prepareStatement(q);
                ResultSet rs;
                rs = state1.executeQuery(q);
                while(rs.next()){
                    m= rs.getString("mm");
                    p = rs.getString("pm");
                    c = rs.getString("cm");
                    tm = rs.getString("tm");
                }
                l1.setText(name);
                l2.setText(fn);
                l3.setText(ct);
                String rn="JEE19M" ;
                rn+=Integer.toString(n);
                l4.setText(rn);
                l5.setText(m);
                l6.setText(p);
                l7.setText(c);
                l8.setText(tm);
        }
        catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
    }
        int i=0;
       int j=0;
        query="select * from marks order by tm desc,mm desc,pm desc ,cm desc";
        try{
            int roll1;
            
                ResultSet res;
                res= state.executeQuery(query);   
                while(res.next()){
                    i++;
                    roll1=res.getInt("roll");
                    if(roll1==n)
                        break;
                }
                l9.setText(Integer.toString(i));
            switch (ct) {
                case "OBC":
                    j = categoryrankOBC(n);
                    break;
                case "SC":
                    j = categoryrankSC(n);
                    break;
                case "ST":
                    j = categoryrankST(n);
                    break;
                case "GENERAL":
                    String s = "NOT APPLICABLE";
                    j = Integer.parseInt(s);
                    break;
                case "PWD":
                    j = categoryrankPWD(n);
                    break;
            }
                lcat.setText(Integer.toString(j)); 
        }
        catch(Exception e){       
                        }

    }
    private int categoryrankST (int n) {
        String dbURL = "jdbc:mysql://localhost:3306/jeedb";
        String username ="root";
        String password = "12345678";
        
        Connection conn = null;
        Statement state = null;
        ResultSet result;
        String query = "select student.rollno,marks.mm,marks.tm,marks.pm,marks.cm from student inner join marks on student.rollno = marks.roll where ctg ='ST' order by tm desc,mm desc,pm desc,cm desc";
        int i=0;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query);
            
            result = state.executeQuery(query);
            //System.out.print(result);
            int roll1;
            while(result.next()){
            i++;
                    roll1=result.getInt("rollno");
                    if(roll1==n)
                        break;     
            }
        }
            catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
        }
        return i;
    }
    
    private int categoryrankPWD (int n) {
        String dbURL = "jdbc:mysql://localhost:3306/jeedb";
        String username ="root";
        String password = "12345678";
        
        Connection conn = null;
        Statement state = null;
        ResultSet result;
        String query = "select student.rollno,marks.mm,marks.tm,marks.pm,marks.cm from student inner join marks on student.rollno = marks.roll where ctg ='PWD' order by tm desc,mm desc,pm desc,cm desc";
        int i=0;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query);
            
            result = state.executeQuery(query);
            //System.out.print(result);
            int roll1;
            while(result.next()){
            i++;
                    roll1=result.getInt("rollno");
                    if(roll1==n)
                        break;     
            }
        }
            catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
        }
        return i;
    }
    
    private int categoryrankSC (int n) {
        String dbURL = "jdbc:mysql://localhost:3306/jeedb";
        String username ="root";
        String password = "12345678";
        
        Connection conn = null;
        Statement state = null;
        ResultSet result;
        String query = "select student.rollno,marks.mm,marks.tm,marks.pm,marks.cm from student inner join marks on student.rollno = marks.roll where ctg ='SC' order by tm desc,mm desc,pm desc,cm desc";
        int i=0;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query);
            
            result = state.executeQuery(query);
            //System.out.print(result);
            int roll1;
            while(result.next()){
            i++;
                    roll1=result.getInt("rollno");
                    if(roll1==n)
                        break;     
            }
        }
            catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
        }
        return i;
    }
    private int categoryrankOBC (int n) {
        String dbURL = "jdbc:mysql://localhost:3306/jeedb";
        String username ="root";
        String password = "12345678";
        
        Connection conn = null;
        Statement state = null;
        ResultSet result;
        String query = "select student.rollno,marks.mm,marks.tm,marks.pm,marks.cm from student inner join marks on student.rollno = marks.roll where ctg ='OBC' order by tm desc,mm desc,pm desc,cm desc";
        int i=0;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Getting database access to MySql Server
            conn = DriverManager.getConnection(dbURL, username, password);
            
            // Prepared statement to execute SQL Query
            state = conn.prepareStatement(query);
            
            result = state.executeQuery(query);
            //System.out.print(result);
            int roll1;
            while(result.next()){
            i++;
                    roll1=result.getInt("rollno");
                    if(roll1==n)
                        break;     
            }
        }
            catch(Exception e){
            System.out.print("\nError in connectrion : " + e);
        }
        return i;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        lcat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("RESULT");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NAME                    :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("FATHER'S NAME      :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("CATEGORY             :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ROLL NO.               :");

        l1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l1.setText("jLabel10");

        l2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l2.setText("jLabel6");

        l3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l3.setText("jLabel7");

        l4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l4.setText("jLabel8");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("MATHS       :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("PHYSICS     :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("CHEMISTRY :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("TOTAL        :");

        l5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l5.setText("jLabel10");

        l6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l6.setText("jLabel11");

        l7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l7.setText("jLabel12");

        l8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l8.setForeground(new java.awt.Color(0, 51, 204));
        l8.setText("jLabel13");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("     AIR            :");

        l9.setBackground(new java.awt.Color(255, 204, 0));
        l9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        l9.setText("jLabel11");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("LOG OUT!");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Category Rank :");

        lcat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lcat.setText("NOT APPLICABLE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addComponent(jLabel3)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(l2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l7)
                            .addComponent(l6)
                            .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l8))
                        .addContainerGap(141, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lcat)
                            .addComponent(l9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(354, 354, 354)
                        .addComponent(jLabel11)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(542, 542, 542))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(l1))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(l2))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(l3))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(l4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(l5))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(l6))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(l7))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(l8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(lcat))
                .addGap(251, 251, 251))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        LoginPage lp = new LoginPage();
        lp.setVisible(true);
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(ReultStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReultStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReultStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReultStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

//        /* Create and display the form */
//      java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReultStudent().setVisible(true);
//                
//            }
//        });
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JLabel lcat;
    // End of variables declaration//GEN-END:variables
}
