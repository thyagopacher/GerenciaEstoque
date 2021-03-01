/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos.utilitarios;

/**
 *
 * @author Thyago H. Pacher
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tempo {

    public String mes, dia, ano, dia_semana, hora;

    SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm:ss");

    public void le_hora(){
        Date horaAtual = new Date();
        hora = horaformatada.format(horaAtual);
    }

    public void le_data(){
        Date data = new Date();
        mes       = "" + data.getMonth();//0 a 11
        dia       = "" + data.getDate();
        ano       = "" + (1900+data.getYear());

        switch(data.getDay()){
            case 0: dia_semana = "Domingo";break;
            case 1: dia_semana = "Segunda";break;
            case 2: dia_semana = "Terça";break;
            case 3: dia_semana = "Quarta";break;
            case 4: dia_semana = "Quinta";break;
            case 5: dia_semana = "Sexta";break;
            case 6: dia_semana = "Sábado";break;
        }

        switch(data.getMonth()){
            case 0: mes = "01";break;
            case 1: mes = "02";break;
            case 2: mes = "03";break;
            case 3: mes = "04";break;
            case 4: mes = "05";break;
            case 5: mes = "06";break;
            case 6: mes = "07";break;
            case 7: mes = "08";break;
            case 8: mes = "09";break;
            case 9: mes = "10";break;
            case 10: mes = "11";break;
            case 11: mes = "12";break;
        }
    }
}