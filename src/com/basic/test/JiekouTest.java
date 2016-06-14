package com.basic.test;

public class JiekouTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoundCard sc = new SoundCard();
		NetworkCard nc = new NetworkCard();
		
		sc.Start();
		sc.Stop();
		
		nc.Start();
		nc.Stop();
	}

}
