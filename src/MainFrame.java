
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Seemon
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    String imagePath;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseImage = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        colorDetection = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chooseImage.setText("Choose Image");
        chooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageActionPerformed(evt);
            }
        });

        colorDetection.setText("Color  Detection");
        colorDetection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDetectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseImage)
                            .addComponent(colorDetection))
                        .addGap(0, 271, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseImage)
                .addGap(11, 11, 11)
                .addComponent(colorDetection)
                .addGap(18, 18, 18)
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImageActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
            imagePath = fc.getSelectedFile().getAbsolutePath();
            imageLabel.setIcon(new ImageIcon(imagePath));
        }
    }//GEN-LAST:event_chooseImageActionPerformed

    private void colorDetectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDetectionActionPerformed
        try {
            // TODO add your handling code here:
            BufferedImage image;
            image = ImageIO.read(new File(imagePath));
            int width = image.getWidth();
            int height = image.getHeight();

            ArrayList<ColorRecurrence> colorReccurenceList = new ArrayList<ColorRecurrence>();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color color = new Color(image.getRGB(j, i));
                    ArrayList<ColorDistance> distanceList = new ArrayList();
                    for (ColorObject obj : ColorList.getList()) {
                        int rgbDistancce = Math.abs(color.getRed() - obj.getRed())
                                + Math.abs(color.getGreen() - obj.getGreen())
                                + Math.abs(color.getBlue() - obj.getBlue());
                        distanceList.add(new ColorDistance(rgbDistancce, obj.getName()));
                    }
                    Collections.sort(distanceList);
                    boolean found = false;
                    for (ColorRecurrence c : colorReccurenceList) {
                        if (distanceList.get(0).getName().equalsIgnoreCase(c.getColor())) {
                            c.setRecurrence(c.getRecurrence() + 1);
                            found = true;
                        }
                    }
                    if (found == false) {
                        colorReccurenceList.add(new ColorRecurrence(1, distanceList.get(0).getName()));
                    }
                }
            }
            int totalPixel = width * height;
            String result = "";
            for (ColorRecurrence obj : colorReccurenceList) {
                int r = obj.getRecurrence();
                float rec = (r / (float)totalPixel * 100);
                result += obj.getColor() + ": " + new DecimalFormat("##.##").format(rec) + "%\n";
            }
            new ColorDetection(result).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_colorDetectionActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseImage;
    private javax.swing.JButton colorDetection;
    private javax.swing.JLabel imageLabel;
    // End of variables declaration//GEN-END:variables
}