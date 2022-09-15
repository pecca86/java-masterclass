package concurrency.deadlocks;

public class LiveLock {

    public static void main(String[] args) {
        final WorkerGuy workerGuy1 = new WorkerGuy("worker1", true);
        final WorkerGuy workerGuy2 = new WorkerGuy("worker2", true);

        final SharedResource sharedResource = new SharedResource(workerGuy1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                workerGuy1.work(sharedResource, workerGuy2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                workerGuy2.work(sharedResource, workerGuy1);
            }
        }).start();
    }
}


    /**
     * Worker
     */
    class WorkerGuy {
        private String name;
        private boolean active;

        public WorkerGuy(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public boolean isActive() {
            return active;
        }

        public synchronized void work(SharedResource sharedResource, WorkerGuy workerGuy) {
            while (active) {
                // Check if this owns the shared resource
                if(sharedResource.getOwner() != this) {
                    try {
                        wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }

                if(workerGuy.isActive()) {
                    System.out.println(getName() + ": Give the resource to the worker " + workerGuy.getName());
                    sharedResource.setOwner(workerGuy);
                    continue;
                }
                System.out.println(getName() + " working on the common resource");
                active = false;
                sharedResource.setOwner(workerGuy);
            }
        }
    }


    /**
     * Shared
     */
    class SharedResource {
        private WorkerGuy owner;

        public SharedResource(WorkerGuy owner) {
            this.owner = owner;
        }

        public WorkerGuy getOwner() {
            return owner;
        }

        // Synced, since we are changing data
        public synchronized void setOwner(WorkerGuy owner) {
            this.owner = owner;
        }
    }




