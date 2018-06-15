/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import java.awt.Component;

/**
 * Permet de gérer la hitbox d'une maison
 * @author jgermain
 */
public class Circle {
    private int posX;
    private int posY;
    private int radius;

    /**
     * Constructeur
     * @param posX Position x
     * @param posY  Position y
     * @param radius Rayon du cercle
     */
    public Circle(int posX, int posY, int radius) {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    /**
     * Retourne le x du cercle
     * @return coordonnée x du cercle
     */
    public int getPosX() {
        return posX;
    }
    
    /**
     * Retourne le y du cercle
     * @return coordonée y du cercle
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Retourne le rayon du cercle
     * @return le rayon du cercle
     */
    public int getRadius() {
        return radius;
    }
    
    /**
     * Condition sur la hitbox d'une maison
     * Renvoie true si l'unité est contenu dans la hitbox
     * @param c unité
     * @return Vrai si l'unité est comprise dans le cercle
     */
    public boolean contains(Component c){
        return this.contains(c.getX(), c.getY());
    }
   
    /**
     * Renvoie true si le point en entré est contenu dans le cercle
     * @param posX Position X à tester
     * @param posY  Position Y à tester
     * @return Vrai si le point en [x, y] est contenu dans le cercle
     */
    public boolean contains(int posX, int posY){
        return (posX >= this.posX &&
               posX <  this.posX + (getRadius() * 2) &&
               posY >= this.posY &&
               posY <  this.posY + (getRadius() * 2));
   }
}
