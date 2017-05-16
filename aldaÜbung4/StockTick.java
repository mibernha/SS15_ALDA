package alda‹bung4;
import java.util.Random;

public class StockTick {
	private String symbol;
	private int kurs;
	public Random rndStream;
	public String[] firmenName = {"IBM", "CIS", "HWP", "GOOGL", "ORCL", "GPRO", "BABA", "AAPL", "SAP",	"MSFT"};
	
	public StockTick generateStockTick(){
		this.rndStream = new Random();
		StockTick sTick = new StockTick();
		sTick.symbol = firmenName[rndStream.nextInt(10)];
		sTick.kurs = rndStream.nextInt(11)+50;
		return sTick;
	}
	public String getSymbol(){
		return this.symbol;
	}
	public int getKurs(){
		return this.kurs;
	}
	public void setSymbol(String s){
		this.symbol = s;
	}
}
