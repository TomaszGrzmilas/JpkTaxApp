/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mf.jpk.jpkinitapp;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.security.cert.X509Certificate;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.DefaultCaret;
import static pl.gov.mf.jpk.jpkinitapp.Main.APP_JKS_ALIAS;
import static pl.gov.mf.jpk.jpkinitapp.Main.APP_RELEASE_MODE;
import pl.gov.mf.jpk.jpkinitapp.Main.ReleaseMode;
import pl.gov.mf.jpk.jpkinitapp.util.JKSTool;

/**
 *
 * @author xmo
 */
public class WinApp extends JFrame
{
    public static final Logger LOGGER = Logger.getLogger(WinApp.class.getName());

    public static final String FILE_DOT_EXT_JPK = ".xml";
    
    public static final String JPK_SEND_MODE_TEST = "Tryb testowy";
    public static final String JPK_SEND_MODE_PROD = "Tryb produkcyjny";
    
    private File jpkFile = null;
    private NoticeHandler noticeHandler = null;

    public WinApp()
    {
        initAppContext();
        
        initComponents();
        
        setLocation(200, 100);
        
        ((DefaultCaret) textArea.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        if (Main.APP_RELEASE_LEVEL != Main.ReleaseLevel.PRD)
        {
            modeToggleButton.setEnabled(false);
        }
        
        this.appReleaseMode(Main.APP_RELEASE_MODE);
        
        this.noticeHandler = new NoticeHandler(this.textArea);
        
        Main.LOGGER.addHandler(this.noticeHandler);
        Main.LOGGER.setLevel(Level.ALL);
        
        fileChooser.setFileFilter(new FileFilterJpk());
        
        LOGGER.log(Level.FINE, "{0} swing application launched!", Main.APP_NAME);
    }

    private void initAppContext()
    {
        Main.init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        statusPanel = new javax.swing.JPanel();
        modeToggleButton = new javax.swing.JToggleButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openFileMenuItem = new javax.swing.JMenuItem();
        performFileMenuItem = new javax.swing.JMenuItem();
        closeFileMenuItem = new javax.swing.JMenuItem();
        exitSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();

        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Main.APP_NAME + " " + Main.APP_VERSION + " - " + Main.APP_TITLE);
        setName("appFrame"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        textArea.setForeground(java.awt.Color.gray);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setTabSize(4);
        textArea.setWrapStyleWord(true);
        scrollPane.setViewportView(textArea);

        statusPanel.setPreferredSize(new java.awt.Dimension(600, 25));

        modeToggleButton.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        modeToggleButton.setText(JPK_SEND_MODE_TEST);
        modeToggleButton.setPreferredSize(new java.awt.Dimension(130, 25));
        modeToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(modeToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 470, Short.MAX_VALUE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(modeToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("Plik");

        openFileMenuItem.setMnemonic('o');
        openFileMenuItem.setText("Otwórz");
        openFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openFileMenuItem);

        performFileMenuItem.setText("Wykonaj");
        performFileMenuItem.setEnabled(false);
        performFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(performFileMenuItem);

        closeFileMenuItem.setText("Zamknij");
        closeFileMenuItem.setEnabled(false);
        closeFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(closeFileMenuItem);
        fileMenu.add(exitSeparator);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Wyjście");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 354, Short.MAX_VALUE)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addGap(25, 25, 25)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

        Main.closeHandlers();
        
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuItemActionPerformed

        jpkFile = null;
        
        textArea.setText(null);
        
        fileChooser.setSelectedFile(null);
        
        switch (fileChooser.showOpenDialog(this))
        {
            case JFileChooser.APPROVE_OPTION:

                jpkFile = fileChooser.getSelectedFile();

                break;
        }

        if (jpkFile != null)
        {
            openFileMenuItem.setEnabled(false);
            performFileMenuItem.setEnabled(true);
            closeFileMenuItem.setEnabled(true);
            
            if (Main.APP_RELEASE_LEVEL != Main.ReleaseLevel.TST)
            {
                modeToggleButton.setEnabled(false);
            }
            
            textArea.append("Wczytano plik:\n");
            textArea.append(jpkFile.getAbsolutePath() + "\n\n");
        }
    }//GEN-LAST:event_openFileMenuItemActionPerformed

    private void closeFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFileMenuItemActionPerformed

        jpkFile = null;
        textArea.setText(null);
        closeFileMenuItem.setEnabled(false);
        performFileMenuItem.setEnabled(false);
        openFileMenuItem.setEnabled(true);
        
        if (Main.APP_RELEASE_LEVEL != Main.ReleaseLevel.TST)
        {
            modeToggleButton.setEnabled(true);
        }
    }//GEN-LAST:event_closeFileMenuItemActionPerformed

    private void performFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performFileMenuItemActionPerformed

        closeFileMenuItem.setEnabled(false);
        performFileMenuItem.setEnabled(false);
        
        if ((jpkFile != null) && (jpkFile.isFile()))
        {
            X509Certificate cert;
            
            if (ReleaseMode.PRD == Main.APP_RELEASE_MODE)
            {
                cert = Main.prdJKS.getCertificate(APP_JKS_ALIAS);
            }
            else
            {
                cert = Main.tstJKS.getCertificate(APP_JKS_ALIAS);
            }
            
            new Perform(jpkFile, cert).start();
        }
    }//GEN-LAST:event_performFileMenuItemActionPerformed

