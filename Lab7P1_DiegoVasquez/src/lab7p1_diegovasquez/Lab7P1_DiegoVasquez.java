/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_diegovasquez;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Diego Vasquez
 */
public class Lab7P1_DiegoVasquez {
    static Scanner lea = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir){
            System.out.println("=MENU=");
            System.out.println("1.SHE SHOOTS, SHE SCORES!");
            System.out.println("2.ROCK PAPER SCISSORS LIZZARD SPOCK!");
            System.out.println("3.salir");
            int opcion = lea.nextInt();
            switch(opcion){
                case 1:{
                    System.out.println("Ingrese numero de filas:");
                    int n = lea.nextInt();
                    System.out.println("Ingrese numero de columnas:");
                    int m = lea.nextInt();
                    while (n*m > 88 || n*m < 0 || m <= 1 || n <= 1){
                        System.out.println("Su tamaño es invalido ._. lo siento. \n Intentelo de nuevo:");
                        System.out.println("Ingrese numero de filas: ");
                        n = lea.nextInt();
                        System.out.println("Ingrese numero de columnas:");
                        m = lea.nextInt();
                    }//fin validacion
                    System.out.println("Ingrese numero de balas: ");
                    int balas = lea.nextInt();
                    while(balas < 0 || balas > n*m/2){
                        System.out.println("Cantidad invalida de balas \n Intentelo de nuevo:");
                        balas = lea.nextInt();
                    }
                    int bp1 = balas;
                    int acumP1 = 0;
                    int acumP2 = 0;
                    int bp2 = balas;
                    int[][] Matriz = new int[n][m];
                    Matriz = LecturaMatrizJuego(Matriz);
                    System.out.println("------TABLERO PARA JUGAR----------");
                    Print(Matriz);
                    for (int i = 0; i < balas; i++) {
                        System.out.println("TURNO DE JUGADOR 1!");
                        System.out.println("Elige que numero disparar Jugador 1:");
                        System.out.println("Le quedan: "+bp1+" balas.");
                        int Fshoot = lea.nextInt();
                        boolean ledio = ContainsMatrix(Matriz,Fshoot);
                        if(ledio){
                            //win state
                            System.out.println("Tiro Acertado!");
                            Matriz = NewMatrixP1(Matriz,Fshoot);
                            Print(Matriz);
                            acumP1 += Fshoot;
                            bp1--;
                        }else{
                            //loose state
                            System.out.println("!FALLO!");
                            bp1--;
                            Print(Matriz);
                        }//fin cosas del p1
                        System.out.println("TURNO DE JUGADOR 2!");
                        System.out.println("Le Quedan: "+bp2+" balas.");
                        System.out.println("Elige que numero disparar Jugador 2:");
                        int Sshoot = lea.nextInt();
                        boolean ledio2 = ContainsMatrix(Matriz,Sshoot);
                        if(ledio2){
                            //win state
                            System.out.println("!Tiro Acertado!");
                            Matriz = NewMatrixP2(Matriz,Sshoot);
                            Print(Matriz);
                            acumP2 += Sshoot;
                            bp2--;
                        }else{
                            //loose state
                            System.out.println("!FALLO!");
                            bp2--;
                            Print(Matriz);
                        }
                    }//fin for
                    if(acumP1>acumP2){
                        System.out.println("Jugador 1 gana con: "+acumP1);
                        System.out.println("Jugador 2 pierde con: "+acumP2);
                    }else{
                        System.out.println("Jugador 2 gana con: "+acumP2);
                        System.out.println("Jugador 1 gana con: "+acumP1);
                    }//fin winners
                }//fin case 1
                break;
                case 2:{
                    System.out.println("=PIEDRA PAPER O...=");
                    int[][] Matrix = new int[5][5];
                    Matrix = LecturaMatrizRand(Matrix);
                    System.out.println("""
                                       =Elija Que Quiere Usar=
                                       1.Spock
                                       2.Lizard
                                       3.Rock
                                       4.Paper
                                       5.Scissor""");
                    int move = lea.nextInt();
                    int Fcords = RNG();
                    int Ccords = RNG();
                    int cpu_move = Matrix[Fcords][Ccords];
                    switch(cpu_move){
                        case 1:{
                            System.out.println("La Maquina Eligió Spock");
                        }
                        break;
                        case 2:{
                            System.out.println("La Maquina Eligió Lizard");
                        }
                        break;
                        case 3:{
                            System.out.println("La Maquina Eligió Rock");
                        }
                        break;
                        case 4:{
                            System.out.println("La Maquina Eligió Paper");
                        }
                        break;
                        case 5:{
                            System.out.println("La Maquina Eligió Scissor");
                        }
                        break;
                    }//fin cpu move
                    switch(move){
                        case 1:{
                            if(cpu_move == 2 || cpu_move == 4){
                                //loose state
                                System.out.println("!La Maquina Gana!");
                            }else if(cpu_move == 1){
                                System.out.println("!ES UN EMPATE!");
                            }else{
                                //win State
                                System.out.println("!El Jugador Gana!");
                            }//fin if
                        }//fin case 1
                        break;
                        case 2:{
                            if(cpu_move ==  3|| cpu_move == 5 ){
                                //loose state
                                System.out.println("!La Maquina Gana!");
                            }else if(cpu_move == 2){
                                System.out.println("!ES UN EMPATE!");
                            }else{
                                //win State
                                System.out.println("!El Jugador Gana!");
                            }//fin if
                        }
                        break;
                        case 3:{
                            if(cpu_move ==  4|| cpu_move == 2){
                                //loose state
                                System.out.println("!La Maquina Gana!");
                            }else if(cpu_move == 3){
                                System.out.println("!ES UN EMPATE!");
                            }else{
                                //win State
                                System.out.println("!El Jugador Gana!");
                            }//fin if
                        }
                        break;
                        case 4:{
                            if(cpu_move ==  5|| cpu_move == 2){
                                //loose state
                                System.out.println("!La Maquina Gana!");
                            }else if(cpu_move == 4){
                                System.out.println("!ES UN EMPATE!");
                            }else{
                                //win State
                                System.out.println("!El Jugador Gana!");
                            }//fin if
                        }
                        break;
                        case 5:{
                            if(cpu_move ==  1|| cpu_move == 3){
                                //loose state
                                System.out.println("!La Maquina Gana!");
                            }else if(cpu_move == 5){
                                System.out.println("!ES UN EMPATE!");
                            }else{
                                //win State
                                System.out.println("!El Jugador Gana!");
                            }//fin if
                        }
                        break;
                        default:{
                            System.out.println("Opcion invalida :(");
                        }
                    }//fin switch move
                }//fin case 2
                break;
                case 3:{
                    seguir = false;
                }
                break;
                default :{
                    System.out.println("Opcion Invalida");
                }
                break;
            }//fin switch
        }//fin while
        // TODO code application logic here
    }//fin main
    public static int RNG(){
        int out = ran.nextInt(5);
        return out;
    }
    public static int[][] LecturaMatrizJuego(int[][] mat){
        int f = mat.length;
        int c = mat[0].length;
        int[][] temporal = new int [f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                int num = 1+ran.nextInt(f*c);
                boolean valid = true;
                while (valid){
                    boolean there = ContainsMatrix(temporal,num);
                    if(there){
                        num = 1+ran.nextInt(f*c);
                    }else{
                       temporal[i][j]=num;
                       valid = false; 
                    }//fin if
                }//fin while validation
            }//fin interno
        }//fin externo
        return temporal;
    }
    public static boolean ContainsMatrix(int[][]matt, int num){
        boolean esta = false;
        int filas = matt.length;
        int columnas = matt[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(matt[i][j]==num){
                    esta = true; 
                }//fin if
            }//fin j
        }//fin i
        return esta;
    }
    public static int[][] NewMatrixP1(int[][]mat, int num){
        int f = mat.length;
        int c = mat[0].length;
        int [][] nuova = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j]==num){
                    nuova[i][j]=99;
                }else{
                    nuova[i][j]=mat[i][j];
                }
            }//fin for j
        }//fin for i
        return nuova;
    }
    public static int[][] NewMatrixP2(int[][]mat,int num){
        int f = mat.length;
        int c = mat[0].length;
        int [][] nuova = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j]==num){
                    nuova[i][j]=88;
                }else{
                    nuova[i][j]=mat[i][j];
                }
            }//fin for j
        }//fin for i
        return nuova; 
    }
    public static int[][] LecturaMatrizRand(int[][] mat){
        int f = mat.length;
        int c = mat[0].length;
        int[][] temporal = new int [f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                temporal[i][j]= 1+ran.nextInt(6);
            }//fin interno
        }//fin externo
        return temporal;  
    }//end read
    public static void Print(int[][]mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("["+(mat[i][j])+"]"+"\t"); 
            }//fin columns
            System.out.println("");
        }//fin filas5
    }
 
}
