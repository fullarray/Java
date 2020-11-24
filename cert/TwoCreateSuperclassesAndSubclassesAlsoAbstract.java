import java.io.*;

abstract class ProgLanguage{
	abstract void firstProgram();

	public void display(){
		System.out.println("Hello World");
	}
}

class JavaLang extends ProgLanguage{
	public void firstProgram(){
		System.out.println("Java");
	}
}

class CplusplusLang extends ProgLanguage{
	public void firstProgram (){
		System.out.println("C++");
	}
}


class TwoCreateSuperclassesAndSubclassesAlsoAbstract{
   public static void main(String[] args){
      JavaLang l1 = new JavaLang();
      CplusplusLang l2 = new CplusplusLang();

      l1.firstProgram();
      l1.display();
   }

}
