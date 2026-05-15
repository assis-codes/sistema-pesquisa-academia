package desafio;

import java.util.Scanner;
import java.util.Locale;

public class programa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int idade = -1;
        char sexo;
        int objetivo;
        int tempo;

        int contadorT = 0;
        int contadorM = 0;
        int contadorF = 0;

        int menorID = 0;
        int maiorT = 0;

        int somaIdades = 0;
        double media = 0;
        double percentualFE = 0;

        int contG = 0;
        int contE = 0;
        int contR = 0;
        int contFE = 0;

        int contMenor18Mais12 = 0;

        while (idade != 0) {

            System.out.print("Digite a idade (0 para terminar): ");
            idade = sc.nextInt();

            if (idade != 0) {

                System.out.print("Qual seu sexo (M/F): ");
                sexo = sc.next().charAt(0);

                System.out.println("Qual seu objetivo: ");
                System.out.println("1 - Ganhar massa");
                System.out.println("2 - Emagrecer");
                System.out.println("3 - Resistência");
                objetivo = sc.nextInt();

                System.out.print("Há quanto tempo você treina? ");
                tempo = sc.nextInt();

                contadorT++;
                somaIdades += idade;

                if (contadorT == 1) {
                    menorID = idade;
                    maiorT = tempo;
                } else {
                    if (idade < menorID) {
                        menorID = idade;
                    }

                    if (tempo > maiorT) {
                        maiorT = tempo;
                    }
                }

                if (sexo == 'M' || sexo == 'm') {
                    contadorM++;
                } else if (sexo == 'F' || sexo == 'f') {
                    contadorF++;

                    if (objetivo == 2) {
                        contFE++;
                    }
                }

                if (objetivo == 1) {
                    contG++;
                } else if (objetivo == 2) {
                    contE++;
                } else if (objetivo == 3) {
                    contR++;
                }

                if (idade < 18 && tempo > 12) {
                    contMenor18Mais12++;
                }
            }
        }

        if (contadorT > 0) {

            media = (double) somaIdades / contadorT;

            System.out.println("\nTotal de pessoas: " + contadorT);

            if (contadorM > contadorF) {
                System.out.println("Sexo com mais participantes: Masculino");
            } else if (contadorF > contadorM) {
                System.out.println("Sexo com mais participantes: Feminino");
            } else {
                System.out.println("Empate entre masculino e feminino");
            }

            System.out.println("Menor idade informada: " + menorID);
            System.out.println("Maior tempo de treino: " + maiorT);
            System.out.println("Média de idades: " + media);

            if (contG > contE && contG > contR) {
                System.out.println("Objetivo mais escolhido: Ganhar massa");
            } else if (contE > contG && contE > contR) {
                System.out.println("Objetivo mais escolhido: Emagrecer");
            } else if (contR > contG && contR > contE) {
                System.out.println("Objetivo mais escolhido: Resistência");
            } else {
                System.out.println("Houve empate no objetivo mais escolhido");
            }

            if (contadorF > 0) {
                percentualFE = (double) contFE * 100 / contadorF;
                System.out.println("Percentual de mulheres que querem emagrecer: " + percentualFE + "%");
            } else {
                System.out.println("Percentual de mulheres que querem emagrecer: 0%");
            }

            System.out.println("Menores de 18 anos que treinam há mais de 12 meses: " + contMenor18Mais12);

        } else {
            System.out.println("Pesquisa sem dados!");
        }

        sc.close();
    }
}