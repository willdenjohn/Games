package games;
public class Peca {
    public String nome;
    public String cor;
    
    public Peca getPeça() {
        return this;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Peca(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }
    
    
}    