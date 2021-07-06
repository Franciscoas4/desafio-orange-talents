package com.orange.marvelapi.util;

import com.orange.marvelapi.dto.MarvelComicDTO;
import com.orange.marvelapi.dto.PriceComicDTO;
import com.orange.marvelapi.dto.SummaryCreatorsDTO;

public class ComicsUtil {

    public static String converterListaCriadores(MarvelComicDTO comicDTO) {

        String criador = "";

        for (SummaryCreatorsDTO listaCriadores : comicDTO.getCreators().getItems()) {
            if(comicDTO.getCreators().getAvailable() > 1) {
                criador += listaCriadores.getName() + ", ";
            } else {
                criador = listaCriadores.getName() + ", ";
            }
        }
        criador = criador.substring(0, criador.length() - 2);

        return criador;
    }

    public static Double conveteListaPreco(MarvelComicDTO comicDTO) {
        Double preco = 0.0;

        for (PriceComicDTO price : comicDTO.getPrices()) {
            String precoStr = String.valueOf(price.getPrice());
            preco = Double.parseDouble(precoStr);
        }
        return preco;
    }

    public static String limitarTamanhoString(String texto) {

        return texto.length() <=255 ? texto : texto.substring(0, 255);
    }
}
