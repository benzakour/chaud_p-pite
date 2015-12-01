package main;

import java.awt.event.ActionListener;

import plugin.MyListener;
import plugin.MyTimer;

public class Main {
	public static void main(String[] args) {
		ActionListener listener= new MyListener();
		MyTimer t = new MyTimer(listener);
		t.start(1000);
		while (true);
}
}
