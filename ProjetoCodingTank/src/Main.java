import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int funcionario = 0;
        double[] salariosBrutos = new double[5];
        double salarioBruto,salarioLiquido, descontoInss, descontoImpostoDeRenda, descontoTotal;
        do{
            System.out.println("Insira o salário bruto do funcionário " + (funcionario + 1) + ":");
            salariosBrutos[funcionario] = sc.nextDouble();
            funcionario++;
        } while (funcionario < 5);
        sc.close();
        for(int i = 0; i < 5; i++){
            salarioBruto = salariosBrutos[i];
            descontoInss = calcularInss(salarioBruto);
            descontoImpostoDeRenda = calcularImpostoDeRenda(salarioBruto - descontoInss);
            descontoTotal = descontoInss + descontoImpostoDeRenda;
            salarioLiquido = salarioBruto - descontoTotal;
            System.out.printf("\nInformações do funcionário %d:\n", (i + 1));
            System.out.printf("Salário bruto: R$ %.2f\n", salarioBruto);
            System.out.printf("Desconto INSS: R$ %.2f\n", descontoInss);
            System.out.printf("Desconto Imposto de Renda: R$ %.2f\n", descontoImpostoDeRenda);
            System.out.printf("Salário líquido: R$ %.2f\n", salarioLiquido);
        }
    }

    private static double calcularInss(double salarioBruto){
        double desconto = 0.0;
        if(salarioBruto <= 1212.00) {
            desconto = salarioBruto * (7.5/100f);
        } else if ( 1212.00 < salarioBruto  && salarioBruto <=2427.35) {
            desconto = salarioBruto * (9/100f);
        } else if (2427.35 < salarioBruto  && salarioBruto <= 3641.03) {
            desconto = salarioBruto * (12/100f);
        } else if (3641.03 < salarioBruto  && salarioBruto <= 7087.22) {
            desconto = salarioBruto * (14/100f);
        }  else if (7087.22 < salarioBruto) {
            desconto = salarioBruto * (14/100f);
        }

        return desconto;
    }

    private static double calcularImpostoDeRenda(double salarioBruto){
        double desconto = 0.0;
        if(salarioBruto <=  1903.98) {
            desconto = salarioBruto * (0/100f);
        } else if ( 1903.98 < salarioBruto  && salarioBruto <= 2826.65) {
            desconto = (salarioBruto - 1903.98) * (7.5/100f);
        } else if (2826.65 < salarioBruto  && salarioBruto <= 3751.05) {
            desconto = (2826.65 - 1903.98) * (7.5/100f) + (salarioBruto - 2826.65)  * (15/100f);
        } else if (3751.05 < salarioBruto  && salarioBruto <= 4664.68) {
            desconto = (2826.65 - 1903.98) * (7.5/100f) + (3751.05 - 2826.65)  * (15/100f) + (salarioBruto - 3751.05) * (22.5/100f);
        } else if (4664.68 < salarioBruto) {
            desconto = (2826.65 - 1903.98) * (7.5/100f) + (3751.05 - 2826.65)  * (15/100f) + (4664.68 - 3751.05) * (22.5/100f) + (salarioBruto - 4664.68)  * (27.5/100f);
        }

        return desconto;
    }
}