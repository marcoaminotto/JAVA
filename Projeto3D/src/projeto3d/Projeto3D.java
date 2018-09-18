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
        lerArquivo();
        int tamanhoV = vertices.size();
        Ponto[] ponto = new Ponto[tamanhoV];
        
        //passa as linhas para a classe ponto para receber o valor de cada ponto
        for(int i=0; i < tamanhoV; i++){
            ponto[i].setValores(vertices.get(i));
        }
    }
    
    public static void main(String[] args) {
        
        
    }
    
}
