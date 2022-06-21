package com.day17;


class MyThread8 implements Runnable{

	private int bank = 10000;

	private int getBank() {
		return bank;
	}
	public void setBank(int bank) {
		this.bank = bank;
	}

	private int drawMoney(int pMoney) {
		bank -= pMoney;
		return pMoney;
	}




	@Override
	public void run() {
		int money_need = 6000;
		int money = 0;
		String msg = "";

		try {

			synchronized (this) {

				if(getBank() >= money_need ) {

					money = drawMoney(money_need);
					msg = "인출 성공!!";
				}
				else {
					money = 0;
					msg = "인출 실패!!";
				}
			}
			System.out.println(Thread.currentThread().getName() + msg + " , 인출금액: " + money + " ,잔고: " + getBank());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}


public class Test8 {

	public static void main(String[] args) {
		MyThread8 ob = new MyThread8();

		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		Thread t3 = new Thread(ob);
		Thread t4 = new Thread(ob);
		Thread t5 = new Thread(ob);
		Thread t6 = new Thread(ob);
		Thread t7 = new Thread(ob);
		

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
	}

}




