/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto3d;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcoechevestre
 */

public class Projeto3D {
    List<String> vertices = new ArrayList<String>();
    List<String> faces = new ArrayList<String>();
    List<Vet4> matrizVertices = new ArrayList<Vet4>();
    
    
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
    
    /*public void receberFaces(){
        float f1, f2, f3;
        String parteV[];
        //Adicioando os vertices lidos, a uma matriz de Vet4
        for(int i=0; i < vertices.size(); i++){
            parteV = (vertices.get(i)).split(" ");
            f1 = Float.parseFloat(parteV[1]);
            f2 = Float.parseFloat(parteV[2]);
            f3 = Float.parseFloat(parteV[3]);
            Vet4 p = new Vet4(x, y, z, 1); // w = 1
            matrizVertices.add(p);
        }
    }*/
    
    public static void main(String[] args) {
        Projeto3D prj = new Projeto3D();
        prj.lerArquivo();
        prj.receberVertices();
        
    }
    
}
