/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author paco
 */
public class TMinas {
    private final int col=8;
    private final int filas=8;
    int [] [] campoMinas;
    final int numMinas=10;
    public TMinas(){
        iniciarcMinas();
        ponerMinas();
        terminarMinas();
    }
    //--------------------------------------------------------------------------
    public void iniciarcMinas(){
        campoMinas = new int[filas][col];
        for(int i=0; i<filas; i++){
            for(int j=0; j<col;j++){
                campoMinas[i][j]=-1;
            }
        }
    }
    
    //--------------------------------------------------------------------------
    public void ponerMinas(){
        //pondremos un total de numMinas 
        int contMinas=0;
        int f,c;
        do{
            //elijo fila y col aleatoriamente y si no ha mina aun, la ponemos
            //elijo 9 para simbolizar la mina
            f=(int)(Math.random()*filas);
            c=(int)(Math.random()*col);
           // System.out.println("fila= " +f + " columna= " + c);
            if(campoMinas[f][c]==-1){
                campoMinas[f][c]=9;
                ++contMinas;
             //   System.out.println("colocada mina:" + ++contMinas + " de " +numMinas);
            }
        }while(contMinas<this.numMinas);
    }
    //--------------------------------------------------------------------------
    public void terminarMinas(){
        //vamos a contar las minas proximas que tiene cada cuadro
        for(int f=0;f<filas; f++){
            for(int c=0; c<col; c++){
                if(campoMinas[f][c]!=9) campoMinas[f][c]=comprueba(f,c);
            }
        }
    }
    //--------------------------------------------------------------------------
    public int comprueba(int fil,int colu){
        int cont=0;
        for(int i=max(0, fil-1); i<=min(fil+1, filas-1); i++ ){
            for(int j=max(0,colu-1 ); j<=min(colu+1, col-1); j++){
                
                if(campoMinas[i][j]==9) cont++;
            }
        }
        return cont;
    }
    //--------------------------------------------------------------------------
    public int max(int a, int b){
        if(a>b) return a;
        return b;
    }
    public int min(int a, int b){
       if(a<b) return a;
       return b;
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public int[][] getCampoMinas() {
        return campoMinas;
    }
    
}
