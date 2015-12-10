package test;

/*设计两个线程类，一个线程类负责打印100以内所有的偶数，另一个线程打印100以内所有的奇数。
 * 要求偶数线程每打印10个偶数以后，
 * 就让奇数线程打印10个奇数，如此交替进行。。*/
public class MyTwoprintThread {
	//state==1表示线程1开始打印，state==2表示线程2开始打印
	private static int state=1;
	
	private static int num1=1;
	
	private static int num2=2;
	
	public static void main(String[] args) {
		final MyTwoprintThread myTwoprintThread=new MyTwoprintThread();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(num1<100){
					synchronized (myTwoprintThread) {
						if(state!=1){
							try {
								myTwoprintThread.wait(1000);
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
						for (int i = 0; i < 10; i++) {
							System.out.println(num1+" ");
							num1+=2;
						}
						System.err.println("----------");
			            state=2;
			            myTwoprintThread.notifyAll();
					}
				}
			}
		}).start();
		
	   new Thread(new Runnable() {
            @Override
            public void run() {
               while (num2 < 100) {
                 synchronized (myTwoprintThread) {
                	 // TODO Auto-generated method stub
                	 if(state!=2){
                		 try {
                			 myTwoprintThread.wait(5000);
                		 } catch (Exception e) {
                			 e.printStackTrace();
                		 }           
                	 }
                	 for (int i = 0; i < 10; i++) {
                		 System.err.print(num2+"-");
                		 num2+=2;
                	 }
                	 System.err.println("----------");
                	 state=1;
                	 myTwoprintThread.notifyAll();
                 }
              } 
           }
        }).start();
	}
	   // 两个线程都用t对象作为锁，保证每个交替期间只有一个线程在打印
       //如果state!=1, 说明此时尚未轮到线程1打印, 线程1将调用t的wait()方法, 直到下次被唤醒
       // 当state=1时, 轮到线程1打印5次数字
       // 线程1打印完成后, 将state赋值为2, 表示接下来将轮到线程2打印   
       // notifyAll()方法唤醒在t上wait的线程2, 同时线程1将退出同步代码块, 释放t锁
}
