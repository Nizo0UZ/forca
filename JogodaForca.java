
package jogodaforca;

import java.util.Scanner;

public class JogodaForca {
    public static void main(String[] args) {
        
        String palavrachave = "teclado";
        String letrasUsadas = "";
        String palavraADV = "";
        int MAX_TENTATIVAS = 10;
        int cont = 0;
        String des = "";
        String des2 = "";
        
        System.out.printf("-*-*-*-*-*-JOGO DA FORCA-*-*-*-*-*-\n");
        System.out.println("        TEMA: PERIFÉRICOS\n");
        for(int i = 0; i < palavrachave.length(); i++){
            palavraADV += " _";
            
            for(int tentativas = 0; ; tentativas++){
                if(tentativas == MAX_TENTATIVAS){
                    System.out.printf("Acabaram as tentativas, a palavra era '%s'", palavrachave);
                    System.exit(0);
                }
                System.out.printf("\nJogada %d. Até agora: %s. Qual a próxima letra?\n", tentativas, palavraADV);
                char ler = new Scanner(System.in).next().charAt(0);
                if(letrasUsadas.indexOf(ler) >= 0){
                    System.out.printf("Letra '%c' já utilizada.\n", ler);
                } else{
                    letrasUsadas += ler;
                    
                    if(palavrachave.indexOf(ler) >= 0){
                        palavraADV = "";
                        
                        for(int j = 0; j < palavrachave.length(); j++){
                            palavraADV += letrasUsadas.indexOf(palavrachave.charAt(j)) >= 0 ? palavrachave.charAt(j) : " _";
                        }
                        
                        if(palavraADV.contains(" _")){
                            System.out.printf("'%s' existe na palavra e ainda possui letras escondidas\n", ler);
                        } else{
                            System.out.printf("Parabéns!, a palavra era '%s'\n", palavraADV);
                            System.exit(0);
                        }
                    } else{
                        System.out.printf("Infelizmente a letra '%c' não existe.\n", ler);
                        cont += 1;
                        switch(cont){
                            case 1: des = """
                                                  ---
                                                 |   |
                                                  --- 
                                             """;
                            break;
                            case 2: des = "O----^|^----O\n";
                            break;
                            case 3: des = "      |\n";
                            break;
                            case 4: des =  """
                                                 |
                                           """;
                            break;
                            case 5: des = "      |\n";
                            break;
                            case 6: des = "     | |\n";
                            break;
                            case 7: des = "     | |\n";
                            break;
                            case 8: des = "   (O| |\n";
                            break;
                            case 9: des = "       O)\n";
                            break;
                            case 10: des = "MORREU!\n";
                            break;
                        }
                        des2 += des;
                        des = des2;
                        System.out.printf(des);
                    }
                }
            }
        }
    }
}
