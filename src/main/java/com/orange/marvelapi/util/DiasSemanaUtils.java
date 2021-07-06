package com.orange.marvelapi.util;

import com.orange.marvelapi.enums.DiaSemana;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

public class DiasSemanaUtils {

    public static Integer getDiaSemana() {

        Date date = new Date();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date);
        return calendario.get(Calendar.DAY_OF_WEEK);
    }

    public static String getSemanaNome(Integer semandaDia) {

        String semanaNome = null;

        switch (semandaDia) {
            case 2:
                semanaNome = DiaSemana.SEGUNDA.getNome();
                break;
            case 3:
                semanaNome = DiaSemana.TERCA.getNome();
                break;
            case 4:
                semanaNome = DiaSemana.QUARTA.getNome();
                break;
            case 5:
                semanaNome = DiaSemana.QUINTA.getNome();
                break;
            case 6:
                semanaNome = DiaSemana.SEXTA.getNome();
                break;
            default:
                break;
        }
        return semanaNome;
    }
}
