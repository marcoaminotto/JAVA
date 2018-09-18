/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto3d;

public class Ponto {
    double x, y, z;   
    
    public void Ponto(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    
    //recebe a linha, separa em partes e atribui aos valores
    public void setValores(String vetor){
        String[] parte = new String[4];
        parte = vetor.split(" ");
        this.x = Double.parseDouble(parte[1]);
        this.y = Double.parseDouble(parte[2]);
        this.z = Double.parseDouble(parte[3]);
    }
}
