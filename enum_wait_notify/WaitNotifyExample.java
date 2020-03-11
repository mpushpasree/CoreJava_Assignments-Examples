class WaitNotifyExample{

	public static void main(String[] args) throws InterruptedException{
		Calculate cal = new Calculate();

		Thread thread = new Thread(cal);

		thread.start();

		synchronized(cal){
			 System.out.println(Thread.currentThread().getName() + " about to go waiting...");
			// cal.wait();
			cal.wait(5000);
			// System.out.println(Thread.currentThread().getName() + " just woke up...");
		}

		System.out.println("Addition of 1st 100 no's is : " + cal.total);
	}
	
}


class Calculate implements Runnable{

	int total;

	@Override
	public synchronized void run(){
		for (int var = 1; var <= 100; var++) {
			this.total += var;
		}
		// System.out.println(Thread.currentThread().getName() + " sending a notification to the waiting thread now...");
		// this.notify();
	}
}