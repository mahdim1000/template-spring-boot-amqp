package org.radargps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var context = SpringApplication.run(Main.class, args);
        Sender sender = context.getBean(Sender.class);
        Receiver receiver = context.getBean(Receiver.class);

        sender.sendWarning("entity_not_found");
        sender.sendDebug("entity_saved");
        sender.sendInfo("load_balanced");
        sender.sendError("null_pointer_exception");
    }
}