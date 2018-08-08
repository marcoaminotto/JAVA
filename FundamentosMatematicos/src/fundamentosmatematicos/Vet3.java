package fundamentosmatematicos;

public class Vet3 {
    float x, y, z;
    
    public Vet3(){
        x = 0;
        y = 0;
        z = 0;
    }
    
    public Vet3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double tamanhoVet2(Vet3 a, Vet3 b){
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(b.z - a.z, 2));
    }
    
    public double normalizacao(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }
    
    public Vet3 adicao(Vet3 b){
         Vet3 vetor = new Vet3();
         vetor.x = this.x + b.x;
         vetor.y = this.y + b.y;
         vetor.z = this.z + b.z;
         return vetor;
    }
    
    public Vet3 subtracao(Vet3 b){
         Vet3 vetor = new Vet3();
         vetor.x = b.x - this.x;
         vetor.y = b.y - this.y;
         vetor.z = b.z - this.z;
         return vetor;
    }
    
    public Vet3 multiplicador(float n){
        Vet3 vetor = new Vet3();
        vetor.x = this.x * n;
        vetor.y = this.y * n;
        vetor.z = this.z * n;
        return vetor; 
    }
    
    public Vet3 divisao(float n){
        Vet3 vetor = new Vet3();
        vetor.x = this.x / n;
        vetor.y = this.y / n;
        vetor.z = this.z / n;
        return vetor; 
    }
    
    public double produtoEscalar(Vet3 b){
        Vet3 vetor = new Vet3();
        return Math.pow(this.x * b.x, 2) + Math.pow(this.y * b.y, 2) + Math.pow(this.z * b.z, 2);
    }
    
    public Vet3 novaCopia(){
        Vet3 vetor = new Vet3();
        vetor.x = this.x;
        vetor.y = this.y;
        vetor.z = this.z;
        return vetor;
    }
    
    public float[] retornarArray(){
        float[] array = new float[3];
        array[0] = this.x;
        array[1] = this.y;
        array[2] = this.z;
        return array;
    }
}
