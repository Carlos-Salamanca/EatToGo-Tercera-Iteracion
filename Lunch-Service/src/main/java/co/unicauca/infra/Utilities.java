package co.unicauca.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {
	/**
     * Pone en mayúsculas la primera letra de una frase
     *
     * @param text texto ser capitalizado
     * @return texto capitalizado
     */
    public static String capitalize(String text) {
        if (!text.isEmpty()) {
            StringBuffer sbt = new StringBuffer();
            String[] partialText = text.split(" ");
            for (int i = 0; i < partialText.length; i++) {
                if (!partialText[i].equals("")) {

                    if (partialText[i].contains("-")) { //composite words
                        sbt.append(capitalizeWithLine(partialText[i]));
                    } else {
                        sbt.append(capitalizeWord(partialText[i]));
                        sbt.append(" ");
                    }
                }
            }
            return sbt.toString().trim(); //only for entire phrase
        }
        return text;
    }
    
    /**
     * Método privado utilizado por capitalize(String text)
     *
     * @param word
     * @return
     */
    private static String capitalizeWord(String word) {
        if (!word.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(word.charAt(0)).toUpperCase());

            if (word.length() >= 2) {
                sb.append(word.substring(1).toLowerCase());
            }

            return sb.toString();
        }
        return word;
    }
    
    /**
     * Método privado utilizado por capitalize(String text)
     *
     * @param word
     * @return
     */
    private static String capitalizeWithLine(String wordWithLine) {
        StringBuffer res = new StringBuffer();
        String[] partialTextWithLine = wordWithLine.split("-");
        for (int r = 0; r < partialTextWithLine.length; r++) {
            res.append(capitalizeWord(partialTextWithLine[r]));
            if (r + 1 < partialTextWithLine.length) //not append to end
            {
                res.append("-");
            }
        }
        return res.toString();
    }
}
