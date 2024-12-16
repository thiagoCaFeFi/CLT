package MeuJogoJava.src.principais;

import java.util.Random;
import java.util.Scanner;

public class Combate{
    Personagens usuario;
    Inimigos computador;
    String nome =  usuario.getNome();
    int vida = usuario.getVida();
    String nome1 = computador.getNome();
    int vida1 = computador.getVida();
    Scanner leitor = new Scanner(System.in);
    public int ataqueUsuario(){

        System.out.println("Escolha seu ataque");
        System.out.println("[1]- Soco");
        System.out.println("[2]- Bola de Fogo");
        System.out.println("[3]- Pocao pequena");


        return leitor.nextInt();
        
    }
    public int ataquePc(){
        Random gerador = new Random();
        return gerador.nextInt(3)+1;
        
    
    }
    public void printHp (int vida,String nome, int vida1, String nome1){
        System.out.println("======================");
        System.out.println("-Vida do Jogador" +nome +": " +vida);
        System.out.println("-Vida do Monstro" +nome1 +": "+ vida1);
        System.out.println("======================");
    }
        public int batalha(){
        int escolhaAtaque;
        int i = 1;
        while(vida > 0 && vida1 > 0){
            printHp(vida, nome, vida1, nome1);
            escolhaAtaque = ataqueUsuario();
            switch (escolhaAtaque) {
            case 1:
             System.out.println(nome +" aplicou um soco.");
             this.vida1 -= 7;
             break;
            case 2:
             System.out.println("Sou eu Bola de Fogo!");
             this.vida1 -= 20;
             break;
             case 3:
             System.out.println(nome+" bebeu da pocao e se recuperou um pouco");
            this.vida += 5;
            break;
            default:
             System.out.println("Opcao invalida");
             break;
            }
            if (vida1 > 0) {
             escolhaAtaque = ataquePc();
             switch (escolhaAtaque) {
             case 1:
              System.out.println(nome1+" aplicou um soco.");
              this.vida -= 2 + (int)(i / 10);
              break;
             case 2:
              System.out.println(nome1+" usou uma Bola de Fogo!.");
              this.vida -= 3 + (int)(i / 10);
              break;
             case 3:
              System.out.println(nome1+" bebeu uma pocao");
              this.vida1 +=5;
              break;
             }
            } else {
             System.out.println("Inimigo derrotado");
            } 
            }
           if (vida > 0) {
                this.vida += 5;
                if (vida > 50) {
                vida = 50;
            }
            if(i%10==0){
            i++;
            
           }
           
        }return i;
    } 
}
         
        
