/*
Matrix Product
We need time proportional to N3 to multiply two N*N matrices. We are 
going to compute AM for a given matrix A.  If we simply conduct matrix 
multiplication M-1 times, we need time proportional to (M-1)*N3. 
We may need huge time in this way. You should speed up this job. Given 
an N*N matrix A, you should provide a program that compute ‘AM mod 100,000,007’
as fast as possible, for an M not smaller than 2.  ‘AM mod q’ means the matrix 
in which each element has the remainder after divided by q, with the value 0 
through q-1.  For instance, ‘  mod 6’ is . (This is just for avoiding overflow 
by too big integers. You only have to conduct ‘x*y mod q’ for any ‘x*y.’) 
In this problem, the most important thing is the running time. 
If time limit passes, you got points for the cases that your program 
has completed. The input will be provided in the increasing order of 
problem sizes; so an inefficient program may successfully run only some 
small cases.  If you try the most naive way, we guess you would have 
about 30% of the total scores.

Time limit: 2 seconds.

[Input]
There can be more than one test case in the input file.  The first line has C, 
the # of test cases. Then the totally C test cases are provided in the following 
lines. In each test case, the first line has N and M, the dimension of the matrix
and the exponent. 1≤N≤100, 1≤M≤10,000,000.  The following N lines enumerate the 
elements of the matrix. Each line enumerates N elements.  All neighbored numbers 
in a line are separated by a blank.

[Output]
For each test case, you should print "Case #T" in the first line where T 
means the case number.   The next N lines enumerate the elements of the 
solution matrix. As the input file, each line has N elements each separated by a blank.

[I/O Example]
Input
4
2 4
1 2
1 2
3 5
1 0 0
1 1 1
1 0 3
42 18468
34 0 69 24 78 58 62 64 5 45 81 27 61 91 95 42 27 36 91 4 2 53 92 82 21 16 18 95 47 26 71 38 69 12 67 99 35 94 3 11 22 33
73 64 41 11 53 68 47 44 62 57 37 59 23 41 29 78 16 35 90 42 88 6 40 42 64 48 46 5 90 29 70 50 6 1 93 48 29 23 84 54 56 40
66 76 31 8 44 39 26 23 37 38 18 82 29 41 33 15 39 58 4 30 77 6 73 86 21 45 24 72 70 29 77 73 97 12 86 90 61 36 55 67 55 74
31 52 50 50 41 24 66 30 7 91 7 37 57 87 53 83 45 9 9 58 21 88 22 46 6 30 13 68 0 91 62 55 10 59 24 37 48 83 95 41 2 50
91 36 74 20 96 21 48 99 68 84 81 34 53 99 18 38 0 88 27 67 28 93 48 83 7 21 10 17 13 14 9 16 35 51 0 49 19 56 98 3 24 8
44 9 89 2 95 85 93 43 23 87 14 3 48 0 58 18 80 96 98 81 89 98 9 57 72 22 38 92 38 79 90 57 58 91 15 88 56 11 2 34 72 55
28 46 62 86 75 33 69 42 44 16 81 98 22 51 21 99 57 76 92 89 75 12 0 10 3 69 61 88 1 89 55 23 2 85 82 85 88 26 17 57 32 32
69 54 21 89 76 29 68 92 25 55 34 49 41 12 45 60 18 53 39 23 79 96 87 29 49 37 66 49 93 95 97 16 86 5 88 82 55 34 14 1 16 71
86 63 13 55 85 53 12 8 32 45 13 56 21 58 46 82 81 44 96 22 29 61 35 50 73 66 44 59 92 39 53 24 54 10 45 49 86 13 74 22 68 18
87 5 58 91 2 25 77 14 14 24 34 74 72 59 33 70 87 97 18 77 73 70 63 68 92 85 2 80 13 27 2 99 27 25 43 24 23 72 61 81 3 32
5 93 25 31 92 42 22 86 64 0 87 60 13 74 70 70 35 33 11 60 96 67 85 50 40 94 95 24 19 25 76 94 58 2 71 66 78 93 51 84 18 64
19 52 0 87 60 26 10 57 70 15 76 27 43 58 64 9 82 86 65 87 77 74 25 27 29 28 23 20 2 62 23 96 37 61 95 25 64 60 2 16 30 26
11 71 11 47 53 20 90 24 88 63 40 51 62 29 0 13 58 78 65 7 77 0 58 39 3 60 57 24 77 8 13 87 1 50 60 28 93 84 5 40 11 4
35 56 72 50 23 85 56 16 26 57 26 57 37 71 69 61 96 22 17 12 17 96 85 41 23 29 29 65 59 32 96 55 53 62 84 34 54 72 57 69 32 63
7 83 11 35 67 48 75 38 23 42 54 11 41 75 59 25 21 70 26 34 5 83 50 98 79 1 93 34 37 34 56 93 76 5 62 48 81 0 13 41 55 55
42 62 11 77 24 78 52 43 96 73 40 13 75 72 18 10 17 32 12 95 69 31 40 88 85 90 97 89 90 45 53 14 51 40 44 58 35 59 92 5 64 81
3 29 75 8 92 97 49 56 61 27 67 41 29 40 13 74 1 77 15 83 13 92 24 1 92 59 70 28 27 84 75 86 98 70 87 47 4 3 21 63 6 63
10 71 89 40 64 42 19 13 91 4 18 32 50 5 75 39 3 22 98 47 84 48 71 64 13 75 45 12 46 78 69 62 19 85 89 44 65 40 45 8 18 70
1 23 32 72 52 87 70 63 1 3 23 27 0 69 15 65 28 43 47 88 43 37 9 63 49 81 88 42 8 60 21 58 54 88 46 90 49 43 30 20 48 67
36 83 35 26 85 38 53 29 24 48 23 59 57 66 44 55 18 26 11 25 55 1 49 96 84 15 64 42 75 13 42 96 48 72 26 6 73 29 4 5 26 12
75 93 65 36 36 41 14 94 56 52 36 38 82 55 15 31 30 41 25 11 37 86 90 50 62 34 93 53 16 52 8 62 33 54 3 34 3 56 48 24 17 13
9 28 0 80 18 58 50 55 61 64 3 76 43 9 2 61 89 48 82 53 74 20 2 23 31 69 78 59 8 19 71 3 45 81 4 92 85 13 98 89 22 38
37 10 61 34 8 61 59 93 15 69 37 69 58 0 71 64 17 15 55 15 30 39 12 88 82 54 85 10 84 74 80 15 51 41 15 79 10 98 73 88 77 32
56 89 13 8 41 90 23 63 28 84 78 0 71 85 74 71 33 67 53 95 68 25 76 29 50 98 9 93 86 80 16 49 67 28 79 64 21 5 26 16 16 26
66 87 81 64 40 86 21 62 21 64 9 15 2 73 24 41 45 62 23 31 6 68 18 2 7 7 81 12 36 30 14 9 84 56 90 93 96 52 54 45 8 48
91 12 31 14 39 58 22 4 95 52 69 79 38 23 18 66 59 98 86 96 62 33 58 22 46 92 37 25 47 58 2 7 98 30 92 0 78 99 52 48 82 40
15 75 62 67 36 97 18 97 28 51 16 30 49 25 58 29 20 40 60 47 62 55 75 92 61 54 98 46 14 46 88 69 38 63 75 15 21 75 15 28 34 70
5 64 57 62 61 24 49 69 30 23 50 33 25 10 37 36 37 78 93 36 14 64 91 49 35 5 37 4 37 23 64 70 8 68 81 85 52 73 52 94 76 26
96 72 49 40 74 19 43 11 41 89 19 65 5 85 16 50 15 9 64 66 93 74 9 0 95 73 89 61 72 68 58 31 68 26 10 22 74 79 10 52 82 91
95 64 74 64 2 55 60 74 72 21 22 47 77 89 5 95 94 50 43 54 81 12 72 39 28 12 62 67 8 15 8 23 59 34 4 86 19 58 45 6 66 0
67 92 87 32 56 74 47 21 83 22 31 76 83 48 23 82 18 76 20 11 82 56 90 25 24 86 77 69 43 34 77 68 68 91 96 83 28 27 26 71 97 12
3 27 8 45 8 85 38 37 43 13 1 50 28 11 50 49 92 54 69 81 65 67 13 93 34 72 72 30 1 42 77 77 70 2 64 81 90 23 37 23 79 95
69 27 42 10 82 58 26 87 70 28 51 58 13 60 83 86 42 10 72 28 34 41 18 3 67 65 38 81 57 50 14 98 58 61 63 56 7 78 89 35 65 75
86 86 33 60 30 48 28 92 33 40 66 35 10 99 37 92 82 28 52 69 44 94 8 52 47 32 35 8 64 97 43 49 15 41 89 0 12 48 23 51 74 33
91 0 54 90 97 19 80 78 31 44 40 87 99 25 83 38 92 93 52 11 60 34 40 97 85 29 40 5 91 92 10 49 78 79 71 77 73 93 20 97 26 76
90 82 78 59 18 89 59 49 24 72 80 8 67 8 77 3 70 7 96 74 22 11 19 61 56 90 63 83 16 32 52 41 54 13 62 96 60 15 4 99 36 80
98 32 87 84 40 17 6 70 41 82 49 23 58 5 21 95 96 16 78 78 79 58 77 50 7 29 81 95 78 76 53 99 84 65 93 8 72 43 29 14 68 55
91 73 22 48 51 86 44 46 77 17 29 16 74 91 69 12 46 93 91 15 49 57 40 52 36 51 87 26 62 55 83 94 80 97 65 65 13 61 78 78 78 40
11 47 45 70 75 89 50 49 33 65 14 82 7 32 96 67 22 82 10 41 31 87 5 79 21 38 51 47 8 46 76 59 89 22 66 86 55 28 14 60 53 77
48 3 61 31 82 55 97 6 52 21 96 81 21 55 47 24 18 35 76 74 59 98 74 53 22 35 43 88 53 32 47 80 26 78 50 1 61 99 55 63 16 73
61 45 73 74 50 53 81 87 99 10 43 65 72 29 81 12 76 81 47 90 71 5 72 32 89 20 65 31 58 93 6 78 48 6 71 66 96 97 20 94 29 88
9 84 69 78 17 15 26 84 68 6 28 97 18 90 99 85 86 99 20 10 71 13 15 85 18 80 31 67 87 44 86 7 60 27 74 31 52 71 68 93 85 37
12 17605
77 6 68 22 13 0 42 37 38 88 55 89
47 81 93 84 87 61 93 17 1 82 47 65
53 4 84 95 25 21 64 81 72 6 56 43
93 80 80 68 11 13 68 51 16 79 68 40
31 33 79 63 59 53 36 95 65 74 20 35
80 76 55 25 71 8 59 56 2 32 5 40
75 62 85 62 80 36 97 2 8 80 40 76
58 93 40 46 74 73 97 80 35 72 0 7
55 66 41 88 81 68 15 96 25 9 12 36
55 62 43 42 21 22 12 48 18 68 17 14
50 90 35 59 69 95 3 40 79 99 5 91
61 81 52 53 33 29 87 42 53 83 20 14

Output
Case #1
27 54
27 54
Case #2
1 0 0
63 1 121
121 0 243
...

Bài này là bài tính A^M, trong đó A là 1 matrix vuông n*n
cách làm: chia để trị
*/
package hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	final long MODULE = 100000007;
	long T;
	int n;
	long m;
	long [][]a;
	Scanner sc;
	
	public void input() {
		n = sc.nextInt();
		m = sc.nextLong();
		a = new long[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = sc.nextLong();
			}
		}
	}

	//Hàm tính x^m, trong đó x là matrix
	long [][] product(long [][]x, long m) {
		if(m == 1) return x;
		if(m % 2 == 0) {
			long [][]y = product(x, m/2);
			return matrixProduct(y, y);
		} else {
			long [][]y = product(x, (m-1)/2);
			return matrixProduct(matrixProduct(y, y), x);
		}
	}
	
	/*
	 * Nhân 2 ma trận a và b có cùng kích thước
	 */
	long [][] matrixProduct(long [][]a, long [][]b) {
		int len = a.length;
		long [][]c = new long[len+1][len+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				c[i][j] = 0;
				for(int k = 1; k <= n; k++) {
					c[i][j] += (a[i][k]*b[k][j]);
					if(c[i][j] > MODULE) {
						c[i][j] = c[i][j] % MODULE;
					}
					
				}
			}
		}
		return c;
	}
	
	public void printMatrix(long [][]a) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println(a[i][n]);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution s = new Solution();
		
		//file matrix.txt nằm ở thư mục gốc của project
		System.setIn(new FileInputStream(System.getProperty("user.dir") + "/matrix.txt"));
		s.sc = new Scanner(System.in);
		s.T = s.sc.nextInt();
		for (int tc = 1; tc <= s.T; tc++) {
			s.input();
			long [][]c = s.product(s.a, s.m);
			
			System.out.println("Case #" + tc);
			s.printMatrix(c);
		}
	}
}

