package ru.alexst.certification.ocp.par10;

public class ObjectComposition {

    /*
     * Composition principles (method forwarding or method delegation). Object composition refers to one object having
     * another as an instance variable (HAS-A)
     * 
     * Benefits of composition include 
     * ■ Reuse An object can delegate to another object rather than repeating the same code. 
     * ■ Preventing a proliferation of subclasses We can have one class per functionality rather than needing one
     * for every combination of functionalities.
     */

}

interface Box {
    void pack();
    void seal();
}

interface Mailer {
    void addPostage(); // from Mailer
    void ship();
}

class MailerBox implements Box, Mailer {
    private Box box;

    public MailerBox(Box box) { // pass in a Box
        this.box = box;
    }

    public void pack() { // from Box
        box.pack(); // delegate to box
    }

    public void seal() { // from Box
        box.seal(); // delegate to box
    }

    public void addPostage() { // from Mailer
        System.out.println("affix stamps");
    }

    public void ship() { // from Mailer
        System.out.println("put in mailbox");
    }
}
