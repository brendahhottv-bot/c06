package promocao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int matricula = 377;

        HardwareBasico[] hardwaresPromo1 = new HardwareBasico[3];
        hardwaresPromo1[0] = new HardwareBasico("Pentium Core i3", 2200);
        hardwaresPromo1[1] = new HardwareBasico("Memória RAM", 8);
        hardwaresPromo1[2] = new HardwareBasico("HD", 500);
        SistemaOperacional so1 = new SistemaOperacional("macOS Sequoia", 64);
        MemoriaUSB usb1 = new MemoriaUSB("Pen-drive", 16);
        float precoPromo1 = matricula;
        Computador promo1 = new Computador("Apple", precoPromo1, so1);
        for (HardwareBasico hb : hardwaresPromo1) {
            if (hb != null) {
                promo1.addHardwareBasico(hb);
            }
        }
        promo1.addMemoriaUSB(usb1);

        HardwareBasico[] hardwaresPromo2 = new HardwareBasico[3];
        hardwaresPromo2[0] = new HardwareBasico("Pentium Core i5", 3370);
        hardwaresPromo2[1] = new HardwareBasico("Memória RAM", 16);
        hardwaresPromo2[2] = new HardwareBasico("HD", 1000);
        SistemaOperacional so2 = new SistemaOperacional("Windows 8", 64);
        MemoriaUSB usb2 = new MemoriaUSB("Pen-drive", 32);
        float precoPromo2 = matricula + 1234;
        Computador promo2 = new Computador("Samsung", precoPromo2, so2);
        for (HardwareBasico hb : hardwaresPromo2) {
            if (hb != null) {
                promo2.addHardwareBasico(hb);
            }
        }
        promo2.addMemoriaUSB(usb2);

        HardwareBasico[] hardwaresPromo3 = new HardwareBasico[3];
        hardwaresPromo3[0] = new HardwareBasico("Pentium Core i7", 4500);
        hardwaresPromo3[1] = new HardwareBasico("Memória RAM", 32);
        hardwaresPromo3[2] = new HardwareBasico("HD", 2000);
        SistemaOperacional so3 = new SistemaOperacional("Windows 10", 64);
        MemoriaUSB usb3 = new MemoriaUSB("HD Externo", 1000);
        float precoPromo3 = matricula + 5678;
        Computador promo3 = new Computador("Dell", precoPromo3, so3);
        for (HardwareBasico hb : hardwaresPromo3) {
            if (hb != null) {
                promo3.addHardwareBasico(hb);
            }
        }
        promo3.addMemoriaUSB(usb3);

        Cliente cliente = new Cliente("Chris", "123.456.789-27");

        int codigoPromocao = -1;
        while (codigoPromocao != 0) {
            System.out.println("\n--- PROMOÇÕES PC Mania ---");
            System.out.println("1. Promoção Apple (R$" + String.format("%.2f", promo1.getPreco()) + ")");
            System.out.println("2. Promoção Samsung (R$" + String.format("%.2f", promo2.getPreco()) + ")");
            System.out.println("3. Promoção Dell (R$" + String.format("%.2f", promo3.getPreco()) + ")");
            System.out.println("0. Finalizar compra");
            System.out.print("Digite o código da promoção desejada (1, 2, 3) ou 0 para finalizar: ");
            codigoPromocao = entrada.nextInt();

            switch (codigoPromocao) {
                case 1:
                    cliente.addComputador(promo1);
                    System.out.println("Promoção Apple adicionada ao carrinho!");
                    break;
                case 2:
                    cliente.addComputador(promo2);
                    System.out.println("Promoção Samsung adicionada ao carrinho!");
                    break;
                case 3:
                    cliente.addComputador(promo3);
                    System.out.println("Promoção Dell adicionada ao carrinho!");
                    break;
                case 0:
                    System.out.println("Finalizando compra...");
                    break;
                default:
                    System.out.println("Código inválido. Tente novamente.");
            }
        }

        System.out.println("\n\n=============== NOTA FISCAL ===============");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("-------------------------------------------");

        for (int i = 0; i < cliente.getQtdComputadoresComprados(); i++) {
            Computador pc = cliente.getComputadores()[i];
            if (pc != null) {
                System.out.println("\nPC Adquirido #" + (i + 1) + " (Marca: " + pc.getMarca() + ")");
                pc.mostraPCConfigs();
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("TOTAL DA COMPRA: R$" + String.format("%.2f", cliente.calculaTotalCompra()));
        System.out.println("===========================================");

        entrada.close();
    }
}