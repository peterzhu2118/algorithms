package ca.peterzhu.algorithms;

import java.util.Arrays;

public class TwoDRangeSum {
	private int[][] nums;
	private int[][] values;

	public TwoDRangeSum(int[][] n) {
		nums = n;

		values = new int[nums.length][nums[0].length];

		buildValues();
	}

	private void buildValues() {
		values[0][0] = nums[0][0];

		for (int i = 1; i < values.length; i++) {
			values[i][0] = values[i - 1][0] + nums[i][0];
		}

		for (int i = 1; i < values[0].length; i++) {
			values[0][i] = values[0][i - 1] + nums[0][i];
		}

		for (int x = 1; x < nums.length; x++) {
			for (int y = 1; y < nums[x].length; y++) {
				values[x][y] = values[x - 1][y] + values[x][y - 1]
						- values[x - 1][y - 1] + nums[x][y];
			}
		}
	}

	public int getSum(int startX, int startY, int endX, int endY) {
		if (startX == 0 && startY == 0) {
			return values[endX][endY];
		} else if (startX == 0) {
			return values[endX][endY] - values[endX][startY - 1];
		} else if (startY == 0) {
			return values[endX][endY] - values[startX - 1][endY];
		} else {
			return values[endX][endY] - values[startX][endY]
					- values[endX][startY] + values[startX][startY];
		}
	}
	
	@Override
	public String toString(){
		return Arrays.deepToString(values);
	}
}
