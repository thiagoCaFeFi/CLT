package MeuJogoJava.lib;

public class Inimigos {
    private String tipo; // espécie do inimigo.
    private int vidaInimigo, manaInimigo, novaVida, novaMana, xp, level; //variavéis de status base.
    private int forca, destreza, inteligencia, sabedoria; //atributos.

   public  void Inimigo (String tipo, int vidaInimigo, int manaInimigo, int xp, int level){
    this.tipo = tipo;
    this.vidaInimigo = vidaInimigo;
    this.manaInimigo = manaInimigo;
    this.xp = xp;
    this.level = level;
   }
   public String getTipo (){
    return tipo;
   }
   public int getVidaInimigo (){
    return vidaInimigo;
   }
   public void setVidaInimigo (){
    if (novaVida != vidaInimigo) {
        vidaInimigo = novaVida;
        }
    }
   public int getManaInimigo (){
    return manaInimigo;
   }
   public void setManaInimigo (){
    if (novaMana != manaInimigo) {
        manaInimigo = novaMana;
        }
    }
   public int getLevel (){
    switch (tipo) {
        case "Hobglobin":
            level = 2;
        case "Soldado das Sombra":
            level = 3;
        case "Mago das Sombras":
            level = 4;
        case "Cavaleiro das Sombras":
            level = 4;
        case "General das Sombras":
            level = 5;
        default:
            level = 1;
            break;
    }
    return level;
   }
   public int getXp (){
    return xp;
   }
   public int getForca (){
    return forca;
   }
   public int getDestreza (){
    return destreza;
   }
   public int getInteligencia (){
    return inteligencia;
   }
   public int getSabedoria (){
    return sabedoria;
   }
}
