package _5_ThreadStateTransitionAndChallenges.BlockedStateChallenge;

public class BlockedStateChallenge {
    public static void main(String[] args) {
        final SharedPrinter printer = new SharedPrinter();

        Thread user1 = new Thread(() -> printer.printDocument("User1's Document"), "User1");
        Thread user2 = new Thread(() -> printer.printDocument("User2's Document"), "User2");

        user1.start();
        user2.start();

    }
}