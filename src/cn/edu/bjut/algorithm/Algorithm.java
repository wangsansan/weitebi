package cn.edu.bjut.algorithm;

import cn.edu.bjut.graph.MGraph;

public class Algorithm {

	public void findMinWeightPath(MGraph g) {

		for (int i = 2; i < g.getWeights().length; i++) {
			int state = g.getState()[i];
			parseBCost(g, state, i);
		}

	}

	public void parseBCost(MGraph g, int state, int i) {
		int min = 0;
		boolean firstFlag = true;
		for (int x = 1; x <= i; x++) {
			if (g.getWeights()[x][i] > 0) {
				if (firstFlag) {
					min = g.getWeights()[x][i] + g.BCost[state - 1][x];
					firstFlag = false;
				} else {
					if (g.getWeights()[x][i] + g.BCost[state - 1][x] < min)
						min = g.getWeights()[x][i] + g.BCost[state - 1][x];
				}
			}
		}

		g.BCost[state][i] = min;

		System.out.println("BCOST[" + state + "][" + i + "]=" + min);

	}

	public static void main(String[] args) {
		int m = 5;
		int n = 12;
		int[] state = { 0, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5 };
		int[][] weights = new int[n + 1][n + 1];
		weights[1][2] = 9;
		weights[1][3] = 7;
		weights[1][4] = 3;
		weights[1][5] = 2;
		weights[2][6] = 4;
		weights[2][7] = 2;
		weights[2][8] = 1;
		weights[3][6] = 2;
		weights[3][7] = 7;
		weights[4][8] = 11;
		weights[5][7] = 11;
		weights[5][8] = 8;
		weights[6][9] = 6;
		weights[6][10] = 5;
		weights[7][9] = 4;
		weights[7][10] = 3;
		weights[8][10] = 5;
		weights[8][11] = 6;
		weights[9][12] = 4;
		weights[10][12] = 2;
		weights[11][12] = 5;
		int[][] bCost = new int[m + 1][n + 1];
		MGraph graph = new MGraph();
		graph.setN(n);
		graph.setState(state);
		graph.setWeights(weights);
		graph.BCost = bCost; 
		Algorithm algorithm = new Algorithm();
		algorithm.findMinWeightPath(graph);
	}

}
