package tem.com;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class MatrixUtil {
	// irregular array
	public static int[][] getArray() {
		int[][] num = { { 1, 2, 3 }, { 4, 5 }, { 2 } };
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++)
				System.out.println(num[i][j]);
		}
		return num;
	}

	public static void printArray(int[][] num) {
		// int [][] num={{1,2,3},{4,5},{2}};
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++)
				System.out.print(num[i][j] + "\t");
			System.out.println();
		}
	}

	public static void printArray(short[][] num) {
		// int [][] num={{1,2,3},{4,5},{2}};
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++)
				System.out.print(num[i][j] + "\t");
			System.out.println();
		}
	}

	public static void printArray(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}
		System.out.println();
	}

	public static void printArray(long[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}
		System.out.println();
	}

	public static void printArray(double[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}
		System.out.println();
	}

	public static void printArray(boolean[][] bs) {
		for (int i = 0; i < bs.length; i++) {
			for (int j = 0; j < bs[i].length; j++) {
				if (bs[i][j])
					System.out.print("1\t");
				else
					System.out.print("0\t");
			}
			System.out.println();
		}
	}

	public static double sumCol(float[][] data, int u) {
		double a = 0.0D;
		for (int m = 0; m < data[u].length; m++) {
			a += data[m][u];
		}
		return a;
	}

	public static double sumRow(int[][] matrix, int u) {
		double a = 0.0D;
		for (int m = 0; m < matrix[u].length; m++) {
			a += matrix[u][m];
		}
		return a;
	}

	public static double sum(double[] a2) {
		double a = 0l;
		for (int i = 0; i < a2.length; i++) {
			a += a2[i];
		}
		return a;
	}

	public static double sum(int[] a2) {
		double a = 0;
		for (int i = 0; i < a2.length; i++) {
			a += a2[i];
		}
		return a;
	}

	public static int max(int[] flag) {
		int max = flag[0];
		for (int i = 1; i < flag.length; i++) {
			if (flag[i] > max)
				max = flag[i];
		}
		return max;
	}

	public static double max(double[] flag) {
		double max = flag[0];
		for (int i = 1; i < flag.length; i++) {
			if (flag[i] > max)
				max = flag[i];
		}
		return max;
	}

	public static double min(double[] flag) {
		double min = flag[0];
		for (int i = 1; i < flag.length; i++) {
			if (flag[i] < min)
				min = flag[i];
		}
		return min;
	}

	public static void randperm(int[] set, int vector_n, int m) {
		// sample M points from 1:vector_n
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < vector_n; i++)
			list.add(i);
		java.util.Collections.shuffle(list);

		for (int i = 0; i < m; i++) {
			set[i] = list.get(i);
		}
	}

	public static double dist(double[] ds, double[] ds2, String distDesp) {
		if (distDesp.equals("Euclidean")) {
			double dist = 0d;
			for (int i = 0; i < ds.length; i++) {
				dist += Math.pow(ds[i] - ds2[i], 2);
			}
			return Math.sqrt(dist);
		} else
			return (Double) null;
	}

	public static double dist(double ds, double ds2, String distDesp) {
		if (distDesp.equals("Euclidean")) {
			double dist = Math.pow(ds - ds2, 2);
			return Math.sqrt(dist);
		} else
			return (Double) null;
	}

	public static double KL(double[] fs, double[] fs2) {
		double klScore = 0.0D, phi_i1, phi_i2;
		klScore = 0.0;
		for (int v = 0; v < fs.length; v++) {
			// cal KL Div by summing
			phi_i1 = fs[v];
			phi_i2 = fs2[v];
			if (phi_i1 > 0 && phi_i2 > 0)
				klScore += phi_i1 * Math.log(phi_i1 / phi_i2);
		}
		return klScore;
	}

	public static double JS(double[] fs, double[] fs2) {
		double[] avg = new double[fs.length];
		for (int v = 0; v < fs.length; v++) {
			avg[v] = (fs[v] + fs2[v]) / 2;
		}

		double JSScore = 0.0d;
		JSScore += KL(fs, avg);
		JSScore += KL(fs2, avg);
		JSScore = JSScore / 2;

		return JSScore;
	}

	public static void norm1(double[] thetaD) {
		double sum = sum(thetaD);
		for (int i = 0; i < thetaD.length; i++)
			thetaD[i] = thetaD[i] / sum;
	}
}
