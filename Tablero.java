import java.util.Scanner;

public class Tablero{
  //Atributos
  String[][] table = new String[6][6];
  //Métodos

  //Creación del tablero
  public void NuevoTablero(){

    //String[][] Medio =new String[1][2];
    //Medio =

    for(int i=2; i<4;i++){
      for(int j=0;j<6;j++){
        table[i][j] = "--";
      }
    }
    for(int i=0;i<6;i++){
      table[1][i]="p_";
      table[4][i]="p-";
    }
    table[0][0]="t_";
    table[0][5]="t_";
    table[5][5]="t-";
    table[5][0]="t-";
    table[0][1]="c_";
    table[0][4]="c_";
    table[5][1]="c-";
    table[5][4]="c-";
    table[0][2]="Q_";
    table[0][3]="K_";
    table[5][2]="Q-";
    table[5][3]="K-";
    
  }

  //Se imprime el tablero en pantalla
  public void ImprimirTablero(){
    for(int i=0;i<6;i++){
      for(int j=0;j<6;j++){
        System.out.print(table[i][j]+" ");
      }
      System.out.println();
    }
  }

  //girar tablero

  public void GirarTablero(){
    String[][] k1 = new String[0][5];
    for(int i=0;i<3;i++){
      table[0][i] = k1[0][1];
    }
  }

  //Mover piezas
  public void Movimiento(){
    Scanner sh = new Scanner(System.in);
    Scanner sh1 = new Scanner(System.in);
    int Temporal1 =0, Temporal2 =0;
    String Temporal3 = "s";

    //Se le pide al usuario la pieza a mover
    System.out.println("Que pieza desea mover?");
    System.out.println("En que letra se encuentra la pieza?");
    String Letra1 = sh.nextLine();
    System.out.println("En que número se encuentra la pieza?");
    int Numero1 = sh.nextInt();
    System.out.println("En que letra quieres mover la pieza?");
    String Letra2 = sh1.nextLine();
    System.out.println("En que número quieres mover la pieza?");
    int Numero2 = sh.nextInt();
    
    //Convertimos las cordenadas dadas a las posiciones de la matriz
    
    if(Letra1.equals("a")){
      Temporal1 = 0;
    } 
    else if(Letra1.equals("b")){
      Temporal1 = 1;
    }
    else if(Letra1.equals("c")){
      Temporal1 = 2;
    }
    else if(Letra1.equals("d")){
      Temporal1 = 3;
    }
    else if(Letra1.equals("e")){
      Temporal1 = 4;
    }
    else if(Letra1.equals("f")){
      Temporal1 = 5;
    }

    if(Letra2.equals("a")){
      Temporal2 = 1;
    } 
    else if(Letra2.equals("b")){
      Temporal2 = 1;
    }
    else if(Letra2.equals("c")){
      Temporal2 = 2;
    }
    else if(Letra2.equals("d")){
      Temporal2 = 3;
    }
    else if(Letra2.equals("e")){
      Temporal2 = 4;
    }
    else if(Letra2.equals("f")){
      Temporal2 = 5;
    }

    if(table[-(Numero1)+6][Temporal1] == "p-"){

      if((Numero2 == Numero1 + 2 || Numero2 == Numero1 + 1) & Temporal2 == Temporal1 & table[-(Numero2)+6][Temporal2] == "--"){
        Temporal3 = "--";
        table[-(Numero2)+ 6][Temporal2] = "p-";
        table[-(Numero1) + 6][Temporal1] = Temporal3;
      }
      else if((Temporal2 == Temporal1 +1 || Temporal2 == Temporal1 -1) & Numero2 == Numero1 + 1 & table[-(Numero2)+6][Temporal2] != "--"){
        System.out.println();
        table[-(Numero2)+6][Temporal2] = "p-";
      }
    }
    
    
    
  }
}