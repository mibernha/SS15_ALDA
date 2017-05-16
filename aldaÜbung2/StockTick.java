package alda‹bung2;
import java.util.Random;

public class StockTick {
	private double kurs;
	private Random rndStream;
	public StockTick()
	{
		this.rndStream = new Random();
	}
	void setKurs(double letztKurs, float kursDiff)
	{
		this.kurs = letztKurs+kursDiff;
	}
	public double getKurs()
	{
		return kurs;
	}
	public int setStartKurs()
	{
		int startKurs = rndStream.nextInt(101)+500;
		return startKurs;
	}
	public float setKursDiff()
	{
		float kursDiff = rndStream.nextInt(61)-30;
		return kursDiff;
	}
	
}
