package com.techgene;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vehicle {
	
	Engine engine;
	Tyres tyre;
	
	public Tyres getTyre() {
		return tyre;
	}

	public void setTyre(Tyres tyre) {
		System.out.println("Vehicle-tyre instantiated via setter");
		this.tyre = tyre;
	}

	public Vehicle(Engine engine,Tyres tyre){
		System.out.println("Vehicle instantiated via constructor");
		this.engine = engine;
		this.tyre = tyre;
	}
	
	public Vehicle(){}
	public Engine getEngine() {
	
		return engine;
	}
	public void setEngine(Engine engine) {
		System.out.println("Vehicle-engine instantiated via setter");
		this.engine = engine;
	}



	@Override
	public String toString(){
		return engine + " "+tyre;
	}
	
	public static void main(String a[]){
		ApplicationContext rootctx = new ClassPathXmlApplicationContext("springContext.xml");
		final Vehicle obj1 = (Vehicle)rootctx.getBean("InjectwithConstructor");
		Vehicle obj2 = (Vehicle)rootctx.getBean("InjectwithSetter");
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1==obj2);
	}

}
