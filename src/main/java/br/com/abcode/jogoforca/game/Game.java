package br.com.abcode.jogoforca.game;

import br.com.abcode.jogoforca.core.Dictionary;
import br.com.abcode.jogoforca.core.InvalidCharacterException;
import br.com.abcode.jogoforca.core.Word;
import br.com.abcode.jogoforca.ui.UI;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private static final int MAX_ERRORS = 5;

    public void start() {
        UI.print("Bem vindo ao jogo da Forca!");

        Dictionary dictionary = Dictionary.getInstance();
        Word word = dictionary.nextWorld();

        UI.print("A palavra tem " + word.size() + " letras");

        Set<Character> usedChars = new HashSet<>();
        int errorCount = 0;

        while (true) {
            UI.print(word);
            UI.printNewLine();

            char c;
            try {
                c = UI.readChar("Digite uma letra");

                if (usedChars.contains(c)) {
                    throw new InvalidCharacterException("Esta letra já foi utilizada");
                }

                usedChars.add(c);

                if (word.hasChar(c)) {
                    UI.print("Você acertou uma letra!");
                } else {
                    errorCount++;

                    if (errorCount < MAX_ERRORS) {
                        UI.print("Você errou! Você ainda pode errar " + (MAX_ERRORS - errorCount) + " vez(es)");
                    }
                }
                UI.printNewLine();

                if (word.discovered()) {
                    UI.print("Parabéns! Você acertou a palavra correta: " + word.getOriginalWord());
                    UI.print("FIM DE JOGO!");
                    break;
                }

                if (errorCount == MAX_ERRORS) {
                    UI.print("Você perdeu o jogo! A palavra correta era: " + word.getOriginalWord());
                    UI.print("FIM DE JOGO!");
                    break;
                }

            } catch (InvalidCharacterException e) {
                UI.print("Erro: " + e.getMessage());
                UI.printNewLine();
            }
        }

    }
}
