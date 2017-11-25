/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author user
 */
public class GenerarNumeros {
    private int dato;
    private int cont = 1;
    private String num = "";
    
    public void generarLiquidacion(int dato){
        this.dato = dato;

        if((this.dato >= 999999)&&(this.dato<9999999)){
            int can = cont+this.dato;
            num = "LQ-"+can;
        }
        if((this.dato >= 99999)&&(this.dato<999999)){
            int can = cont+this.dato;
            num = "LQ-0"+can;
        }
        if((this.dato >= 9999)&&(this.dato < 99999)){
            int can = cont+this.dato;
            num = "LQ-00"+can;
        }
        if((this.dato >= 999)&&(this.dato < 9999)){
            int can = cont+this.dato;
            num = "LQ-000"+can;
        }
        if((this.dato >= 99)&&(this.dato < 999)){
            int can = cont+this.dato;
            num = "LQ-0000"+can;
        }
        if((this.dato >= 9)&&(this.dato < 99)){
            int can = cont+this.dato;
            num = "LQ-00000"+can;
        }
        if((this.dato >= 1)&&(this.dato < 9)){
            int can = cont+this.dato;
            num = "LQ-000000"+can;
        }
        if(this.dato == 0){
            int can = cont+this.dato;
            num = "LQ-000000"+can;
        }
    }
    
    public String serie(){
        return this.num;
    }
}
