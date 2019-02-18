public class MadeACall {
    private static final int MAX_COUNT_CALL_FOR_SIMULATION = 250;
    public static final int RANDOM_COEF = 10;
    private Contact caller;
    private Contact receiver;

    public void madeACallSimulation(PhoneBook phoneBook) {

        if (phoneBook != null) {
            for (int callNumber = 0; callNumber < MAX_COUNT_CALL_FOR_SIMULATION * Math.random() * RANDOM_COEF; callNumber++) {
                this.caller = phoneBook.getCallerContact();
                this.receiver = phoneBook.getRecieverContact();
                if (!this.caller.equals(this.receiver)) {
                    System.out.println("[I'm the contact " + this.caller.getFullName() + " and I'll call " + this.receiver.getFullName() + "]");
                    phoneBook.increaseContactCallsByOne(this.caller);
                    this.caller.setCountOutgoingCalls(this.caller.getCountOutgoingCalls() + 1);
                }
            }

        }
        else {
            System.out.println("[I " + this.caller.getFullName() + " could not get in touch!");
        }
        System.out.println("------------------------------------------------------------------------------------");

        phoneBook.bestContact();
        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("The total number of outgoing calls for the phone book is: " + PhoneBook.getOutgoingCallsPhoneBook());
    }
}
