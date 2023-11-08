package model;

import java.util.ArrayList;

public class EmailSaver {
    private ArrayList<String> recipients;

    public EmailSaver(ArrayList<String> recipients) {
        this.recipients = recipients;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

}
