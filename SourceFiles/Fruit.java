package Fruit;

import java.io.*;
import java.util.*;

public class Fruit implements Comparable<Fruit> {
	private String shape;
	private String taste;
	private String name;
	private int rank;  //0 to 5
	
	public Fruit(){   //default constructor
		name = "";
		shape = "N/A";
		taste = "N/A";
		rank = 0;
	}
	
	public Fruit(String n, String s, String t, int r){
		shape = s;
		taste = t;
		rank = r;
		name = n;
	}
	
	public String toString(){   //override the toString method, so java will know how to display a Fruit object
		return name + ":\nTaste = " + taste + "\nShape = " + shape + "\nRank" + rank + "\n";
	}
	
	public void changeTaste(String t){    //mutator
		taste = t;
	}
	
	public String getTaste(){     //accessor
		return taste;
	}
	
	public String getName(){
		return name;
	}
	
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		if(this.rank < o.rank){
			return -1;
		}
		else if(this.rank > o.rank){
			return 1;
		}
		else
			return 0;
	}
	
	/*public static void main(String[] args){
		Fruit apple = new Fruit("round", "sour");
		System.out.println(apple);
		apple.changeTaste("sweet");
		System.out.println(apple);
		
		System.out.println(apple.getTaste());

		
	}*/

}

















