public interface VendingMachineState
{
	public void selectProductAndInsertMoney(int amount, String productName);
	public void dispenseProduct();
}

public class NoMoneyState implements VendingMachine{
	
	public void selectProductAndInsertMoney(int amount, String productName){
		System.out.println(amount + "USD were inserted and " + productName + " was selected.");
	}
	
	public void dispenseProduct(){
		System.out.println("Machine is unable to dispense product because product was not selected.");
	}
}

public class HasMoneyState implements VendingMachine{
	
	public void selectProductAndInsertMoney(int amount, String productName){
		System.out.println("Machine has money and product selected. Please wait... ");

}
	}
	
	public void dispenseProduct(){
		System.out.println("Product dispensed...");
	}
}


public class VendingMachine implements VendingMachineState
{
	private VendingMachineState vendingMachineState;
	
	public VendingMachine()
	{
		vendingMachineState = new NoMoneyState();
	}
	
	public VendingMachineState getVendingMachineState(){
		return vendingMachineState;
	}
	
	public void setVendingMachineState(VendingMachineState vendingMachineState){
		this.vendingMachineState = vendingMachineState;
	}
	
	public void selectProductAndInsertMoney(int amount, String productName){
		vendingMachineState.selectProductAndInsertMoney(amount, productName);
		VendingMachineState hasMoneyState = new HasMoneyState();
		
		if(vendingMachineState instanceof NoMondeyState){
			setVendingMachineState(hasMoneyState);
			System.out.println("Machine state moved to : "+ vendingMachineState.getClass().getName());
		}
		
	}
	
	public void dispenseProduct(){
		VendingMachineState noMoneyState = new NoMoneyState();
		vendingMachineState.dispenseProduct();
		
		if(vendingMachineState instanceof HasMoneyState){
			setVendingMachineState(noMoneyState);
			System.out.println("Machine state moved to : "+ vendingMachineState.getClass().getName());
		}
	}
}

/* Main Driver */

public class Client{
	
	public static void main(String[] args){
		VendingMachine vendingMachine = new VendingMachine();
		
		System.out.println("Machine current state : "+ vendingMachine.getVendingMachineState().getClass().getName()+"\n");

				vendingMachine.dispenseProduct();
				vendingMachine.selectProductAndInsertMoney(400, "Coca-cola");
				System.out.println("Machine actual state : " + vendingMachine.getVendingMachineState().getClass().getName()+"\n");

				vendingMachine.selectProductAndInsertMoney(200, "DrPepper");
				vendingMachine.dispenseProduct();
				
				System.out.println("\nMachine current state : "+ vendingMachine.getVendingMachineState().getClass().getName());

	}
}