import java.util.Scanner;
import java.util.InputMismatchException;

public class Tablero{
  //Atributos
  String[][] table = new String[8][8];
  //Métodos

  
  //Creación del tablero
  public void NuevoTablero(){

    for(int i=2; i<6;i++){
      for(int j=0;j<8;j++){
        table[i][j] = "--";
      }
    }
    for(int i=0;i<8;i++){
      table[1][i]="p_";
      table[6][i]="p-";
    }
    table[0][0]="t_";
    table[0][7]="t_";
    table[0][2]="a_";
    table[0][5]="a_";
    table[7][2]="a-";
    table[7][5]="a-";
    table[7][7]="t-";
    table[7][0]="t-";
    table[0][1]="c_";
    table[0][6]="c_";
    table[7][1]="c-";
    table[7][6]="c-";
    table[0][3]="Q_";
    table[0][4]="K_";
    table[7][3]="Q-";
    table[7][4]="K-";
    
  }

  //Se imprime el tablero en pantalla
  public void ImprimirTablero(){
    for(int i=0;i<8;i++){
      for(int j=0;j<8;j++){
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

  //Mètodo para saber la cantidad de elementos restantes
  public boolean Contador(){
    int contadorcm=0,contadorcb=0,contadortm=0, contadortb=0,contadoram=0,contadorab=0,contadorkb=0,contadorkm=0,contadorqm=0,contadorqb=0,contadorpm=0,contadorpb=0;
    
    for(int i=0;i<8;i++){
      for(int j=0;j<8;j++){
        if(table[i][j]=="c-"){
          contadorcm += 1;
        }
        else if(table[i][j] == "c_"){
          contadorcb += 1;
        }
        else if(table[i][j] == "t_"){
          contadortb += 1;
        }
        else if(table[i][j] == "t-"){
          contadortm += 1;
        }
        else if(table[i][j] == "a_"){
          contadorab += 1;
        }
        else if(table[i][j] == "a-"){
          contadoram += 1;
        }
        else if(table[i][j] == "Q_"){
          contadorqb += 1;
        }
        else if(table[i][j] == "Q-"){
          contadorqm += 1;
        }
        else if(table[i][j] == "K_"){
          contadorkb += 1;
        }
        else if(table[i][j] == "K-"){
          contadorkm += 1;
        }
        else if(table[i][j] == "p_"){
          contadorpb += 1;
        }
        else if(table[i][j] == "p-"){
          contadorpm += 1;
        }
      }
    }
    if(contadorpm>0 & contadorpb>0 & contadortm>0 & contadortb>0 & contadoram>0 & contadorab>0 & contadorcm>0 & contadorcb>0 & contadorqm>0 & contadorqb>0 & contadorkm>0 & contadorkb>0){
      return true;
    } else{return false;}
    
  }

  //Mover piezas
  
  public void Movimiento(){
    try{
      Scanner sh = new Scanner(System.in);
    Scanner sh1 = new Scanner(System.in);
    int Temporal1 =0, Temporal2 =0;
    boolean Temporal3 = true;

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

    //Se corrobora que los números ingresados esten dentro de los valores posibles

    if(Numero1>8 || Numero1 < 1){
      System.out.println("\nNúmero 1 Fuera del rango (1,8), escriba de nuevo:\n ");
      Movimiento();
    }
    if(Numero2>8 || Numero2 < 1){
      System.out.println("\nNúmero 2 Fuera del rango (1,8), escriba de nuevo:\n ");
      Movimiento();
    }
    
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
    else if(Letra1.equals("g")){
      Temporal1 = 6;
    }
    else if(Letra1.equals("h")){
      Temporal1 = 7;
    } else{
      System.out.println("\nTu letra 1 no es valida, tira de nuevo:\n ");
      Movimiento();
    }

    if(Letra2.equals("a")){
      Temporal2 = 0;
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
    else if(Letra1.equals("g")){
      Temporal2 = 6;
    }
    else if(Letra1.equals("h")){
      Temporal2 = 7;
    } else{
      System.out.println("\nTu letra 2 no es valida, tira de nuevo:\n ");
      Movimiento();
    }

    //Reina_
    if(table[-(Numero1)+8][Temporal1] == "Q-"){
      if(Temporal2 > Temporal1 & Numero2 > Numero1 & Temporal2 - Temporal1 == Numero2 - Numero1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal1 + (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 < Temporal1 & Numero2 < Numero1 & Temporal2 - Temporal1 == Numero2 - Numero1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal1 + (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 < Temporal1 & Numero2 > Numero1 & Temporal2 - Temporal1 == -(Numero2 - Numero1) & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal1 - (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 > Temporal1 & Numero2 < Numero1 & Temporal2 - Temporal1 == -(Numero2 - Numero1) & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal1 - (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 == Temporal1 & Numero2 > Numero1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal2] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Temporal2 == Temporal1 & Numero2 < Numero1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal2] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Numero2 == Numero1 & Temporal2 > Temporal1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_") ){
        for(int i = Temporal1 +1 ; i<Temporal2 ;i++){
          if(table[-(Numero1)+8][i] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Numero2 == Numero1 & Temporal2 < Temporal1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_") ){
        for(int i = Temporal1 -1 ; i>Temporal2 ;i--){
          if(table[-(Numero1)+8][i] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento();
      }
    }

    //Alfil_
    if(table[-(Numero1)+8][Temporal1] == "a-"){
      if(Temporal2 > Temporal1 & Numero2 > Numero1 & Temporal2 - Temporal1 == Numero2 - Numero1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal1 + (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "a-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 < Temporal1 & Numero2 < Numero1 & Temporal2 - Temporal1 == Numero2 - Numero1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal1 + (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "a-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 < Temporal1 & Numero2 > Numero1 & Temporal2 - Temporal1 == -(Numero2 - Numero1) & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal1 - (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "a-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 > Temporal1 & Numero2 < Numero1 & Temporal2 - Temporal1 == -(Numero2 - Numero1) & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal1 - (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "a-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
    }

    //Torre_
    if(table[-(Numero1)+8][Temporal1] == "t-"){
      if(Temporal2 == Temporal1 & Numero2 > Numero1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal2] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "t-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Temporal2 == Temporal1 & Numero2 < Numero1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal2] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "t-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Numero2 == Numero1 & Temporal2 > Temporal1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_") ){
        for(int i = Temporal1 +1 ; i<Temporal2 ;i++){
          if(table[-(Numero1)+8][i] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "t-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Numero2 == Numero1 & Temporal2 < Temporal1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_") ){
        for(int i = Temporal1 -1 ; i>Temporal2 ;i--){
          if(table[-(Numero1)+8][i] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "t-";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento();
      }
    }

    //Rey_
    if(table[-(Numero1)+8][Temporal1] == "K-"){
      if((Temporal2 == Temporal1 -1 || Temporal2 == Temporal1 +1 ) & (Numero2 == Numero1 +1 || Numero2 == Numero1 -1 || Numero2 == Numero1) & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        table[-(Numero2)+8][Temporal2] = "K-";
        table[-(Numero1)+8][Temporal1] = "--";
      }


      else if(Temporal2 == Temporal1 & (Numero2 == Numero1 +1 || Numero2 == Numero1 -1) & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        table[-(Numero2)+8][Temporal2] = "K-";
        table[-(Numero1)+8][Temporal1] = "--";
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento();
      }
    }

    //Caballo_
    if(table[-(Numero1)+8][Temporal1] == "c-"){
      if((Temporal2 == Temporal1 -2 || Temporal2 == Temporal1 +2) & (Numero2 == Numero1 +1 || Numero2 == Numero1 -1) & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        table[-(Numero2)+8][Temporal2] = "c-";
        table[-(Numero1)+8][Temporal1] = "--";
      }
      else if((Temporal2 == Temporal1 -1 || Temporal2 == Temporal1 +1) & (Numero2 == Numero1 +2 || Numero2 == Numero1 -2) & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        table[-(Numero2)+8][Temporal2] = "c-";
        table[-(Numero1)+8][Temporal1] = "--";
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento();
      }
    }

    //Peon_
    else if(table[-(Numero1)+8][Temporal1] == "p-"){

      if((Numero2 == Numero1 + 2 || Numero2 == Numero1 + 1) & Temporal2 == Temporal1 & table[-(Numero2)+8][Temporal2] == "--"){
        table[-(Numero2)+8][Temporal2] = "p-";
        table[-(Numero1) + 8][Temporal1] = "--";
      }
      else if((Temporal1 == Temporal2 + 1 || Temporal1 == Temporal2 -1) & Numero2 == Numero1 + 1 & (table[-(Numero2)+8][Temporal2] == "p_" || table[-(Numero2)+8][Temporal2] == "t_" || table[-(Numero2)+8][Temporal2] == "Q_" || table[-(Numero2)+8][Temporal2] == "c_" || table[-(Numero2)+8][Temporal2] == "K_" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a_")){
        System.out.println();
        table[-(Numero2)+8][Temporal2] = "p-";
        table[-(Numero1)+8][Temporal1] = "--";
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento();
      }
    }
    } catch(InputMismatchException ime){
      System.out.println("\nOpción no valida, vuelva a tipear:\n ");
      Movimiento();
    }
    

    
    
    
    
  }

  public void Movimiento1(){
    try{
      Scanner sh = new Scanner(System.in);
    Scanner sh1 = new Scanner(System.in);
    int Temporal1 =0, Temporal2 =0;
    boolean Temporal3 = true;

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

    //Se corrobora que los números ingresados esten dentro de los valores posibles

    if(Numero1>8 || Numero1 < 1){
      System.out.println("\nNúmero 1 Fuera del rango (1,8), escriba de nuevo:\n ");
      Movimiento1();
    }
    if(Numero2>8 || Numero2 < 1){
      System.out.println("\nNúmero 2 Fuera del rango (1,8), escriba de nuevo:\n ");
      Movimiento1();
    }
    
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
    else if(Letra1.equals("g")){
      Temporal1 = 6;
    }
    else if(Letra1.equals("h")){
      Temporal1 = 7;
    } else{
      System.out.println("\nTu letra 1 no es valida, tira de nuevo:\n ");
      Movimiento1();
    }

    if(Letra2.equals("a")){
      Temporal2 = 0;
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
    else if(Letra1.equals("g")){
      Temporal2 = 6;
    }
    else if(Letra1.equals("h")){
      Temporal2 = 7;
    } else{
      System.out.println("\nTu letra 2 no es valida, tira de nuevo:\n ");
      Movimiento1();
    }

    //Reina_
    if(table[-(Numero1)+8][Temporal1] == "Q_"){
      if(Temporal2 > Temporal1 & Numero2 > Numero1 & Temporal2 - Temporal1 == Numero2 - Numero1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal1 + (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 < Temporal1 & Numero2 < Numero1 & Temporal2 - Temporal1 == Numero2 - Numero1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal1 + (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 < Temporal1 & Numero2 > Numero1 & Temporal2 - Temporal1 == -(Numero2 - Numero1) & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal1 - (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 > Temporal1 & Numero2 < Numero1 & Temporal2 - Temporal1 == -(Numero2 - Numero1) & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal1 - (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 == Temporal1 & Numero2 > Numero1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal2] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Temporal2 == Temporal1 & Numero2 < Numero1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal2] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Numero2 == Numero1 & Temporal2 > Temporal1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-") ){
        for(int i = Temporal1 +1 ; i<Temporal2 ;i++){
          if(table[-(Numero1)+8][i] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Numero2 == Numero1 & Temporal2 < Temporal1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-") ){
        for(int i = Temporal1 -1 ; i>Temporal2 ;i--){
          if(table[-(Numero1)+8][i] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "Q_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento1();
      }
    }

    //Alfil_
    if(table[-(Numero1)+8][Temporal1] == "a_"){
      if(Temporal2 > Temporal1 & Numero2 > Numero1 & Temporal2 - Temporal1 == Numero2 - Numero1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal1 + (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "a_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 < Temporal1 & Numero2 < Numero1 & Temporal2 - Temporal1 == Numero2 - Numero1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal1 + (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "a_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 < Temporal1 & Numero2 > Numero1 & Temporal2 - Temporal1 == -(Numero2 - Numero1) & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal1 - (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "a_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      if(Temporal2 > Temporal1 & Numero2 < Numero1 & Temporal2 - Temporal1 == -(Numero2 - Numero1) & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal1 - (i-Numero1)] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "a_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
    }

    //Torre_
    if(table[-(Numero1)+8][Temporal1] == "t_"){
      if(Temporal2 == Temporal1 & Numero2 > Numero1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 +1 ; i<Numero2 ;i++){
          if(table[-(i)+8][Temporal2] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "t_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Temporal2 == Temporal1 & Numero2 < Numero1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        for(int i = Numero1 -1 ; i>Numero2 ;i--){
          if(table[-(i)+8][Temporal2] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "t_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Numero2 == Numero1 & Temporal2 > Temporal1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-") ){
        for(int i = Temporal1 +1 ; i<Temporal2 ;i++){
          if(table[-(Numero1)+8][i] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "t_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      }
      else if(Numero2 == Numero1 & Temporal2 < Temporal1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-") ){
        for(int i = Temporal1 -1 ; i>Temporal2 ;i--){
          if(table[-(Numero1)+8][i] == "--"){
            Temporal3 = true;
          } else{
            Temporal3 = false;
            break;
          }
        }
        if(Temporal3 == true){
          table[-(Numero2)+8][Temporal2] = "t_";
          table[-(Numero1)+8][Temporal1] = "--";
        }
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento1();
      }
    }

    //Rey_
    if(table[-(Numero1)+8][Temporal1] == "K_"){
      if((Temporal2 == Temporal1 -1 || Temporal2 == Temporal1 +1 ) & (Numero2 == Numero1 +1 || Numero2 == Numero1 -1 || Numero2 == Numero1) & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        table[-(Numero2)+8][Temporal2] = "K_";
        table[-(Numero1)+8][Temporal1] = "--";
      }


      else if(Temporal2 == Temporal1 & (Numero2 == Numero1 +1 || Numero2 == Numero1 -1) & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        table[-(Numero2)+8][Temporal2] = "K_";
        table[-(Numero1)+8][Temporal1] = "--";
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento1();
      }
    }

    //Caballo_
    if(table[-(Numero1)+8][Temporal1] == "c_"){
      if((Temporal2 == Temporal1 -2 || Temporal2 == Temporal1 +2) & (Numero2 == Numero1 +1 || Numero2 == Numero1 -1) & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        table[-(Numero2)+8][Temporal2] = "c_";
        table[-(Numero1)+8][Temporal1] = "--";
      }
      else if((Temporal2 == Temporal1 -1 || Temporal2 == Temporal1 +1) & (Numero2 == Numero1 +2 || Numero2 == Numero1 -2) & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        table[-(Numero2)+8][Temporal2] = "c_";
        table[-(Numero1)+8][Temporal1] = "--";
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento1();
      }
    }

    //Peon_
    else if(table[-(Numero1)+8][Temporal1] == "p_"){

      if((Numero2 == Numero1 - 2 || Numero2 == Numero1 - 1) & Temporal2 == Temporal1 & table[-(Numero2)+8][Temporal2] == "--"){
        table[-(Numero2)+8][Temporal2] = "p_";
        table[-(Numero1) + 8][Temporal1] = "--";
      }
      else if((Temporal1 == Temporal2 + 1 || Temporal1 == Temporal2 -1) & Numero2 == Numero1 - 1 & (table[-(Numero2)+8][Temporal2] == "p-" || table[-(Numero2)+8][Temporal2] == "t-" || table[-(Numero2)+8][Temporal2] == "Q-" || table[-(Numero2)+8][Temporal2] == "c-" || table[-(Numero2)+8][Temporal2] == "K-" || table[-(Numero2)+8][Temporal2] == "--" || table[-(Numero2)+8][Temporal2] == "a-")){
        System.out.println();
        table[-(Numero2)+8][Temporal2] = "p_";
        table[-(Numero1)+8][Temporal1] = "--";
      } else{
        System.out.println("Tu jugada no es valida, tira de nuevo:");
        Movimiento1();
      }
    }
    } catch(InputMismatchException ime){
      System.out.println("Opción no valida, vuelva a tipear: ");
    }
    

    
    
    
    
  }
}


