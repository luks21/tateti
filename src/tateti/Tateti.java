/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tateti;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Tateti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner num = new Scanner(System.in);
        String turno = "X", a = "0";
        int ganador=0,jugadas=0,b=0,posic;     
        String posicSt;
        String tablero[][]= new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b++;
                a=String.valueOf(b);
                tablero[i][j]=a;
            }
        }//muestra tablero para empezar a jugar
        for (int i = 0; i < 3; i++) {
                System.out.println(" ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(" "+tablero[i][j]+" ");
                }
        }
        do{
            do {          
            System.out.println("");
            System.out.println("TURNO DEL JUGADOR "+turno+" ELIGE UNA POSICIÓN DEL TABLERO");
            posicSt=num.nextLine();
            }while(!IsInteger(posicSt)); //Se sigue pidiendo la entrada si no es entero
                posic = Integer.parseInt(posicSt); //Ahora si se parsea a entero
            
            
            
            
            
            if(posic==0||posic==1||posic==2||posic==3||posic==4||posic==5||posic==6||posic==7||posic==8||posic==9){
            //pone ficha y controla que no este ocupado el lugar
            if (posic<4 && posic>0) {
                if (tablero[0][posic-1]!="X"&& tablero[0][posic-1]!="O") {
                tablero[0][posic-1]=turno;  
                }else{
                    System.out.println("OCUPADO");
                    if (turno=="X") {
                      turno="O";
                    }else{
                    turno="X";
                    }
                }
            }
            if (posic<7&& posic>3) {
                if (tablero[1][posic-4]!="X"&& tablero[1][posic-4]!="O") {
                tablero[1][posic-4]=turno;
                }else{
                    System.out.println("OCUPADO");
                    if (turno=="X") {
                    turno="O";
                }else{
                    turno="X";
                }
                }
            }else if(posic<10&& posic>6){
                if (tablero[2][posic-7]!="X"&& tablero[2][posic-7]!="O") {
                tablero[2][posic-7]=turno;
                }else{
                    System.out.println("OCUPADO");
                    if (turno=="X") {
                    turno="O";
                }else{
                    turno="X";
                }
                }
            } //muestra tablero
            for (int i = 0; i < 3; i++) {
                System.out.println(" ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(" "+tablero[i][j]+" ");
                }
            }
            System.out.println("");
            //compara 3 horizontales
            if (tablero[0][0]==tablero[0][1]&&tablero[0][1]==tablero[0][2]) {
                ganador=1;
            }
            if (tablero[1][0]==tablero[1][1]&&tablero[1][1]==tablero[1][2]) {
                ganador=1;
            }
            if (tablero[2][0]==tablero[2][1]&&tablero[2][1]==tablero[2][2]) {
                ganador=1;
            }
            //compara 2 diagonales
            if (tablero[0][0]==tablero[1][1]&&tablero[1][1]==tablero[2][2]) {
                ganador=1;
            }
            if (tablero[0][2]==tablero[1][1]&&tablero[1][1]==tablero[2][0]) {
                ganador=1;
            }//compara 3 verticales
            if (tablero[0][0]==tablero[1][0]&&tablero[1][0]==tablero[2][0]) {
                ganador=1;
            }
            if (tablero[0][1]==tablero[1][1]&&tablero[1][1]==tablero[2][1]) {
                ganador=1;
            }
            if (tablero[0][2]==tablero[1][2]&&tablero[1][2]==tablero[2][2]) {
                ganador=1;
            }
            if(ganador==0){
            if (turno=="X") {
                turno="O";
            }else{
                turno="X";
            }
            }
            
        }else{
                System.out.println("INGRESE UN NÚMERO DEL TABLERO");
            }
        }while(ganador==0);
        System.out.println("GANADOR JUGADOR "+turno);
    }

public static boolean IsInteger(String text) {
    int v;
    try {
      v=Integer.parseInt(text);
      return true;
    } catch (NumberFormatException ex) {
       return false;
    }
}
}