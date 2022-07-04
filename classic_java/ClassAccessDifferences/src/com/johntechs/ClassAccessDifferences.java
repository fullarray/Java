package com.johntechs;
//package com.johntechs.InnerClass;
import com.johntechs.protectedexample.RooThings;


class OuterClass{
	static int num2 = 1;
	
	 class InnerClass{
		int y = 6;
		public int myInnerMethod() {
			return num2;
		}
	}
}

public class ClassAccessDifferences extends RooThings {
	int num3 = 1;

	static abstract class myStaticAbstract {
		static void myAbstractClassMethod() {
			System.out.println("Inside abstract class myAbstractClassMethod");
		}
	}
	
	void myAbstractClassMethod(){
		System.out.println("Static abstract method");
	}

	final static void myFinalStaticMethod() {
		System.out.println("Final static method");
	}
	
	static void myStaticMethod() {
		System.out.println("Static method");
	}
	
	public void myPublicMethod() {
		System.out.println("Public method");
	}
	
	private void myPrivateMethod() {
		//illegal
		//static enum coffeeSize {BIG, GRANDE};
		System.out.println("Private method");
	}
	
	public static void main(String[] args) {
		ClassAccessDifferences myObj = new ClassAccessDifferences();
		OuterClass myOuterClass = new OuterClass();
		
		System.out.println("Protecte attribute in RooThings "+ num1);
		
		//if the inner class is static, it works.
		//if the inner class is public, it is redundant.
		//OuterClass.InnerClass myInner = new OuterClass.InnerClass();
		OuterClass.InnerClass myInner = myOuterClass.new InnerClass();
		
		//If the inner is static, it raises an error.
		//Only if the inner class is NOT static. 
		//Cannot instantiate a static class from object. only from class.
		//OuterClass.InnerClass myInnerClass = myOuterClass.new InnerClass();
		
		System.out.println("Method inside inner class method "+ myInner.myInnerMethod());
		System.out.println("Attribute inside inner class method "+ myInner.y);

		//System.out.println("Method inside inner class method "+ myInnerClass.myInnerMethod());
		//System.out.println("Attribute inside inner class method "+ myInnerClass.y);

		
		myStaticAbstract.myAbstractClassMethod();
		myFinalStaticMethod();
		myStaticMethod();
		myObj.myPrivateMethod();
		myObj.myPublicMethod();
		
	}

}