    private void modeToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeToggleButtonActionPerformed

        if (modeToggleButton.isSelected())
        {
            this.appReleaseMode(ReleaseMode.PRD);
        }
        else
        {
            this.appReleaseMode(ReleaseMode.TST);
        }
    }//GEN-LAST:event_modeToggleButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        Main.closeHandlers();
    }//GEN-LAST:event_formWindowClosed

    private void appReleaseMode(ReleaseMode releaseMode)
    {
        textArea.setText(null);
        
        Main.APP_RELEASE_MODE = releaseMode;
        
        if (Main.APP_RELEASE_MODE == ReleaseMode.PRD)
        {
            if (!modeToggleButton.isSelected())
            {
                modeToggleButton.setSelected(true);
            }
            
            modeToggleButton.setText(JPK_SEND_MODE_PROD);
            modeToggleButton.setForeground(Color.red);
            textArea.setBackground(java.awt.Color.gray);
            textArea.setForeground(java.awt.Color.orange);        
        }
        else if (Main.APP_RELEASE_MODE == ReleaseMode.TST)
        {
            if (modeToggleButton.isSelected())
            {
                modeToggleButton.setSelected(false);
            }
            
            modeToggleButton.setText(JPK_SEND_MODE_TEST);
            modeToggleButton.setForeground(Color.black);
            textArea.setBackground(java.awt.Color.white);
            textArea.setForeground(java.awt.Color.gray);        
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
                //if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    
                    break;
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            LOGGER.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeFileMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator exitSeparator;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JToggleButton modeToggleButton;
    private javax.swing.JMenuItem openFileMenuItem;
    private javax.swing.JMenuItem performFileMenuItem;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    private class FileFilterJpk extends FileFilter 
    {
        @Override
        public boolean accept(File file)
        {
            return (file.isDirectory() || file.getName().endsWith(FILE_DOT_EXT_JPK));
        }

        @Override
        public String getDescription()
        {
            return "Pliki JPK w formacie XML";
        }
    }
    
    private class NoticeHandler extends Handler
    {
        JTextArea textArea = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        private NoticeHandler()
        {
        }
        
        public NoticeHandler(JTextArea textArea)
        {
            this.textArea = textArea;
            
            this.textArea.setText(null);
        }

        @Override
        public synchronized void publish(LogRecord record)
        {
            if (this.textArea != null)
            {
                if (record.getLevel().intValue() > Level.FINE.intValue())
                {
                    if (record.getMessage() != null)
                    {
                        String message = record.getMessage();
                        
                        if (record.getParameters() != null)
                        {
                            for (int i =0; i < record.getParameters().length; i++)
                            {
                                message = message.replace("{" + i + "}", String.valueOf(record.getParameters()[i]));
                            }
                        }
                        
                        if (message.startsWith("----------"))
                        {
                            textArea.append(message + "\n");
                        }
                        else
                        {
                            textArea.append(sdf.format(new Date(record.getMillis())) + " " + message + "\n");
                        }
                    }
                }
            }
        }

        @Override
        public void flush()
        {
        }

        @Override
        public void close() throws SecurityException 
        {
        }
    }
    
    private class Perform extends Thread
    {
        private File jpkFile;
        private X509Certificate cert;
        
        private Perform()
        {
            
        }
        
        public Perform(File jpkFile, X509Certificate cert)
        {
            this.jpkFile = jpkFile;
            this.cert = cert;
        }
        
        @Override
        public void run()
        {
            try
            {
                Main.perform(this.jpkFile, this.cert);
            }
            finally
            {
                closeFileMenuItem.setEnabled(true);
            }
        }
    }
}
