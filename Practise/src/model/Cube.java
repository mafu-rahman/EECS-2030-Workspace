package model;

public class Cube {
	int dime1;
	int dime2;
	int dime3;
	public Cube(int d1, int d2, int d3) {
		dime1 = d1;
		dime2 = d2;
		dime3 = d3;
	}
}

class Test{
	Cube[] array;
	static int desireVolume;
	public Test() {
		array = null;
	}
	
	public Test(Cube[] array, int dv) {
		this.array = array;
		desireVolume = dv;
	}
	int setVol(int vol) {
		vol = desireVolume * vol;
		System.out.println(vol);
		return vol;
	}
	Cube[] setCube(Cube[] array) {
		array[0] = new Cube(100, 0, 0);
		this.array = array;
		System.out.println(array[0].dime1);
		return this.array;
	}
	
	boolean isCube(boolean guess, int i) {
		if(!(array[i].dime1 == array[i].dime1 && array[i].dime2 == array[0].dime3))
			guess = false;
		System.out.println(guess);
		return guess;
	}
}
