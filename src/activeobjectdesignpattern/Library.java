/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activeobjectdesignpattern;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mhady
 */
public class Library {
    private List<Member> members = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private BlockingQueue<Runnable> requestsQueue = new LinkedBlockingQueue<>();
    private Thread workerThread;

    public Library() {
        workerThread = new Thread(() -> {
            while (true) {
                try {
                    Runnable request = requestsQueue.take();
                    request.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        workerThread.start();
    }
    
    public void addMember(String name, boolean isMember) {
        requestsQueue.offer(() -> {
            members.add(new Member(name, isMember));
            System.out.println("Member added: " + name);
        });
    }

    public void addBook(String title) {
        requestsQueue.offer(() -> {
            books.add(new Book(title));
            System.out.println("Book added: " + title);
        });
    }

    public void borrowBook(String book, String user, boolean isMember) {
        requestsQueue.offer(() -> {
            String borrowDuration = isMember ? "30 days" : "14 days";
            System.out.println(user + " is borrowing the book: " + book + " for " + borrowDuration);
        });
    }

    public void returnBook(String book, String user) {
        requestsQueue.offer(() -> {
            System.out.println(user + " is returning the book: " + book);
        });
    }

    public void shutdown() {
        workerThread.interrupt();
    }
}
