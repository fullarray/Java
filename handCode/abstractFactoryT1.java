public interface Shape{
	void draw();
}
//Concrete classes
public class Rectangle implements Shape{
	@Override
	public void draw(){
		System.out.println("In the Rectangle class.");
	}
}

public class Square implements Shape{
	@Override
	public void draw(){
		System.out.println("in the Square class.");
	}
}

public class Circle implements Shape{
	@Override
	public void draw(){
		System.out.println("In the Circle class");
	}
}

//interface colors
public interface Color{
	void fill();
}

public class Red implements Color{
	@Override
	public void fill(){
		System.out.println("In Red class.");
	}
}

public class Green implements Color{
	@Override
	public void fill(){
		System.out.println("In Green class");
	}
}

public class Blue implements Color{
	@Override
	public void fill(){
		System.out.println("In Blue class.");
	}
}

public abstract class AbstractFactory{
	abstract Color getColor(String color);
	abstract Shape getShape(String shape);
}

public class ShapeFactory extends AbstractFactory{
	@Override
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}
		
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		return null;
	}
	
	@Override
	Color getColor(String color){
		return null;
	}
}

public class colorFactory extends AbstractFactory{
	@Override
	public Shape getShape(String shapeType){
		return null;
	}
	
	public getColor(String color){
		if(color == null){
			return null;
		}
		
		if(color.equalsIgnoreCase("RED")){
			return new Red();
		}else if(color.equalsIgnoreCase("GREEN")){
			return new Green();
		}else if(color.equalsIgnoreCase("BLUE")){
			return new Blue();
		}
		return null;
	}
}

public class FactoryProducer{
	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("SHAPE")){
			return new ShapeFactory();
		}else if(choice.equalsIgnoreCase("COLOR")){
			return new colorFactory();
		}
		return null;
	}
}

//driver
public class AbstractFactoryT1{
	public static void main(String[] args){
		AbstractFactory factory = FactoryProducer.getFactory("SHAPE");
		
		Shape shape1 = factory.getShape("CIRCLE");
		
		shape1.draw();
		
		Shape shape2 = factory.getShape("RECTANGLE");
		
		shape2.draw();
		
		Shape shape3 = factory.getShape("SQUARE");
		
		shape3.draw();
		
		AbstractFactory color = FactoryProducer.getFactory("COLOR");
		
		Color color1 = color.getColor("GREEN");
		
		color1.fill();
		
		Color color2 = color.getColor("RED");
		
		color2.fill():
		
		Color color3 = color.getColor("BLUE");
		
		color3.fill();
	}
}