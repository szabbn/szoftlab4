
public class Engine extends Thread{
 	
	Player player;
	Fellowship fellowship;
	
	public Engine() {
		player = null;
		fellowship = null;
	}
	
	public void createObject() {
		player = new Player();
		fellowship = new Fellowship();
	}
	
	public void attackHandler() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void stepHandler() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void takeToArea() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void run() {
		Writer.entry();
		attackHandler();
		stepHandler();
		takeToArea();
		Writer.asynchronexit();
	}
	
	public void defeat() {
		Writer.entry();
		Writer.asynchronexit();
	}
	
	public void victory() {
		Writer.entry();
		Writer.asynchronexit();
	}
}
