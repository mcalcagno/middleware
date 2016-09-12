package middleware.grupo01.executor;

public class InvalidQueueExecutor {

    private InvalidQueueExecutor taskExecutor;

    public InvalidQueueExecutor(InvalidQueueExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
        for(int i = 0; i < 25; i++) {
           // taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }

	
	private class MessagePrinterTask implements Runnable {
		private String message;

        public MessagePrinterTask(String message) {
            this.message = message;
        }
	        
        public void run() {
        	System.out.println(message);
        }
	}

}