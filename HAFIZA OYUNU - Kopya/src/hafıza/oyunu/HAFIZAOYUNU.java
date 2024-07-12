
package hafıza.oyunu;

import java.util.Scanner;

public class HAFIZAOYUNU {
private static Kart [][] Kartlar =new Kart [4][4];
    
    public static void main(String[] args) {
    
        
        
        Kartlar [0][0] = new Kart ('E');
        Kartlar [0][1] = new Kart ('A');
        Kartlar [0][2] = new Kart ('B');
        Kartlar [0][3] = new Kart ('F');
        Kartlar [1][0] = new Kart ('G');
        Kartlar [1][1] = new Kart ('A');
        Kartlar [1][2] = new Kart ('D');
        Kartlar [1][3] = new Kart ('H');
        Kartlar [2][0] = new Kart ('F');
        Kartlar [2][1] = new Kart ('C');
        Kartlar [2][2] = new Kart ('D');
        Kartlar [2][3] = new Kart ('H');
        Kartlar [3][0] = new Kart ('E');
        Kartlar [3][1] = new Kart ('G');
        Kartlar [3][2] = new Kart ('B');
        Kartlar [3][3] = new Kart ('C');
       
        while(oyunBittiMi()==false){
            
            oyunTahtasi();
            TahminEt();
        }


               
    }
    public static void oyunTahtasi(){
        System.out.println("----------------------------");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    
                    if (Kartlar [i][j].isTahmin()) {
                        System.out.print(" |"+Kartlar[i][j].getDeger()+"| ");
                    }else{
                        System.out.print(" | | ");
                    }
                }
                System.out.println("");
                
            }
        System.out.println("---------------------------");    
    }
    public static boolean oyunBittiMi(){
         
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Kartlar[i][j].isTahmin()==false) {
                    return false;
                }
            }
            
        }
        return true;
    }
    public static void TahminEt(){
        Scanner input = new Scanner (System.in);
        System.out.print("Birinci tahmin (i,j)");
        int i1=input.nextInt();
        int j1=input.nextInt();
        
        //Bir süre ekranda gözükmesi için yaparız
        Kartlar[i1][j1].setTahmin(true);
        oyunTahtasi();
        
        System.out.print("Ikinci tahmin (i,j)");
        int i2=input.nextInt();
        int j2=input.nextInt();
        
        if (Kartlar[i1][j1].getDeger()==Kartlar[i2][j2].getDeger()) {
            System.out.println("Dogru tahmin tebrikler!");
            Kartlar[i2][j2].setTahmin(true);
            
        }else{
            System.out.println("Yanlis tahmin uzgunuz...");
            Kartlar[i1][j1].setTahmin(false);
        }
        
    }
}
