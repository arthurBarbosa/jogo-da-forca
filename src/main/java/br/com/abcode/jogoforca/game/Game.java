package br.com.abcode.jogoforca.game;

import br.com.abcode.jogoforca.core.Dictionary;
import br.com.abcode.jogoforca.core.Word;

public class Game {

    public void start() {
        Dictionary d = Dictionary.getInstance();
        Word w = d.nextWorld();
        System.out.println(w.getOriginalWord());
    }
}
