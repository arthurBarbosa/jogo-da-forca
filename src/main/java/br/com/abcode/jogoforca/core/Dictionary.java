package br.com.abcode.jogoforca.core;

public abstract class Dictionary {

    private static Dictionary instance;

    public static Dictionary getInstance() {
        if (instance == null) {
            instance = new StaticDictionary();
        }
        return instance;
    }

    public abstract Word nextWorld();

    public abstract String getName();
}
