package com.orange.marvelapi.util;

import com.orange.marvelapi.dto.MarvelComicDTO;
import com.orange.marvelapi.enums.DiaSemana;

public class UtilIsbn {

    public static Integer retornaIsbnDia(MarvelComicDTO comicDTO) {
        Integer isbnTamanho = comicDTO.getIsbn().length();
        String isbnStr = comicDTO.getIsbn();
        Integer isbn = null;

        if (isbnTamanho > 0) {

            String fim = "Final ";

            isbnStr = isbnStr.substring(isbnTamanho - 3, isbnTamanho);
            isbnStr = fim.concat(isbnStr);

            switch (isbnStr) {
                case "Final 0-1":
                    isbn = DiaSemana.SEGUNDA_FEIRA.getSemanaDia();
                    break;
                case "Final 2-3":
                    isbn = DiaSemana.TERCA_FEIRA.getSemanaDia();
                    break;
                case "Final 4-5":
                    isbn = DiaSemana.QUARTA_FEIRA.getSemanaDia();
                    break;
                case "Final 6-7":
                    isbn = DiaSemana.QUINTA_FEIRA.getSemanaDia();
                    break;
                case "Final 8-9":
                    isbn = DiaSemana.SEXTA_FEIRA.getSemanaDia();
                    break;
                default:
                    break;
            }
        }
        return isbn;
    }
}
