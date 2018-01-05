//Abstract factory pattern
//This programs creates shapes and their respective colors using factories.

public interface Shape{
	void draw();
}

public interface Color{
	void fill();
}

public class Rectangle implements Shape{
	
	public void draw(){
		System.out.println("In Rectangle::draw() method.");
	}
}

public class Square implements Shape{
	
	public void draw(){
		System.out.println("In Square::draw() method.");
	}
}

public class Circle implements Shape{
	
	public void draw(){
		System.out.println("In Circle::draw() method.");
	}
}

public class Red implements Color{
	public void fill(){
		System.out.println("In Red::draw() method.");
	}
}

public class Green implements Color{
	
	public void fill(){
		System.out.println("In Green::draw() method.");
	}
}

public class Blue implements Color{
	
	public void fill(){
		System.out.println("In Blue::draw() method.");
	}
}

public abstract class absFactory{
	abstract color getColor(String color);
	abstract Shape getShape(String shape);
}

public class ShapeFactory extends absFactory{
	
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}
		
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}else{
			return null;
		}
	}
	
	Color getColor(String color){
		return null;
	}
}

public class ColorFactory extends absFactory{
	public Shape getShape(String shapeType){
		return null;
	}
	
	Color getColor(String color){
		if(color == null){
			return null;
		}
		
		if(color.equalsIgnoreCase("RED")){
			return new Red();
		}else if(color.equalsIgnoreCase("GREEN")){
			return new Green();
		}else if(color.equalsIgnoreCase("BLUE")){
			return new Blue();
		}else{
			return null;
		}
	}
}

public class FactoryProducer{
	public static absFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("SHAPE")){
			return new ShapeFactory();
		}else if(choice.equalsIgnoreCase("COLOR")){
			return new ColorFactory();
		}else{
			return null;
		}
	}
}

public class abstractFactory{
	public static void main(String[] args){
		absFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();
		
		absFactory colorFactory = FactoryProducer.getFactory("COLOR");
		
		Color color1 = colorFactory.getColor("RED");
		color1.fill();
		
		Color color2 = colorFactory.getColor("GREEN");
		color2.fill();
		
		Color color3 = colorFactory.getColor("BLUE");
		color3.fill();
	}
}

