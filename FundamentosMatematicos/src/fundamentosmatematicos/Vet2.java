
package fundamentosmatematicos;

public class Vet2 {
    float x, y;
    
    public Vet2(){
        x = 0;
        y = 0;
    }
    
    public Vet2(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public double tamanhoVet2(Vet2 a, Vet2 b){
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(a.y - b.y, 2));
    }
    
    public double normalizacao(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
    
    public Vet2 adicao(Vet2 b){
         Vet2 vetor = new Vet2();
         vetor.x = this.x + b.x;
         vetor.y = this.y + b.y;
         return vetor;
    }
    
    public Vet2 subtracao(Vet2 b){
         Vet2 vetor = new Vet2();
         vetor.x = b.x - this.x;
         vetor.y = b.y - this.y;
         return vetor;
    }
    
    public Vet2 multiplicador(float n){
        Vet2 vetor = new Vet2();
        vetor.x = this.x * n;
        vetor.y = this.y * n;
        return vetor; 
    }
    
    public Vet2 divisao(float n){
        Vet2 vetor = new Vet2();
        vetor.x = this.x / n;
        vetor.y = this.y / n;
        return vetor; 
    }
    
    public double produtoEscalar(Vet2 b){
        Vet2 vetor = new Vet2();
        return Math.pow(this.x * b.x, 2) + Math.pow(this.y * b.y, 2);
    }
    
    public Vet3 novaCopia(){
        Vet3 vetor = new Vet3();
        vetor.x = this.x;
        vetor.y = this.y;
        return vetor;
    }
    
    public float[] retornarArray(){
        float[] array = new float[2];
        array[0] = this.x;
        array[1] = this.y;
        return array;
    }
    
}