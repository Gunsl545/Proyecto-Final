import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sh = new Scanner(System.in);
    int jugada = 1;

    //Menu de inicio
    System.out.println("Ajedrez - variante Extinción");
    System.out.println("(1)Desea jugar? \n(2)Desea conocer las reglas? \n(3)Desea un boing de guayaba?");
    int resp = sh.nextInt();

    //Opciones de respuesta
    //Jugar
    if(resp == 1){
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
        }
        
        jugada += 1;
      }while(jugada <= 8);

    }


    // Reglas
    else if(resp ==2){
      System.out.println("Ahorita las pongo");
    } 

    //Boing
    else{System.out.println("Eric, si elegiste esta opcion, me debes un boing c:");}

    
    //Tablero nuevo = new Tablero();
    //nuevo.NuevoTablero();
    //nuevo.ImprimirTablero();
  }
}