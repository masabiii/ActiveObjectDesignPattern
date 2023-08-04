/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package activeobjectdesignpattern;

/**
 *
 * @author mhady
 */
public class ActiveObjectDesignPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Library library = new Library();
        
        library.addMember("Abi", true);
        library.addMember("Alice", false);
        
        library.addBook("Java Programming");
        library.addBook("Design Patterns");

        Member member = new Member("Abi", true);
        Member nonMember = new Member("Hadyan", false);

        Book book1 = new Book("Introduction to Programming");
        Book book2 = new Book("Advanced Algorithms");

        library.borrowBook(book1.getTitle(), member.getName(), member.isMember());
        library.borrowBook(book2.getTitle(), nonMember.getName(), nonMember.isMember());

        library.returnBook(book1.getTitle(), member.getName());
        library.returnBook(book2.getTitle(), nonMember.getName());

        library.shutdown();
    }
  }
    
