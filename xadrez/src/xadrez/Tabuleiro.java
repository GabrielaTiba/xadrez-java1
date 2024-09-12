package xadrez;

public class Tabuleiro {
    
    private Casa[][] casas = new Casa[8][8]; //uma matriz que é o tabuleiro
    
    public Tabuleiro() {
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                casas[i][j] = new Casa(i + 1, (char)(j + 97));
            }
        }
    } //criando casas vazias apenas, pq é pra criar as peças em jogo aparentemente
    
    public void ocuparCasa(int linha, int coluna, Peca peca) {
        casas[linha - 1][coluna].ocupar(peca);
    }
    
    public Casa getCasa(int linha, char coluna) {
        return casas[linha - 1][(int)(coluna - 97)];
    } 
    
    public boolean noLimite(int linha, char coluna) {
        if(linha < 1 || linha > 8) return false; //linha é válido de 1 a 8
        if(coluna < 'a' || coluna > 'h') return false; //coluna de 'a' a 'h'
        return true;
    }
    
    public Casa acharRei(String cor) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(casas[i][j].getPeca() instanceof Rei && casas[i][j].getPeca().getCor().equals(cor)) {
                    return casas[i][j];
                }
            }
        }
        
        return null;
    } 
    
    public void desenho() { //criei um novo método pra desenhar o tabuleiro
            //achei que ia ficar melhor com as linhas e colunas pro jogador ver
        System.out.println("   a  b  c  d  e  f  g  h"); 
        for (int i = 7; i >= 0; i--) { 
            System.out.print((i + 1) + " "); 
            for (int j = 0; j < 8; j++) {
                System.out.print(casas[i][j].desenha() + " "); 
            }
            System.out.println(); 
        }
    }
    
}
