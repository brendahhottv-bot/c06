import java.util.Scanner;
public class exercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int np1 = entrada.nextInt();
        int np2 = entrada.nextInt();
        int total = np1 + np2;
        double media = total/2;

        if(media>=60) {
            System.out.println("passou");
        }
        else{
            System.out.println(media);
            System.out.println(" ficou de np3");
        }
}}
