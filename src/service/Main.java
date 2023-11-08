package service;
import model.EmailSaver;
import model.MessageSender;
import javax.mail.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static MessageSender messageSender = new MessageSender();
    static EmailSaver emailSaver = new EmailSaver(new ArrayList<>());

    public static void main(String[] args) throws MessagingException {

        while(true){
            System.out.println("""
                    1.Send message to one email address.
                    2.Send message to two or more email addresses.
                    0.Exit.
                    """);
        String option = scanner.nextLine();
        if(option.equals("0")){
            break;
        }else{
            switch (option){
                case "1" -> OneToOne();
                case "2" -> OneToMany();
            }
        }
        }

    }

    private static void OneToMany() throws MessagingException {
        System.out.println("Enter the number of recipients : ");
            int numOfRecipients = scanner.nextInt();
            int counter = 1;
        while(!(Objects.equals(counter,numOfRecipients))){

            System.out.println("Enter the "+counter+" email address : ");
                String recipient = scanner.nextLine();
                emailSaver.getRecipients().add(recipient);
            counter++;
        }

        System.out.println("Enter message : ");
        String message = scanner.nextLine();
        try {
            messageSender.senderOneToMany(emailSaver.getRecipients(),message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void OneToOne() throws MessagingException {
        System.out.println("Enter email address of recioient : ");
        String recipientAddress = scanner.nextLine();
        System.out.println("Enter message : ");
        String message = scanner.nextLine();
        try {
            messageSender.senderOneToOne(recipientAddress,message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}