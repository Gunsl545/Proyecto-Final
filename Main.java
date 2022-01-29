import java.util.Scanner;
import java.util.InputMismatchException;

class Main {
  public static void main(String[] args) {
    Scanner sh = new Scanner(System.in);
    int jugada = 1, num;

    System.out.println("Ajedrez - variante Extinción");
    System.out.println("(1)Desea jugar? \n(2)Desea conocer las reglas? \n(3)Desea un boing de guayaba?");

    try{
      do{
      System.out.println("Que opción desea elegir");
      num = sh.nextInt();
      } while(num < 1 || num > 3);

      if(num == 1){
      System.out.println();
      System.out.println("Partida 1 vs 1 \nInicio:");
      System.out.println();
      Tablero partida = new Tablero();
      partida.NuevoTablero();
      partida.ImprimirTablero();


      do{
        if(jugada % 2!=0){
          System.out.println("Tirada Primer Jugador");
          partida.Movimiento();
          partida.ImprimirTablero();
        }
        else{
          System.out.println("Tirada Segundo Jugador");
          partida.Movimiento1();
          partida.ImprimirTablero();
        }
        
        jugada += 1;
      }while(partida.Contador() == true);

    } else if(num == 2){
      System.out.println("\nEl tablero consiste de 8 filas y 8 columnas, de forma horizontal tenemos las letras desde a hasta 8, \nde abajo hacia arriba tenemos del 1 al 8");
      System.out.println("\nEl juego le solicitara al jugador 1 que mueva una pieza, pidiendole primero la letra donde se encuentra la pieza a mover, y posteriormente el número, para repetir este proceso con el lugar a donde se desea mover la pieza.\n\nToma en consideración lo siguiente, \n1.-El jugador uno siempre tendra las piezas inferiores \n2.-En caso de equivocarte al escribir las posiciones, se te pedira ingresarlas de nuevo");
    } else{System.out.println("Eric, si elegiste esta opción, me debes un boing c:");}
    }
    catch(InputMismatchException ime){
      System.out.println("Opción no valida, vuelva a tipear: ");
    }
    

    
    //Opciones de respuesta
    //Jugar
    


    

    
    //Tablero nuevo = new Tablero();
    //nuevo.NuevoTablero();
    //nuevo.ImprimirTablero();
  }
}