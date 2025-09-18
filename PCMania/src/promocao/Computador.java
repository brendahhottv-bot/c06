package promocao;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardwareBasico;
    private int qtdHardwareBasico;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, SistemaOperacional so) {
        this.marca = marca;
        this.preco = preco;
        this.sistemaOperacional = so;
        this.hardwareBasico = new HardwareBasico[10];
        this.qtdHardwareBasico = 0;
        this.memoriaUSB = null;
    }

    public void addHardwareBasico(HardwareBasico hardware) {
        if (this.qtdHardwareBasico < this.hardwareBasico.length) {
            this.hardwareBasico[this.qtdHardwareBasico] = hardware;
            this.qtdHardwareBasico++;
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Preço: R$" + String.format("%.2f", this.preco));
        System.out.println("  Hardware Básico:");
        for (int i = 0; i < this.qtdHardwareBasico; i++) {
            if (this.hardwareBasico[i] != null) {
                if (hardwareBasico[i].getNome().toLowerCase().contains("processador")) {
                    System.out.println("    - Processador: " + this.hardwareBasico[i].getNome() + " (" + (int)this.hardwareBasico[i].getCapacidade() + " Mhz)");
                } else if (hardwareBasico[i].getNome().toLowerCase().contains("ram") || hardwareBasico[i].getNome().toLowerCase().contains("hd")) {
                    System.out.println("    - " + this.hardwareBasico[i].getNome() + ": " + (int)this.hardwareBasico[i].getCapacidade() + " Gb");
                } else {
                    System.out.println("    - " + this.hardwareBasico[i].getNome() + ": " + this.hardwareBasico[i].getCapacidade());
                }
            }
        }
        System.out.println("  Sistema Operacional: " + this.sistemaOperacional.getNome() + " (" + this.sistemaOperacional.getTipo() + " bits)");
        if (this.memoriaUSB != null) {
            System.out.println("  Acompanha Memória USB: " + this.memoriaUSB.getNome() + " de " + this.memoriaUSB.getCapacidade() + "Gb");
        }
    }

    public float getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }
}