/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activeobjectdesignpattern;

/**
 *
 * @author mhady
 */
public class Book {
    private String title;
    
    public void setTitle(String title) {
    this.title = title;
}

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

