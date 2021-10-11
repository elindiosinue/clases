
package java3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java3.controlador.Lista;
import java3.modelo.Administrativo;
import java3.modelo.Agente;

public class PanelMostrDatos extends javax.swing.JPanel {
    
    Object actual = new Object ();
    
    public PanelMostrDatos(){
        initComponents();
        
        // Al inicio, el botón "Anterior" estará desactivado
        btnMostrarAnterior.setEnabled(false);
        
        // Botón Anterior         
        ActionListener oyente = new ActionListener (){
            @Override       
            public void actionPerformed(ActionEvent e) {
                
                actual = Lista.devuelveObjeto();      // 'actual' recogerá la lista             
            }       
        };
        btnMostrarAnterior.addActionListener(oyente);
        
        // Botón Siguiente
        ActionListener oyente2 = new ActionListener (){
            @Override       
            public void actionPerformed(ActionEvent e) {
                btnMostrarAnterior.setEnabled(true);
                actual = Lista.devuelveObjeto();  // tipo Object (actual)
                Lista.avanzar();
                actual = Lista.devuelveObjeto();  // tipo Object (actual)
                filtrarObjeto(actual);
            }       
        };
        btnMostrarsiguiente.addActionListener(oyente2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labEmpleado = new javax.swing.JLabel();
        labelStringEmp = new javax.swing.JLabel();
        labelAtribEmp = new javax.swing.JLabel();
        mostrNomEmp = new javax.swing.JTextField();
        mostrSueldoEmp = new javax.swing.JTextField();
        mostrFechaEmp = new javax.swing.JTextField();
        mostrIntEmp = new javax.swing.JTextField();
        mostrAtribEmp = new javax.swing.JTextField();
        btnMostrarAnterior = new javax.swing.JButton();
        btnMostrarsiguiente = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Verdana Pro Cond", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Verdana Pro Cond", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sueldo:");

        jLabel3.setFont(new java.awt.Font("Verdana Pro Cond", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de alta:");

        labEmpleado.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 24)); // NOI18N
        labEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        labEmpleado.setText("EMPLEADO");

        labelStringEmp.setFont(new java.awt.Font("Verdana Pro Cond", 0, 18)); // NOI18N
        labelStringEmp.setForeground(new java.awt.Color(255, 255, 255));
        labelStringEmp.setText("IntEmpleado");

        labelAtribEmp.setFont(new java.awt.Font("Verdana Pro Cond", 0, 18)); // NOI18N
        labelAtribEmp.setForeground(new java.awt.Color(255, 255, 255));
        labelAtribEmp.setText("AtributoEmpleado");

        mostrNomEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrNomEmpActionPerformed(evt);
            }
        });

        mostrAtribEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrAtribEmpActionPerformed(evt);
            }
        });

        btnMostrarAnterior.setFont(new java.awt.Font("Verdana Pro Cond", 0, 18)); // NOI18N
        btnMostrarAnterior.setText("Anterior");
        btnMostrarAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarAnteriorActionPerformed(evt);
            }
        });

        btnMostrarsiguiente.setFont(new java.awt.Font("Verdana Pro Cond", 0, 18)); // NOI18N
        btnMostrarsiguiente.setText("Siguiente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(118, 294, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStringEmp)
                            .addComponent(labelAtribEmp)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostrAtribEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mostrIntEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(mostrFechaEmp))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mostrNomEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(mostrSueldoEmp))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(labEmpleado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnMostrarAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMostrarsiguiente)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(labEmpleado)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mostrNomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mostrSueldoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrFechaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStringEmp)
                    .addComponent(mostrIntEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAtribEmp)
                    .addComponent(mostrAtribEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarAnterior)
                    .addComponent(btnMostrarsiguiente))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mostrAtribEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrAtribEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrAtribEmpActionPerformed
   
    private void btnMostrarAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarAnteriorActionPerformed
    
    }//GEN-LAST:event_btnMostrarAnteriorActionPerformed
        
    
    private void mostrNomEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrNomEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrNomEmpActionPerformed

    
    public void filtrarObjeto(Object actual) {
        if (actual instanceof Administrativo)       
            esAdministrativo(actual);          
        else           
            if (actual instanceof Agente)
                esAgente (actual);   
    }

    public void esAdministrativo (Object actual){
        //Cambiamos las jLabels
        labEmpleado.setText("ADMINISTRATIVO");
        labelStringEmp.setText("Horas de oficina: ");
        labelAtribEmp.setText("Tipo de contrato: ");
        
        //Para poder acceder a los campos de Administrativo creo un nuevo objeto que sea  este tipo
        Administrativo admin = (Administrativo)actual;
        
        //Mostramos en los jTextFiels la info  
        mostrNomEmp.setText(admin.getNombre());
        mostrSueldoEmp.setText(String.valueOf(admin.getSueldo()));
        mostrIntEmp.setText(String.valueOf(admin.getHorasOficina()));
        mostrAtribEmp.setText(admin.getTipoContrato());
    }
    
    public void esAgente (Object actual){
        //Cambiamos las jLabels
        labEmpleado.setText("AGENTE");
        labelStringEmp.setText("Inmuebles: ");
        labelAtribEmp.setText("Incentivo/mes: ");
        
        //Para poder acceder a los campos de Agente creo un nuevo objeto que sea  este tipo
        Agente agent = (Agente)actual;
        
        //Mostramos en los jTextFiels la info
        mostrNomEmp.setText(agent.getNombre());
        mostrSueldoEmp.setText(String.valueOf(agent.getSueldo()));
        mostrIntEmp.setText(String.valueOf(agent.getInmuebles()));
        mostrAtribEmp.setText(String.valueOf(agent.getIncentivoPorVenta()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarAnterior;
    private javax.swing.JButton btnMostrarsiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labEmpleado;
    private javax.swing.JLabel labelAtribEmp;
    private javax.swing.JLabel labelStringEmp;
    private javax.swing.JTextField mostrAtribEmp;
    private javax.swing.JTextField mostrFechaEmp;
    private javax.swing.JTextField mostrIntEmp;
    private javax.swing.JTextField mostrNomEmp;
    private javax.swing.JTextField mostrSueldoEmp;
    // End of variables declaration//GEN-END:variables

    
}
