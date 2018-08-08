package fundamentosmatematicos;

public class Vet4 {
    float x, y, z, w;
    
    public Vet4(){
        x = 0;
        y = 0;
        z = 0;
        w = 0;
    }
    public Vet4(float x, float y, float z, float w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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
