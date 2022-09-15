package concurrency.deadlocks;

public class DeadlockDemoTwo {

    public static void main(String[] args) {
        PolitePerson person = new PolitePerson("Guye");
        PolitePerson person2 = new PolitePerson("Buye");

        // Will create a deadlock, since the inner method will not release the lock
        new Thread(() -> person2.sayHello(person)).start();
        new Thread(() -> person.sayHello(person2)).start();

    }

    record PolitePerson(String name) {

        public synchronized void sayHello(PolitePerson person) {
                System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.name());
                person.sayHelloBack(this);
            }

            public synchronized void sayHelloBack(PolitePerson person) {
                System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.name());
            }

        }
}
