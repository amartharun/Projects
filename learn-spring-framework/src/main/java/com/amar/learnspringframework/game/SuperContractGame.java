package com.amar.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperContractGame implements GamingConsole{

	public void up() {
		System.out.println("SuperContract up");
		
	}

	public void down() {
		System.out.println("SuperContract down");
		
	}

	public void left() {
		System.out.println("SuperContract left");
		
	}

	public void right() {
		System.out.println("SuperContract right");
		
	}
	

}
