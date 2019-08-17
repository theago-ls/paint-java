package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

public class Tela extends javax.swing.JFrame { 
               
    public Tela() {
        initComponents(); 
        this.setPreferredSize(new Dimension(800,640));
        ImageIcon quadradoIcon = new ImageIcon(getClass().getResource("/icons/quadrado.png")); 
        ImageIcon elipseIcon = new ImageIcon(getClass().getResource("/icons/elipse.png"));
        ImageIcon circuloIcon = new ImageIcon(getClass().getResource("/icons/circulo.png"));
        ImageIcon lapisIcon = new ImageIcon(getClass().getResource("/icons/lapis.png"));        
        quadradoButton.setIcon(quadradoIcon);
        lapisButton.setIcon(lapisIcon);
        circuloButton.setIcon(circuloIcon);
        elipseButton.setIcon(elipseIcon);        
    }
    
    public void infoInit(){
        infoTextArea.setText("");
        for(String info: dadosPanel.getInfo()){
            infoTextArea.append(info);
        }
    }
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        ferramentasPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        formasPanel = new javax.swing.JPanel();
        quadradoButton = new javax.swing.JButton();
        lapisButton = new javax.swing.JButton();
        circuloButton = new javax.swing.JButton();
        elipseButton = new javax.swing.JButton();
        botoesPanel = new javax.swing.JPanel();
        setarCorButton = new javax.swing.JButton();
        selecionarButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        excluirButton1 = new javax.swing.JButton();
        moverButton1 = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        dadosPanel = new interfaces.PainelPrincipal();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("framePrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 640));
        setResizable(false);

        ferramentasPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        formasPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout formasPanelLayout = new javax.swing.GroupLayout(formasPanel);
        formasPanel.setLayout(formasPanelLayout);
        formasPanelLayout.setHorizontalGroup(
            formasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        formasPanelLayout.setVerticalGroup(
            formasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        quadradoButton.setFocusPainted(false);
        quadradoButton.setPreferredSize(new java.awt.Dimension(64, 64));
        quadradoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quadradoButtonActionPerformed(evt);
            }
        });

        lapisButton.setFocusPainted(false);
        lapisButton.setPreferredSize(new java.awt.Dimension(64, 64));
        lapisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapisButtonActionPerformed(evt);
            }
        });

        circuloButton.setFocusPainted(false);
        circuloButton.setPreferredSize(new java.awt.Dimension(64, 64));
        circuloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circuloButtonActionPerformed(evt);
            }
        });

        elipseButton.setFocusPainted(false);
        elipseButton.setPreferredSize(new java.awt.Dimension(64, 64));
        elipseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elipseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(circuloButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quadradoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lapisButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elipseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(formasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lapisButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quadradoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(circuloButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elipseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(formasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        botoesPanel.setBackground(new java.awt.Color(255, 255, 255));

        setarCorButton.setBackground(new java.awt.Color(255, 255, 255));
        setarCorButton.setText("Mudar cor");
        setarCorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setarCorButtonActionPerformed(evt);
            }
        });

        selecionarButton.setBackground(new java.awt.Color(255, 255, 255));
        selecionarButton.setText("Selecionar");
        selecionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Limpar");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        excluirButton1.setBackground(new java.awt.Color(255, 255, 255));
        excluirButton1.setText("Excluir");
        excluirButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirButton1ActionPerformed(evt);
            }
        });

        moverButton1.setBackground(new java.awt.Color(255, 255, 255));
        moverButton1.setText("Mover");
        moverButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botoesPanelLayout = new javax.swing.GroupLayout(botoesPanel);
        botoesPanel.setLayout(botoesPanelLayout);
        botoesPanelLayout.setHorizontalGroup(
            botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(selecionarButton)
                    .addComponent(setarCorButton)
                    .addComponent(clearButton)
                    .addComponent(excluirButton1)
                    .addComponent(moverButton1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        botoesPanelLayout.setVerticalGroup(
            botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(setarCorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selecionarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(moverButton1))
        );

        javax.swing.GroupLayout ferramentasPanelLayout = new javax.swing.GroupLayout(ferramentasPanel);
        ferramentasPanel.setLayout(ferramentasPanelLayout);
        ferramentasPanelLayout.setHorizontalGroup(
            ferramentasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ferramentasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ferramentasPanelLayout.setVerticalGroup(
            ferramentasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ferramentasPanelLayout.createSequentialGroup()
                .addGroup(ferramentasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ferramentasPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ferramentasPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(botoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        infoTextArea.setBackground(new java.awt.Color(255, 255, 255));
        infoTextArea.setColumns(20);
        infoTextArea.setRows(5);
        jScrollPane1.setViewportView(infoTextArea);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        dadosPanel.setAlignmentX(1.0F);
        dadosPanel.setAlignmentY(1.0F);
        dadosPanel.setMinimumSize(new java.awt.Dimension(300, 300));
        dadosPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dadosPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dadosPanelLayout = new javax.swing.GroupLayout(dadosPanel);
        dadosPanel.setLayout(dadosPanelLayout);
        dadosPanelLayout.setHorizontalGroup(
            dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        dadosPanelLayout.setVerticalGroup(
            dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ferramentasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dadosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ferramentasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moverButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverButton1ActionPerformed
        dadosPanel.setTool(5);
    }//GEN-LAST:event_moverButton1ActionPerformed

    private void selecionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarButtonActionPerformed
        dadosPanel.setTool(6);
    }//GEN-LAST:event_selecionarButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        dadosPanel.clear();
        infoInit();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void setarCorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setarCorButtonActionPerformed
        Color cor = JColorChooser.showDialog(rootPane,"Escolha uma cor", Color.white);
        dadosPanel.setarCor(cor);        
    }//GEN-LAST:event_setarCorButtonActionPerformed

    private void excluirButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirButton1ActionPerformed
        dadosPanel.setTool(7);
        infoInit();
    }//GEN-LAST:event_excluirButton1ActionPerformed

    private void circuloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circuloButtonActionPerformed
        dadosPanel.setTool(2);
    }//GEN-LAST:event_circuloButtonActionPerformed

    private void elipseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elipseButtonActionPerformed
        dadosPanel.setTool(3);
    }//GEN-LAST:event_elipseButtonActionPerformed

    private void lapisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapisButtonActionPerformed
        dadosPanel.setTool(4);
    }//GEN-LAST:event_lapisButtonActionPerformed

    private void quadradoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quadradoButtonActionPerformed
        dadosPanel.setTool(1);
    }//GEN-LAST:event_quadradoButtonActionPerformed

    private void dadosPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dadosPanelMouseClicked
        infoInit();
    }//GEN-LAST:event_dadosPanelMouseClicked
       
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoesPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton circuloButton;
    private javax.swing.JButton clearButton;
    private interfaces.PainelPrincipal dadosPanel;
    private javax.swing.JButton elipseButton;
    private javax.swing.JButton excluirButton1;
    private javax.swing.JPanel ferramentasPanel;
    private javax.swing.JPanel formasPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lapisButton;
    private javax.swing.JButton moverButton1;
    private javax.swing.JButton quadradoButton;
    private javax.swing.JButton selecionarButton;
    private javax.swing.JButton setarCorButton;
    // End of variables declaration//GEN-END:variables
}
