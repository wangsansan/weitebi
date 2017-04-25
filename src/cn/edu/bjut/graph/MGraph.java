package cn.edu.bjut.graph;

import java.util.Arrays;

public class MGraph {

	private static int m = 5;// m种状态
	private int n;// n个节点
	private int[]state = new int[n + 1];
	private int[][] weights = new int[n + 1][n + 1];
	public int[][] BCost = new int[m + 1][n + 1];
	
	public int[] getState() {
		return state;
	}

	public void setState(int[] state) {
		this.state = state;
	}

	

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[][] getWeights() {
		return weights;
	}

	public void setWeights(int[][] weights) {
		this.weights = weights;
	}

	public static int getM() {
		return m;
	}

	public static void setM(int m) {
		MGraph.m = m;
	}

	@Override
	public String toString() {
		return "MGraph [n=" + n + ", weights=" + Arrays.toString(weights) + "]";
	}

}
