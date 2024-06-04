package MeuJogoJava.src;

import java.util.Random;
import java.util.Scanner;

public class Combate{
    Guerreiro usuario = new Guerreiro("Guerreiro",50, 10, 1,3 );
    Inimigos computador = new Inimigos("Javali",30);
    String nome =  usuario.getNome();
    int vida = usuario.getVida();
    int forca = usuario.getStrength();
    String nome1 = computador.getNome1();
    int vida1 = computador.getVida1();
    Scanner leitor = new Scanner(System.in);
    public int ataqueUsuario(){

        System.out.println("Escolha: ");
        System.out.println("[1]- Ataque");
        System.out.println("[2]- Magia");
        System.out.println("[3]- Itens");


        return leitor.nextInt();
        
    }
    public int valorAleatorio(int gap){
        Random gerador = new Random();
        return gerador.nextInt(gap)+1;
    }
    public int ataquePc(){
        return valorAleatorio(3);
        
    
    }
    public int escolhaMagias(){
        int magiaEscolhida = ataqueUsuario();
        if(magiaEscolhida == 1){
            return 20;
        }
        else if(magiaEscolhida == 2){
           return 15+valorAleatorio(10);
        } else{
            return 0;
        }
        
            
        }

    public void printHp (int vida,String nome, int vida1, String nome1){
        System.out.println("======================");
        System.out.println("-Vida do " +nome + vida);
        System.out.println("-Vida do " +nome1 + vida1);
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
             this.vida1 -= 7+ forca;
             break;
            case 2:
             System.out.println("1- Bola de Fogo ");
             System.out.println("2- Golpe de Sorte");

             this.vida1 -=escolhaMagias();

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
         
        
