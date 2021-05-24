/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1bd2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        this.setLocationRelativeTo(null);
        /*Lista user,pass*/
        users = new ArrayList();
        try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
            Object[] values = conexion.UserPass();
            for (int i = 0; i < values.length; i++) {
                String aux = values[i].toString();
                splitt(aux);
            }
            Object[] values1 = conexion.TraerClases();
            for (int i = 0; i < values1.length; i++) {
                String aux = values1[i].toString();
                splitClases(aux);
            }
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrincipalEstudiante = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClasesEst2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Administrador = new javax.swing.JFrame();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        ExamID = new javax.swing.JTextField();
        ExamIDClass = new javax.swing.JTextField();
        ExamNumPre = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        CrearClaseID = new javax.swing.JTextField();
        CrearClaseName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        PreguntaID = new javax.swing.JTextField();
        PreguntaTitulo = new javax.swing.JTextField();
        PreguntaIDClase = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        PreguntaDescr = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaClases = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaPregut = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaExam = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        JR_true = new javax.swing.JRadioButton();
        JR_False = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        Registro = new javax.swing.JFrame();
        jLabel7 = new javax.swing.JLabel();
        tbox_IDStudent = new javax.swing.JTextField();
        tbox_NameStudent = new javax.swing.JTextField();
        tbox_UserStudent = new javax.swing.JTextField();
        tbox_PasswordStudent = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        G_Resp = new javax.swing.ButtonGroup();
        Examen = new javax.swing.JFrame();
        jButton10 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tbox_USER = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbox_PASS = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        jLabel3.setText("Lista Examenes no realizados");

        TablaClasesEst2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "ID Clase", "Numero preguntas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaClasesEst2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "ID Clase", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setText("Examenes realizados");

        jButton3.setText("Hacer Examen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PrincipalEstudianteLayout = new javax.swing.GroupLayout(PrincipalEstudiante.getContentPane());
        PrincipalEstudiante.getContentPane().setLayout(PrincipalEstudianteLayout);
        PrincipalEstudianteLayout.setHorizontalGroup(
            PrincipalEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalEstudianteLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PrincipalEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        PrincipalEstudianteLayout.setVerticalGroup(
            PrincipalEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalEstudianteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jButton4.setText("CREAR EXAMEN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("CREAR CLASE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("CREAR PREGUNTA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        ExamID.setEditable(false);

        ExamIDClass.setEditable(false);

        jLabel11.setText("ID:");

        jLabel12.setText("ID CLASE:");

        jLabel13.setText("Numero de Preguntas:");

        CrearClaseID.setEditable(false);

        jLabel14.setText("ID:");

        jLabel15.setText("Nombre:");

        PreguntaID.setEditable(false);

        PreguntaIDClase.setEditable(false);

        jLabel16.setText("ID:");

        jLabel17.setText("Titulo:");

        jLabel18.setText("Descripcion:");

        PreguntaDescr.setColumns(20);
        PreguntaDescr.setRows(5);
        jScrollPane5.setViewportView(PreguntaDescr);

        jLabel19.setText("ID Clase:");

        TablaClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre de la clase"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaClases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClasesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TablaClases);

        TablaPregut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Clase", "Titulo", "Descripcion", "Respuesta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaPregut);

        TablaExam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "ID Clase", "Numero de preguntas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TablaExam);

        jLabel20.setText("CLASES");

        jButton9.setText("Salir");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        G_Resp.add(JR_true);
        JR_true.setSelected(true);
        JR_true.setText("Verdadero");

        G_Resp.add(JR_False);
        JR_False.setText("Falso");

        jLabel5.setText("Respuesta:");

        javax.swing.GroupLayout AdministradorLayout = new javax.swing.GroupLayout(Administrador.getContentPane());
        Administrador.getContentPane().setLayout(AdministradorLayout);
        AdministradorLayout.setHorizontalGroup(
            AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministradorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AdministradorLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9))
                    .addGroup(AdministradorLayout.createSequentialGroup()
                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdministradorLayout.createSequentialGroup()
                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(AdministradorLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AdministradorLayout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(AdministradorLayout.createSequentialGroup()
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(14, 14, 14)
                                                    .addComponent(CrearClaseID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(AdministradorLayout.createSequentialGroup()
                                                    .addComponent(jLabel15)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(CrearClaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(AdministradorLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AdministradorLayout.createSequentialGroup()
                                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(AdministradorLayout.createSequentialGroup()
                                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(48, 48, 48)
                                                        .addComponent(PreguntaTitulo))
                                                    .addGroup(AdministradorLayout.createSequentialGroup()
                                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(74, 74, 74)
                                                        .addComponent(PreguntaID))
                                                    .addGroup(AdministradorLayout.createSequentialGroup()
                                                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                                        .addGap(48, 48, 48)
                                                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(PreguntaIDClase)
                                                            .addGroup(AdministradorLayout.createSequentialGroup()
                                                                .addComponent(JR_true)
                                                                .addGap(10, 10, 10)
                                                                .addComponent(JR_False)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                                .addGap(18, 18, 18)
                                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel18)
                                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(AdministradorLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(AdministradorLayout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(ExamNumPre, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AdministradorLayout.createSequentialGroup()
                                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)
                                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ExamID, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                            .addComponent(ExamIDClass)))
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        AdministradorLayout.setVerticalGroup(
            AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministradorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AdministradorLayout.createSequentialGroup()
                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdministradorLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14))
                            .addComponent(CrearClaseID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdministradorLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel15))
                            .addComponent(CrearClaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AdministradorLayout.createSequentialGroup()
                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(ExamID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdministradorLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12))
                            .addComponent(ExamIDClass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExamNumPre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdministradorLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdministradorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(AdministradorLayout.createSequentialGroup()
                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AdministradorLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel16))
                                    .addComponent(PreguntaID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AdministradorLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel17))
                                    .addComponent(PreguntaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AdministradorLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel19))
                                    .addComponent(PreguntaIDClase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JR_true)
                                        .addComponent(JR_False))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel7.setText("ID Student:");

        tbox_IDStudent.setEditable(false);

        jLabel8.setText("Nombre:");

        jLabel9.setText("User:");

        jLabel10.setText("Password:");

        jButton7.setText("Registrarse");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Volver");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistroLayout = new javax.swing.GroupLayout(Registro.getContentPane());
        Registro.getContentPane().setLayout(RegistroLayout);
        RegistroLayout.setHorizontalGroup(
            RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroLayout.createSequentialGroup()
                .addGroup(RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RegistroLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(tbox_IDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistroLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(tbox_NameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistroLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(tbox_UserStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistroLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(tbox_PasswordStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        RegistroLayout.setVerticalGroup(
            RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton8)
                .addGap(9, 9, 9)
                .addGroup(RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbox_IDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addComponent(tbox_NameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addComponent(tbox_UserStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10))
                    .addComponent(tbox_PasswordStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jButton10.setText("TERMINAR EXAMEN");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ID Clase", "Descripcion", "Respuesta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable3);

        jLabel6.setText("INTRUCCIONES: SELECCIONE LAS RESPUESTAS VERDADERAS");

        javax.swing.GroupLayout ExamenLayout = new javax.swing.GroupLayout(Examen.getContentPane());
        Examen.getContentPane().setLayout(ExamenLayout);
        ExamenLayout.setHorizontalGroup(
            ExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamenLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        ExamenLayout.setVerticalGroup(
            ExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamenLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("User:");

        jLabel2.setText("Password:");

        jButton2.setText("sign in ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tbox_PASS, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addComponent(tbox_USER)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbox_USER, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbox_PASS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.Registro.pack();
        this.Registro.setLocationRelativeTo(this);
        this.setVisible(false);
        this.Registro.setVisible(true);
        tbox_IDStudent.setText(users.size() + "");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        user = tbox_USER.getText();
        pass = tbox_PASS.getText();
        boolean control = false;
        if (user.equals("admin") && pass.equals("admin1234")) {
            this.Administrador.pack();
            this.Administrador.setLocationRelativeTo(this);
            this.setVisible(false);
            this.Administrador.setVisible(true);
            llenarTablaClases();
            CrearClaseID.setText(clases.size() + "");
            idEstudianteActual = 0;
        } else {
            for (int i = 0; i < users.size(); i++) {
                if ((users.get(i).getUser()).equals(user) && (users.get(i).getContra()).equals(pass)) {
                    control = true;
                    System.out.println("ENTRa");
                    idEstudianteActual = users.get(i).getID();
                    try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
                        Object[] valuess = conexion.TraerExame3(idEstudianteActual);
                        splitResult(valuess);
                        llenarTablaResult();
                        valuess = conexion.TraerExames();
                        for (int j = 0; j < valuess.length; j++) {
                            String aux = valuess[j].toString();
                            splitExam2(aux);
                        }
                        for (int j = 0; j < examGeneral.size(); j++) {
                            Examen aux = examGeneral.get(j);
                            for (int k = 0; k < res.size(); k++) {
                                Resultados aux2 = res.get(k);
                                if ((aux.getIDClase() == aux2.getIdClase()) && (aux.getID() == aux2.getIdExamen())) {
                                    examGeneral.remove(j);
                                }
                            }
                        }
                        llenarTablaExam2();
                        conexion.close();
                    } catch (Exception ex) {
                        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    this.PrincipalEstudiante.pack();
                    this.PrincipalEstudiante.setLocationRelativeTo(this);
                    this.setVisible(false);
                    this.PrincipalEstudiante.setVisible(true);
                    break;
                }
            }
            if (control == false) {
                JOptionPane.showMessageDialog(null, "Usuario/Pass incorrecto");
            }
        }

        tbox_USER.setText("");
        tbox_PASS.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Alumno a = new Alumno(Integer.parseInt(tbox_IDStudent.getText()), tbox_NameStudent.getText(), tbox_UserStudent.getText(), tbox_PasswordStudent.getText());
        users.add(a);
        try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
            conexion.addAlumno(a.getNombre(), a.getID(), a.getUser(), a.getContra());
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbox_IDStudent.setText("");
        tbox_NameStudent.setText("");
        tbox_PasswordStudent.setText("");
        tbox_UserStudent.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.Registro.setLocationRelativeTo(this);
        this.setVisible(true);
        this.Registro.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        boolean respuesta;
        if (JR_true.isSelected()) {
            respuesta = true;
        } else {
            respuesta = false;
        }
        Preguntas p = new Preguntas(Integer.parseInt(PreguntaID.getText()), Integer.parseInt(PreguntaIDClase.getText()), PreguntaTitulo.getText(), PreguntaDescr.getText(), respuesta);
        pree.add(p);
        try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
            conexion.addPregunta(p.getTitulo(), p.getID(), p.getDescripcion(), p.getIDClase(), respuesta);
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarTablaPreguntas();
        PreguntaDescr.setText("");
        PreguntaID.setText("");
        PreguntaTitulo.setText("");
        PreguntaID.setText(pree.size() + "");

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Clase c = new Clase(Integer.parseInt(CrearClaseID.getText()), CrearClaseName.getText());
        clases.add(c);
        try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
            conexion.addClase(c.getNombre(), c.getIDClase());
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        CrearClaseName.setText("");
        llenarTablaClases();
        CrearClaseID.setText(clases.size() + "");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TablaClasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClasesMouseClicked
        pree = new ArrayList();
        exam = new ArrayList();
        DefaultTableModel t = (DefaultTableModel) TablaExam.getModel();
        for (int i = t.getRowCount() - 1; i >= 0; i--) {
            t.removeRow(i);
        }
        TablaExam.setModel(t);
        DefaultTableModel tt = (DefaultTableModel) TablaPregut.getModel();
        for (int i = tt.getRowCount() - 1; i >= 0; i--) {
            tt.removeRow(i);
        }
        TablaPregut.setModel(tt);

        String temp = TablaClases.getValueAt(TablaClases.getSelectedRow(), 0).toString();
        int idClase = Integer.parseInt(temp);
        PreguntaIDClase.setText(temp);
        ExamIDClass.setText(temp);
        try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
            Object[] values = conexion.TraerPreguntas(idClase);
            for (int i = 0; i < values.length; i++) {
                String aux = values[i].toString();
                splitPreguntas(aux);
            }
            llenarTablaPreguntas();
            values = conexion.TraerExame(idClase);
            for (int i = 0; i < values.length; i++) {
                String aux = values[i].toString();
                splitExam(aux);
            }
            llenarTablaExam();
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExamIDClass.setText(temp);
        PreguntaID.setText(pree.size() + "");
        ExamID.setText(exam.size() + "");
    }//GEN-LAST:event_TablaClasesMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Examen e = new Examen(Integer.parseInt(ExamID.getText()), Integer.parseInt(ExamIDClass.getText()), Integer.parseInt(ExamNumPre.getValue().toString()));
        try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
            /*Object[] a = conexion.Verifica(e.getID(), e.numPreguntas, e.getIDClase());
            String aux = a[0].toString();
            //boolean aa=(boolean)a;*/
            boolean v=true;
            if (v == false) {
                JOptionPane.showMessageDialog(null, "No hay suficientes preguntas para su examen");
            } else if(v==true) {
                conexion.addExamen(e.getID(), e.numPreguntas, e.getIDClase());
                exam.add(e);
            }
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExamID.setText(exam.size() + "");
        llenarTablaExam();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.setVisible(true);
        this.Administrador.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
        try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
            conexion.addResultado(idex, idc, ide, (CONTADOR*5));
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //nota;
        this.PrincipalEstudiante.pack();
        this.PrincipalEstudiante.setLocationRelativeTo(this);
        this.setVisible(false);
        this.PrincipalEstudiante.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int numpreguntas = (examGeneral.get(TablaClasesEst2.getSelectedRow())).getNumPreguntas();
        int idClase = (examGeneral.get(TablaClasesEst2.getSelectedRow())).getIDClase();
        idc = idClase;
        ide = idEstudianteActual;
        idex = (examGeneral.get(TablaClasesEst2.getSelectedRow())).getID();
        try ( Neo4jCo conexion = new Neo4jCo("bolt://localhost:7687", "Admin", "1234")) {
            Object[] a = conexion.TraerPreguntas(idClase);
            for (int i = 0; i < a.length; i++) {
                String aux = a[i].toString();
                splitPreguntas(aux);
                
            }
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Preguntas> preaux = new ArrayList();
        int cont = 0;
        while (true) {
            int random = (int) (Math.random() * numpreguntas + 0);
            if ((pree.get(random)).getPuesta() == false) {
                preaux.add(pree.get(random));
                cont++;
                (pree.get(random)).setPuesta(true);
            }
            if (cont == numpreguntas) {
                break;
            }
        }
        pree = new ArrayList();
        pree = (ArrayList<Preguntas>) preaux.clone();
        llenarTablaPreguntas2();
        this.Examen.pack();
        this.Examen.setLocationRelativeTo(this);
        this.setVisible(false);
        this.Examen.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        DefaultTableModel t = (DefaultTableModel) jTable3.getModel();
        boolean Respuesta = (boolean)(jTable3.getValueAt(jTable3.getSelectedRow(), 3));
        if((pree.get(jTable3.getSelectedRow())).getRespuesta()==Respuesta){
           CONTADOR++; 
        }
    }//GEN-LAST:event_jTable3MouseClicked

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    public void splitPreguntas(String aux) {
        String[] a = aux.split("\"");
        String[] aux3 = a[4].split(":");
        int aux4 = Integer.parseInt(aux3[1].charAt(1) + "");
        int aux5 = Integer.parseInt(aux3[2].charAt(1) + "");
        char aux1 = aux3[3].charAt(1);
        boolean aux6;
        if (aux1 == 'T') {
            aux6 = true;
        } else {
            aux6 = false;
        }
        Preguntas pr = new Preguntas(aux4, aux5, a[3], a[1], aux6);
        pree.add(pr);   
    }

    public void llenarTablaPreguntas2() {
        DefaultTableModel t = (DefaultTableModel) jTable3.getModel();
        for (int i = t.getRowCount() - 1; i >= 0; i--) {
            t.removeRow(i);
        }
        for (Preguntas i : pree) {
            Object[] clss = {i.getID(), i.getIDClase(), i.getDescripcion()};
            t.addRow(clss);
        }
        jTable3.setModel(t);
    }

    public void llenarTablaPreguntas() {
        DefaultTableModel t = (DefaultTableModel) TablaPregut.getModel();
        for (int i = t.getRowCount() - 1; i >= 0; i--) {
            t.removeRow(i);
        }

        for (Preguntas i : pree) {
            Object[] clss = {i.getID(), i.getIDClase(), i.getTitulo(), i.getDescripcion(), i.getRespuesta()};
            t.addRow(clss);
        }
        TablaPregut.setModel(t);
    }

    public void splitExam(String aux) {
        String[] a = aux.split(":");
        int aux4 = Integer.parseInt(a[1].charAt(1) + "");
        int aux5 = Integer.parseInt(a[2].charAt(1) + "");
        int aux6 = Integer.parseInt(a[3].charAt(1) + "");
        Examen pr = new Examen(aux4, aux5, aux6);
        exam.add(pr);
    }

    public void splitExam2(String aux) {
        String[] a = aux.split(":");
        int aux4 = Integer.parseInt(a[1].charAt(1) + "");
        int aux5 = Integer.parseInt(a[2].charAt(1) + "");
        int aux6 = Integer.parseInt(a[3].charAt(1) + "");
        Examen pr = new Examen(aux4, aux5, aux6);
        examGeneral.add(pr);
    }

    public void llenarTablaExam2() {
        DefaultTableModel t = (DefaultTableModel) TablaClasesEst2.getModel();
        for (int i = t.getRowCount() - 1; i >= 0; i--) {
            t.removeRow(i);
        }
        TablaClasesEst2.setModel(t);
        for (Examen i : examGeneral) {
            Object[] clss = {i.getID(), i.getIDClase(), i.getNumPreguntas()};
            t.addRow(clss);
        }
        TablaClasesEst2.setModel(t);

    }//jTable3

    public void splitResult(Object[] Array) {
        for (int i = 0; i < Array.length; i++) {
            String[] aux = (Array[i].toString()).split(":");
            int aux5 = Integer.parseInt(aux[2].charAt(1) + "");
            int aux6=0;
            if(aux[3].charAt(2)==','){
                 aux6 = Integer.parseInt(aux[3].charAt(1)+"");
            }else{
                aux6 = Integer.parseInt(aux[3].charAt(1)+""+aux[3].charAt(2));
            }
            int aux7 = Integer.parseInt(aux[4].charAt(1) + "");
            System.out.println("Array[i].toString(): " + Array[i].toString());
            res.add(new Resultados(aux6, idEstudianteActual, aux5, aux7));
        }
        llenarTablaResult();
    }

    public void llenarTablaResult() {
        DefaultTableModel t = (DefaultTableModel) jTable2.getModel();
        for (int i = t.getRowCount() - 1; i >= 0; i--) {
            t.removeRow(i);
        }
        for (Resultados i : res) {
            Object[] clss = {i.getIdExamen(), i.getIdClase(), i.Nota};
            t.addRow(clss);
        }
        jTable2.setModel(t);
    }

    public void llenarTablaExam() {
        DefaultTableModel t = (DefaultTableModel) TablaExam.getModel();
        for (int i = t.getRowCount() - 1; i >= 0; i--) {
            t.removeRow(i);
        }
        TablaExam.setModel(t);

        if (exam.size() >= 1) {
            for (Examen i : exam) {
                Object[] clss = {i.getID(), i.getIDClase(), i.getNumPreguntas()};
                t.addRow(clss);
            }
            TablaExam.setModel(t);
        }
    }

    public void splitt(String aux) {
        String[] a = aux.split("\"");
        String[] aux3 = a[6].split(":");
        int aux4 = Integer.parseInt(aux3[1].charAt(1) + "");
        Alumno aa = new Alumno(aux4, a[5], a[1], a[3]);
        users.add(aa);
    }

    public void splitClases(String aux) {
        String[] a = aux.split("\"");
        String[] aux3 = a[0].split(":");
        int aux4 = Integer.parseInt(aux3[1].charAt(1) + "");
        Clase cl = new Clase(aux4, a[1]);
        clases.add(cl);
    }

    public void llenarTablaClases() {
        DefaultTableModel t = (DefaultTableModel) TablaClases.getModel();
        for (int i = t.getRowCount() - 1; i >= 0; i--) {
            t.removeRow(i);
        }
        for (Clase i : clases) {
            Object[] clss = {i.getIDClase(), i.getNombre()};
            t.addRow(clss);
        }
        TablaClases.setModel(t);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Administrador;
    private javax.swing.JTextField CrearClaseID;
    private javax.swing.JTextField CrearClaseName;
    private javax.swing.JTextField ExamID;
    private javax.swing.JTextField ExamIDClass;
    private javax.swing.JSpinner ExamNumPre;
    private javax.swing.JFrame Examen;
    private javax.swing.ButtonGroup G_Resp;
    private javax.swing.JRadioButton JR_False;
    private javax.swing.JRadioButton JR_true;
    private javax.swing.JTextArea PreguntaDescr;
    private javax.swing.JTextField PreguntaID;
    private javax.swing.JTextField PreguntaIDClase;
    private javax.swing.JTextField PreguntaTitulo;
    private javax.swing.JFrame PrincipalEstudiante;
    private javax.swing.JFrame Registro;
    private javax.swing.JTable TablaClases;
    private javax.swing.JTable TablaClasesEst2;
    private javax.swing.JTable TablaExam;
    private javax.swing.JTable TablaPregut;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField tbox_IDStudent;
    private javax.swing.JTextField tbox_NameStudent;
    private javax.swing.JPasswordField tbox_PASS;
    private javax.swing.JPasswordField tbox_PasswordStudent;
    private javax.swing.JTextField tbox_USER;
    private javax.swing.JTextField tbox_UserStudent;
    // End of variables declaration//GEN-END:variables
    public String user, pass;
    public int idEstudianteActual, idc, ide, idex,CONTADOR=0;
    public ArrayList<Alumno> users;
    public ArrayList<Clase> clases = new ArrayList();
    public ArrayList<Preguntas> pree = new ArrayList();
    public ArrayList<Examen> exam = new ArrayList();
    public ArrayList<Resultados> res = new ArrayList();
    public ArrayList<Examen> examGeneral = new ArrayList();
}
