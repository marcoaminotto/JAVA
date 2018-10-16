/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marcoechevestre
 */
public class Projeto3D extends javax.swing.JFrame implements Runnable{

    private boolean setaUp;
    private boolean setaDown;
    private boolean setaRight;
    private boolean setaLeft;

    List<String> vertices = new ArrayList<String>();
    List<String> faces = new ArrayList<String>();
    List<Vet4> matrizVertices = new ArrayList<Vet4>();
    /**
     * Creates new form Projeto3D
     */
    public Projeto3D() {
        initComponents();
        
        
        createBufferStrategy(2);//permite que um desenho seja feito em um buffer e depois em outro. Tendo uma melhor qualidade
        
        
        Thread t = new Thread(this);
        t.start(); //executa o metodo run()
    }
    
    
    //------------------------Meus metodos------------------------------------
    
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
            Vet4 p = new Vet4(x, y, z, 1);
            //System.out.println("teste: "+ round(p.getX()*100) + "," + round(p.getY()*100)+","+round(p.getZ()*100));
            matrizVertices.add(p);
        }
    }
    
    /*
    public void rotacao(){
        float sx, sy;
        float angulo;
        System.out.println("Informe o angulo: ");
        angulo = scanner.nextFloat();
        for(int i = 0; i < matrizTranformacao.size(); i++){
         Ponto r = new Ponto();
         Ponto p = matrizTranformacao.get(i);
         r.x = (float) (p.x * Math.cos(angulo) - p.y * Math.sin(angulo));
         r.y = (float) (p.x * Math.cos(angulo) + p.y * Math.sin(angulo));
         matrizTranformacao.set(i, r);
        }
    }
    
    public void escala(){
        float sx, sy;
        System.out.println("Informe o Sx e o Sy: ");
        sx = scanner.nextFloat();
        sy = scanner.nextFloat();
        for(int i = 0; i < matrizTranformacao.size(); i++){
         Ponto r = new Ponto();
         Ponto p = matrizTranformacao.get(i);
         r.x = p.x * sx;
         r.y = p.y * sy;
         matrizTranformacao.set(i, r);
        }
    }
    */
    //--------------------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_UP){
            //ADICIONAR O DE TRANSLACAO
            setaUp = true;
        }
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            setaDown = true;
        }
        else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
            //ADICIONAR O DE TRANSLACAO
            setaRight = true;
        }
        else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
            setaLeft = true;
        }
        
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        
        if(evt.getKeyCode() == KeyEvent.VK_UP){
            setaUp = false;
        }
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            setaDown = false;
        }else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
            setaRight = false;
        }else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
            setaLeft = false;
        }
        
    }//GEN-LAST:event_formKeyReleased

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

    @Override
    public void run() {
        Graphics g;
        lerArquivo();
        receberVertices();
        
        int f1, f2, f3;
        int x = 500;
        int y = 500;
        //Adicioando os vertices lidos, a uma matriz de Vet4
        
        
        /*for(int i=0; i < faces.size(); i++){
            parteF = (faces.get(0)).split(" ");
            f1 = Integer.parseInt(parteF[1]);
            f2 = Integer.parseInt(parteF[2]);
            f3 = Integer.parseInt(parteF[3]);
            
            Vet4 p1 = matrizVertices.get(f1);
            Vet4 p2 = matrizVertices.get(f2);
            Vet4 p3 = matrizVertices.get(f3);

            g.drawLine(round(p1.x*100), round(p1.y*100), round(p2.x*100), round(p2.y*100));
            g.drawLine(round(p2.x*100), round(p2.y*100), round(p3.x*100), round(p3.y*100));
            g.drawLine(round(p3.x*100), round(p3.y*100), round(p1.x*100), round(p1.y*100));
            System.out.println("ENTRO");
        }*/
        
        while(true){
            
            g = getBufferStrategy().getDrawGraphics();//primeiro passa para o buffer e depois para a placa de video     
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight()); //pintamos um retangulo branco que vai da posição (0,0) até a posição (800,800), preenchendo toda a imagem
           
            g.setColor(Color.BLACK);
           //TRANSLACAO DO OBJETO, adicionando os tx,ty,tz
            if(setaUp){
                for(int i=0; i < matrizVertices.size(); i++){
                    Vet4 v;
                    v = matrizVertices.get(i);
                    v.setTy(-1);
                    matrizVertices.set(i, v);
                } 
            }else if(setaDown){ 
                for(int i=0; i < matrizVertices.size(); i++){
                    Vet4 v;
                    v = matrizVertices.get(i);
                    v.setTy(1);
                    matrizVertices.set(i, v);
                } 
            }else{
                for(int i=0; i < matrizVertices.size(); i++){
                    Vet4 v;
                    v = matrizVertices.get(i);
                    v.setTy(0);
                    matrizVertices.set(i, v);
                } 
            }
            
            if(setaRight){
                for(int i=0; i < matrizVertices.size(); i++){
                    Vet4 v;
                    v = matrizVertices.get(i);
                    v.setTx(1);
                    matrizVertices.set(i, v);
                }
            }else if(setaLeft){
                for(int i=0; i < matrizVertices.size(); i++){
                    Vet4 v;
                    v = matrizVertices.get(i);
                    v.setTx(-1);
                    matrizVertices.set(i, v);
                } 
            }else{
                for(int i=0; i < matrizVertices.size(); i++){
                    Vet4 v;
                    v = matrizVertices.get(i);
                    v.setTx(0);
                    matrizVertices.set(i, v);
                } 
            }
            //execucao do metodo de translacao
            for(int i=0; i < matrizVertices.size(); i++){
                Vet4 v;
                v = matrizVertices.get(i);
                v.translacao();
                matrizVertices.set(i, v);
            }
            //desenhar
            //System.out.println(faces.size());
            for(int i=0; i < 1604; i++){
                String parteF[];
                parteF = (faces.get(i)).split(" ");
                f1 = Integer.parseInt(parteF[1]);
                f2 = Integer.parseInt(parteF[2]);
                f3 = Integer.parseInt(parteF[3]);
            
                Vet4 p1 = matrizVertices.get(f1);
                Vet4 p2 = matrizVertices.get(f2);
                Vet4 p3 = matrizVertices.get(f3);

                g.drawLine(round(p1.getX()*500), round(p1.getY()*500), round(p2.getX()*500), round(p2.getY()*500));
                g.drawLine(round(p2.getX()*500), round(p2.getY()*500), round(p3.getX()*500), round(p3.getY()*500));
                g.drawLine(round(p3.getX()*500), round(p3.getY()*500), round(p1.getX()*500), round(p1.getY()*500));
            }
            
            g.dispose();
            getBufferStrategy().show();
            
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){
            
             }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
