/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package del2;

/**
 *
 * @author vbvir
 */
public class CardFactory {
    public static Card createCard(String suit, String rank) {
        return new Card(suit, rank);
    }
}
