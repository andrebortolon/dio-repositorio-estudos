package com.dio.metodos;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodosExercicio1 {
    public static void main(String[] args) {
        int opcao = 0;
        while (true) {
            try {
                System.out.println();
                imprimirSaudacao();
                imprimirMenuInicial();
                Scanner scanner = new Scanner(System.in);
                opcao = scanner.nextInt();
            } catch (InputMismatchException ime) {
                opcao = 0;
            }
            switch (opcao) {
                case 1 : resolverOperacoesBasicas(); break;
                case 2 : resolverValorEmprestimo(); break;
                case 3 : resolverAreaQuadrilatero(); break;
                default: return;
            }
        }
    }

    private static void resolverAreaQuadrilatero() {
        try {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o tamanho da base: ");
            float base = scanner.nextFloat();
            System.out.print("Digite o tamanho da lateral esquerda: ");
            float latEsquerda = scanner.nextFloat();
            System.out.print("Digite o tamanho da lateral direita: ");
            float latDireita = scanner.nextFloat();
            System.out.print("Digite o tamanho do topo: ");
            float topo = scanner.nextFloat();
            float area;
            if (base == topo && latEsquerda == latDireita && base == latEsquerda) {
                area = Quadrilatero.retorneArea(base);
            } else if (base == topo && latEsquerda == latDireita) {
                area = Quadrilatero.retorneArea(base, latEsquerda);
            } else {
                area = Quadrilatero.retorneArea(base, topo, latEsquerda, latDireita);
            }
            System.out.printf("Área do quadrilátero: %f%n", area);
            System.out.println();


        } catch (InputMismatchException ime) {
            return;
        }
    }

    private static void resolverValorEmprestimo() {
        try {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o valor emprestado: ");
            float valorInicial = scanner.nextFloat();
            System.out.print("Digite a taxa de juros (em %): ");
            float taxa = scanner.nextFloat();
            System.out.print("Digite o número de meses: ");
            int periodo = scanner.nextInt();
            double valorFinal = valorInicial * Math.pow(1 + taxa / 100, periodo);
            System.out.printf("Valor futuro: R$ %.2f%n", valorFinal);
            System.out.println();
        } catch (InputMismatchException ime) {
            return;
        }
    }

    private static void resolverOperacoesBasicas() {
        try {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o primeiro valor: ");
            int valor1 = scanner.nextInt();
            System.out.print("Digite o segundo valor: ");
            int valor2 = scanner.nextInt();
            System.out.println("Resultados:");
            System.out.printf("Soma: %d + %d = %d%n", valor1, valor2, valor1 + valor2);
            System.out.printf("Subtração: %d - %d = %d%n", valor1, valor2, valor1 - valor2);
            System.out.printf("Multiplicação: %d * %d = %d%n", valor1, valor2, valor1 * valor2);
            System.out.printf("Divisão: %d / %d = %f%n", valor1, valor2, (float) valor1 / valor2);
            System.out.println();
        } catch (InputMismatchException ime) {
            return;
        }
    }

    private static void imprimirMenuInicial() {
        System.out.println();
        System.out.println("Digite 1 para operações básicas.");
        System.out.println("Digite 2 para cálculo do empréstimo.");
        System.out.println("Digite 3 para cálculo do quadrilátero.");
        System.out.println("Digite outro valor para sair.");
        System.out.print("Digite sua opção: ");
    }

    private static void imprimirSaudacao() {
        int hora = LocalTime.now().getHour();
        if (hora >= 18) {
            System.out.println("Boa noite!");
            return;
        } else if (hora >= 12) {
            System.out.println("Boa tarde!");
            return;
        } else if (hora >= 6) {
            System.out.println("Bom dia!");
            return;
        } else {
            System.out.println("Boa noite!");
            return;
        }
    }
}