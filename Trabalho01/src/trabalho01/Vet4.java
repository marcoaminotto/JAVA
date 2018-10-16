/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author marcoechevestre
 */
public class Vet4 {
    private float x, y, z, w;
    private int tx = 1; 
    private int ty = 1; 
    private int tz = 1;
    
    public Vet4(){
        x = 0;
        y = 0;
        z = 0;
        w = 0;
    }

    public Vet4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public int getTx() {
        return tx;
    }

    public void setTx(int tx) {
        this.tx = tx;
    }

    public int getTy() {
        return ty;
    }

    public void setTy(int ty) {
        this.ty = ty;
    }

    public int getTz() {
        return tz;
    }

    public void setTz(int tz) {
        this.tz = tz;
    }
    
    
    public void translacao(){
        x = x + tx;
        y = y + ty;
        z = z + tz;
    }
    
    public double tamanhoVet2(Vet4 a, Vet4 b){
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2) + Math.pow(a.w - b.w, 2));
    }
    
    public double normalizacao(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2) + Math.pow(this.w, 2));
    }
    
    public Vet4 adicao(Vet4 b){
         Vet4 vetor = new Vet4();
         vetor.x = this.x + b.x;
         vetor.y = this.y + b.y;
         vetor.z = this.z + b.z;
         vetor.w = this.w + b.w;
         return vetor;
    }
    
    public Vet4 subtracao(Vet4 b){
         Vet4 vetor = new Vet4();
         vetor.x = b.x - this.x;
         vetor.y = b.y - this.y;
         vetor.z = b.z - this.z;
         vetor.w = b.w - this.w;
         return vetor;
    }
    
    public Vet4 multiplicador(float n){
        Vet4 vetor = new Vet4();
        vetor.x = this.x * n;
        vetor.y = this.y * n;
        vetor.z = this.z * n;
        vetor.w = this.w * n;
        return vetor; 
    }
    
    public Vet4 divisao(float n){
        Vet4 vetor = new Vet4();
        vetor.x = this.x / n;
        vetor.y = this.y / n;
        vetor.z = this.z / n;
        vetor.w = this.w / n;
        return vetor; 
    }
    
    public double produtoEscalar(Vet4 b){
        Vet4 vetor = new Vet4();
        return Math.pow(this.x * b.x, 2) + Math.pow(this.y * b.y, 2) + Math.pow(this.z * b.z, 2) + Math.pow(this.w * b.w, 2);
    }
    
    public Vet4 novaCopia(){
        Vet4 vetor = new Vet4();
        vetor.x = this.x;
        vetor.y = this.y;
        vetor.z = this.z;
        vetor.w = this.w;
        return vetor;
    }
    
    public float[] retornarArray(){
        float[] array = new float[3];
        array[0] = this.x;
        array[1] = this.y;
        array[2] = this.z;
        array[3] = this.w;
        return array;
    }
}
