/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto3d;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author marcoechevestre
 */

public class Projeto3D extends javax.swing.JFrame {
    List<String> vertices = new ArrayList<String>();
    List<String> faces = new ArrayList<String>();
    List<Vet4> matrizVertices = new ArrayList<Vet4>();
    
    public Projeto3D(){
        int f1, f2, f3;
        //cria uma imagem RGB de 800x800
        BufferedImage buffer = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        //extrai o objeto Graphics2D dela, pois é através dele que desenhamos
        Graphics2D g = buffer.createGraphics();
        
        //setamos a cor atual do "pincel" como branco
        g.setColor(Color.WHITE);
        //pintamos um retangulo branco que vai da posição (0,0) até a posição (800,800), preenchendo toda a imagem
        g.fillRect(0, 0, 800, 800);
        
        //setamos a cor atual do "pincel" como preto
        g.setColor(Color.black);
        //desenhamos uma linha que vai do ponto P1 (25,15) até o ponto P2 (300,250)
        g.drawLine(25, 15, 300, 250);
        
        //colocamos a imagem do buffer no jLabel da interface gráfica
        jLabel1.setIcon(new ImageIcon(buffer));
        
        String parteF[];
        //Adicioando os vertices lidos, a uma matriz de Vet4
        for(int i=0; i < faces.size(); i++){
            parteF = (faces.get(i)).split(" ");
            f1 = Integer.parseInt(parteF[1]);
            f2 = Integer.parseInt(parteF[2]);
            f3 = Integer.parseInt(parteF[3]);
            
            Vet4 p1 = matrizVertices.get(f1);
            Vet4 p2 = matrizVertices.get(f1);
            Vet4 p3 = matrizVertices.get(f1);

            g.drawLine(round(p1.x), round(p1.y), round(p2.x), round(p2.y));
            g.drawLine(round(p2.x), round(p2.y), round(p3.x), round(p3.y));
            g.drawLine(round(p3.x), round(p3.y), round(p1.x), round(p1.y));
        }
    
    }
    public void lerArquivo(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("LowPolyMill.txt"));
            String linha = input.readLine();
            while(linha != null){
                if(linha.contains("v")){
                    vertices.add(linha);
                    System.out.println(linha);
                }
                else if(linha.contains("f")){
                    faces.add(linha);
                    System.out.println(linha);
                }
                linha = input.readLine();
            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo de sistema não encontrado!");
        } catch (IOException ex) {
            System.out.println("Não foi possível abrir o arquivo do sistema");
        }
        
    }
    
    public void receberVertices(){
        float x, y, z;
        String parteV[];
        //Adicioando os vertices lidos, a uma matriz de Vet4
        for(int i=0; i < vertices.size(); i++){
            parteV = (vertices.get(i)).split(" ");
            x = Float.parseFloat(parteV[1]);
            y = Float.parseFloat(parteV[2]);
            z = Float.parseFloat(parteV[3]);
            Vet4 p = new Vet4(x, y, z, 1); // w = 1
            matrizVertices.add(p);
        }
    }
    
    public static void main(String[] args) {
        Projeto3D prj = new Projeto3D();
        prj.lerArquivo();
        prj.receberVertices();
        
        
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
            java.util.logging.Logger.getLogger(Projeto3D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Projeto3D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Projeto3D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Projeto3D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Projeto3D().setVisible(true);
            }
        });
        
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   

    
}
