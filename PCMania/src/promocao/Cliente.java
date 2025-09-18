package promocao;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int qtdComputadoresComprados;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[10];
        this.qtdComputadoresComprados = 0;
    }

    public void addComputador(Computador comp) {
        if (this.qtdComputadoresComprados < this.computadores.length) {
            this.computadores[this.qtdComputadoresComprados] = comp;
            this.qtdComputadoresComprados++;
        }
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < this.qtdComputadoresComprados; i++) {
            if (this.computadores[i] != null) {
                total += this.computadores[i].getPreco();
            }
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadores() {
        return computadores;
    }

    public int getQtdComputadoresComprados() {
        return qtdComputadoresComprados;
    }
}