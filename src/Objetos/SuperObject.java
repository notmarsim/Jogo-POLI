package Objetos;

import entity.Player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class SuperObject {
    public BufferedImage image;
    public String nome;
    public List<SuperObject> listaItens;

    public SuperObject() {
        listaItens = new ArrayList<>();
    }

    public void addItem(SuperObject item) {
        listaItens.add(item);
    }

    public abstract void usouItem(Player player);
}
