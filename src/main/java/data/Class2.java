package data;

import java.util.Scanner;

import annotation.MetodoVisiblePorParser;

public class Class2 {
	
	@MetodoVisiblePorParser(enabled = true)
	public void method1()
	{
		main1(null);
		main(null);
		main2(null);
		main3(null);
	}
	
	@MetodoVisiblePorParser(enabled = true)
	public void method1(String asd)
	{
		main1(null);
		main(null);
		main2(null);
		main3(null);
	}
	
	@MetodoVisiblePorParser(enabled = true, priority = 1)
	public int[][] multiply(int[][] A, int[][] B)
    {        
        int n = A.length;
        int[][] R = new int[n][n];
        /** base case **/
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            /** Dividing matrix B into 4 halves **/
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
            /** 
              M1 = (A11 + A22)(B11 + B22)
              M2 = (A21 + A22) B11
              M3 = A11 (B12 - B22)
              M4 = A22 (B21 - B11)
              M5 = (A11 + A12) B22
              M6 = (A21 - A11) (B11 + B12)
              M7 = (A12 - A22) (B21 + B22)
            **/
 
            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            /**
              C11 = M1 + M4 - M5 + M7
              C12 = M3 + M5
              C21 = M2 + M4
              C22 = M1 - M2 + M3 + M6
            **/
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            /** join 4 halves into one result matrix **/
            join(C11, R, 0 , 0);
            join(C12, R, 0 , n/2);
            join(C21, R, n/2, 0);
            join(C22, R, n/2, n/2);
        }
        /** return result **/    
        return R;
    }
	
    /** Funtion to sub two matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public int[][] sub(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
	
    /** Funtion to add two matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public int[][] add(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
	
    /** Funtion to split parent matrix into child matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void split(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
	
    /** Funtion to join child matrices intp parent matrix **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void join(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    
	
    /** Main function **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void main (String[] args) 
    {
        scan = new Scanner(System.in);
        System.out.println("Strassen Multiplication Algorithm Test\n");
        /** Make an object of Strassen class **/

 
        System.out.println("Enter order n :");
        int N = scan.nextInt();
        /** Accept two 2d matrices **/
        System.out.println("Enter N order matrix 1\n");
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = scan.nextInt();
 
        System.out.println("Enter N order matrix 2\n");
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                B[i][j] = scan.nextInt();
 
        int[][] C = multiply(A, B);
 
        System.out.println("\nProduct of matrices A and  B : ");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(C[i][j] +" ");
            System.out.println();
        }
    }
	
	 /** Function to calculate all primes less than n **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    private boolean[] calcPrimes(int limit)
    {
        /** initialize the sieve **/
        boolean[] prime = new boolean[limit + 1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));
 
        /** put in candidate primes: 
           integers which have an odd number of
           representations by certain quadratic forms **/
        for (int x = 1; x < root; x++)
        {
            for (int y = 1; y < root; y++)
            {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];
                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7)
                    prime[n] = !prime[n];
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }
        /** eliminate composites by sieving, omit multiples of its square **/
        for (int i = 5; i <= root; i++)
            if (prime[i])
                for (int j = i * i; j < limit; j += i * i)
                    prime[j] = false;
 
        return prime;
    }
	
    /** Function to get all primes **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void getPrimes(int N)
    {
        boolean[] primes = calcPrimes(N);
        display(primes);
    }
	
    /** Function to display all primes **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void display(boolean[] primes)
    {
        System.out.print("\nPrimes = ");
        for (int i = 2; i < primes.length; i++)
            if (primes[i])
                System.out.print(i +" ");
        System.out.println();
    }
	
    /** Main function **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void mainSieveOfAtkin (String[] args) 
    {
        scan = new Scanner(System.in);
        System.out.println("Sieve Of Atkin Prime Algorithm Test\n");
        /** Make an object of SieveOfAtkin class **/
        /** Accept n **/
        System.out.println("Enter number to find all primes less than the number\n");
        int n = scan.nextInt();
        getPrimes(n);        
    }
	
	private int[][] m;
    private int[][] s;
    private int     n;
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public void initOptimalParanthesizationUsingDP(int[] p)
    {
        n = p.length - 1; // how many matrices are in the chain
        m = new int[n + 1][n + 1]; // overallocate m, so that we don't use index
                                   // 0
        s = new int[n + 1][n + 1]; // same for s
        matrixChainOrder(p); // run the dynamic-programming algorithm
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    private void matrixChainOrder(int[] p)
    {
        // Initial the cost for the empty subproblems.
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;
        // Solve for chains of increasing length l.
        for (int l = 2; l <= n; l++)
        {
            for (int i = 1; i <= n - l + 1; i++)
            {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                // Check each possible split to see if it's better
                // than all seen so far.
                for (int k = i; k < j; k++)
                {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                    {
                        // q is the best split for this subproblem so far.
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    private String printOptimalParens(int i, int j)
    {
        if (i == j)
            return "A[" + i + "]";
        else
            return "(" + printOptimalParens(i, s[i][j])
                    + printOptimalParens(s[i][j] + 1, j) + ")";
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public String toString()
    {
        return printOptimalParens(1, n);
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public void mainOptimalParanthesizationUsingDP(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out
                .println("Enter the array p[], which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]");
        System.out.println("Enter the total length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the dimensions: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        initOptimalParanthesizationUsingDP(arr);
        System.out.println("Matrices are of order: ");
        for (int i = 1; i < arr.length; i++)
        {
            System.out.println("A" + i + "-->" + arr[i - 1] + "x" + arr[i]);
        }
        System.out.println(toString());
        sc.close();
    }
    
    @MetodoVisiblePorParser(enabled = true, priority = 1)
	public int[][] multiply1(int[][] A, int[][] B)
    {        
        int n = A.length;
        int[][] R = new int[n][n];
        /** base case **/
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            /** Dividing matrix B into 4 halves **/
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
            /** 
              M1 = (A11 + A22)(B11 + B22)
              M2 = (A21 + A22) B11
              M3 = A11 (B12 - B22)
              M4 = A22 (B21 - B11)
              M5 = (A11 + A12) B22
              M6 = (A21 - A11) (B11 + B12)
              M7 = (A12 - A22) (B21 + B22)
            **/
 
            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            /**
              C11 = M1 + M4 - M5 + M7
              C12 = M3 + M5
              C21 = M2 + M4
              C22 = M1 - M2 + M3 + M6
            **/
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            /** join 4 halves into one result matrix **/
            join(C11, R, 0 , 0);
            join(C12, R, 0 , n/2);
            join(C21, R, n/2, 0);
            join(C22, R, n/2, n/2);
        }
        /** return result **/    
        return R;
    }
	
    /** Funtion to sub two matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public int[][] sub1(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
	
    /** Funtion to add two matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public int[][] add1(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
	
    /** Funtion to split parent matrix into child matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void split1(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
	
    /** Funtion to join child matrices intp parent matrix **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void join1(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    
	
    /** Main function **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void main1 (String[] args) 
    {
        scan = new Scanner(System.in);
        System.out.println("Strassen Multiplication Algorithm Test\n");
        /** Make an object of Strassen class **/

 
        System.out.println("Enter order n :");
        int N = scan.nextInt();
        /** Accept two 2d matrices **/
        System.out.println("Enter N order matrix 1\n");
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = scan.nextInt();
 
        System.out.println("Enter N order matrix 2\n");
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                B[i][j] = scan.nextInt();
 
        int[][] C = multiply(A, B);
 
        System.out.println("\nProduct of matrices A and  B : ");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(C[i][j] +" ");
            System.out.println();
        }
    }
	
	 /** Function to calculate all primes less than n **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    private boolean[] calcPrimes1(int limit)
    {
        /** initialize the sieve **/
        boolean[] prime = new boolean[limit + 1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));
 
        /** put in candidate primes: 
           integers which have an odd number of
           representations by certain quadratic forms **/
        for (int x = 1; x < root; x++)
        {
            for (int y = 1; y < root; y++)
            {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];
                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7)
                    prime[n] = !prime[n];
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }
        /** eliminate composites by sieving, omit multiples of its square **/
        for (int i = 5; i <= root; i++)
            if (prime[i])
                for (int j = i * i; j < limit; j += i * i)
                    prime[j] = false;
 
        return prime;
    }
	
    /** Function to get all primes **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void getPrimes1(int N)
    {
        boolean[] primes = calcPrimes(N);
        display(primes);
    }
	
    /** Function to display all primes **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void display1(boolean[] primes)
    {
        System.out.print("\nPrimes = ");
        for (int i = 2; i < primes.length; i++)
            if (primes[i])
                System.out.print(i +" ");
        System.out.println();
    }
	
    /** Main function **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void mainSieveOfAtkin1 (String[] args) 
    {
        scan = new Scanner(System.in);
        System.out.println("Sieve Of Atkin Prime Algorithm Test\n");
        /** Make an object of SieveOfAtkin class **/
        /** Accept n **/
        System.out.println("Enter number to find all primes less than the number\n");
        int n = scan.nextInt();
        getPrimes(n);        
    }
	

 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public void initOptimalParanthesizationUsingDP1(int[] p)
    {
        n = p.length - 1; // how many matrices are in the chain
        m = new int[n + 1][n + 1]; // overallocate m, so that we don't use index
                                   // 0
        s = new int[n + 1][n + 1]; // same for s
        matrixChainOrder(p); // run the dynamic-programming algorithm
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    private void matrixChainOrder1(int[] p)
    {
        // Initial the cost for the empty subproblems.
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;
        // Solve for chains of increasing length l.
        for (int l = 2; l <= n; l++)
        {
            for (int i = 1; i <= n - l + 1; i++)
            {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                // Check each possible split to see if it's better
                // than all seen so far.
                for (int k = i; k < j; k++)
                {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                    {
                        // q is the best split for this subproblem so far.
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    private String printOptimalParens1(int i, int j)
    {
        if (i == j)
            return "A[" + i + "]";
        else
            return "(" + printOptimalParens(i, s[i][j])
                    + printOptimalParens(s[i][j] + 1, j) + ")";
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public String toString1()
    {
        return printOptimalParens(1, n);
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public void mainOptimalParanthesizationUsingDP1(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out
                .println("Enter the array p[], which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]");
        System.out.println("Enter the total length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the dimensions: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        initOptimalParanthesizationUsingDP(arr);
        System.out.println("Matrices are of order: ");
        for (int i = 1; i < arr.length; i++)
        {
            System.out.println("A" + i + "-->" + arr[i - 1] + "x" + arr[i]);
        }
        System.out.println(toString());
        sc.close();
    }
    
    @MetodoVisiblePorParser(enabled = true, priority = 1)
	public int[][] multiply2(int[][] A, int[][] B)
    {        
        int n = A.length;
        int[][] R = new int[n][n];
        /** base case **/
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            /** Dividing matrix B into 4 halves **/
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
            /** 
              M1 = (A11 + A22)(B11 + B22)
              M2 = (A21 + A22) B11
              M3 = A11 (B12 - B22)
              M4 = A22 (B21 - B11)
              M5 = (A11 + A12) B22
              M6 = (A21 - A11) (B11 + B12)
              M7 = (A12 - A22) (B21 + B22)
            **/
 
            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            /**
              C11 = M1 + M4 - M5 + M7
              C12 = M3 + M5
              C21 = M2 + M4
              C22 = M1 - M2 + M3 + M6
            **/
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            /** join 4 halves into one result matrix **/
            join(C11, R, 0 , 0);
            join(C12, R, 0 , n/2);
            join(C21, R, n/2, 0);
            join(C22, R, n/2, n/2);
        }
        /** return result **/    
        return R;
    }
	
    /** Funtion to sub two matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public int[][] sub2(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
	
    /** Funtion to add two matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public int[][] add2(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
	
    /** Funtion to split parent matrix into child matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void split2(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
	
    /** Funtion to join child matrices intp parent matrix **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void join2(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    
	
    /** Main function **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void main2 (String[] args) 
    {
		scan = new Scanner(System.in);
        System.out.println("Strassen Multiplication Algorithm Test\n");
        /** Make an object of Strassen class **/

 
        System.out.println("Enter order n :");
        int N = scan.nextInt();
        /** Accept two 2d matrices **/
        System.out.println("Enter N order matrix 1\n");
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = scan.nextInt();
 
        System.out.println("Enter N order matrix 2\n");
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                B[i][j] = scan.nextInt();
 
        int[][] C = multiply(A, B);
 
        System.out.println("\nProduct of matrices A and  B : ");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(C[i][j] +" ");
            System.out.println();
        }
    }
	
	 /** Function to calculate all primes less than n **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    private boolean[] calcPrimes2(int limit)
    {
        /** initialize the sieve **/
        boolean[] prime = new boolean[limit + 1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));
 
        /** put in candidate primes: 
           integers which have an odd number of
           representations by certain quadratic forms **/
        for (int x = 1; x < root; x++)
        {
            for (int y = 1; y < root; y++)
            {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];
                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7)
                    prime[n] = !prime[n];
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }
        /** eliminate composites by sieving, omit multiples of its square **/
        for (int i = 5; i <= root; i++)
            if (prime[i])
                for (int j = i * i; j < limit; j += i * i)
                    prime[j] = false;
 
        return prime;
    }
	
    /** Function to get all primes **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void getPrimes2(int N)
    {
        boolean[] primes = calcPrimes(N);
        display(primes);
    }
	
    /** Function to display all primes **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void display2(boolean[] primes)
    {
        System.out.print("\nPrimes = ");
        for (int i = 2; i < primes.length; i++)
            if (primes[i])
                System.out.print(i +" ");
        System.out.println();
    }
	
    /** Main function **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void mainSieveOfAtkin2 (String[] args) 
    {
        scan = new Scanner(System.in);
        System.out.println("Sieve Of Atkin Prime Algorithm Test\n");
        /** Make an object of SieveOfAtkin class **/
        /** Accept n **/
        System.out.println("Enter number to find all primes less than the number\n");
        int n = scan.nextInt();
        getPrimes(n);        
    }
	
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public void initOptimalParanthesizationUsingDP2(int[] p)
    {
        n = p.length - 1; // how many matrices are in the chain
        m = new int[n + 1][n + 1]; // overallocate m, so that we don't use index
                                   // 0
        s = new int[n + 1][n + 1]; // same for s
        matrixChainOrder(p); // run the dynamic-programming algorithm
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    private void matrixChainOrder2(int[] p)
    {
        // Initial the cost for the empty subproblems.
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;
        // Solve for chains of increasing length l.
        for (int l = 2; l <= n; l++)
        {
            for (int i = 1; i <= n - l + 1; i++)
            {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                // Check each possible split to see if it's better
                // than all seen so far.
                for (int k = i; k < j; k++)
                {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                    {
                        // q is the best split for this subproblem so far.
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    private String printOptimalParens2(int i, int j)
    {
        if (i == j)
            return "A[" + i + "]";
        else
            return "(" + printOptimalParens(i, s[i][j])
                    + printOptimalParens(s[i][j] + 1, j) + ")";
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public String toString2()
    {
        return printOptimalParens(1, n);
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public void mainOptimalParanthesizationUsingDP2(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out
                .println("Enter the array p[], which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]");
        System.out.println("Enter the total length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the dimensions: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        initOptimalParanthesizationUsingDP(arr);
        System.out.println("Matrices are of order: ");
        for (int i = 1; i < arr.length; i++)
        {
            System.out.println("A" + i + "-->" + arr[i - 1] + "x" + arr[i]);
        }
        System.out.println(toString());
        sc.close();
    }
    
    @MetodoVisiblePorParser(enabled = true, priority = 1)
	public int[][] multiply3(int[][] A, int[][] B)
    {        
        int n = A.length;
        int[][] R = new int[n][n];
        /** base case **/
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            /** Dividing matrix B into 4 halves **/
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
            /** 
              M1 = (A11 + A22)(B11 + B22)
              M2 = (A21 + A22) B11
              M3 = A11 (B12 - B22)
              M4 = A22 (B21 - B11)
              M5 = (A11 + A12) B22
              M6 = (A21 - A11) (B11 + B12)
              M7 = (A12 - A22) (B21 + B22)
            **/
 
            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            /**
              C11 = M1 + M4 - M5 + M7
              C12 = M3 + M5
              C21 = M2 + M4
              C22 = M1 - M2 + M3 + M6
            **/
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            /** join 4 halves into one result matrix **/
            join(C11, R, 0 , 0);
            join(C12, R, 0 , n/2);
            join(C21, R, n/2, 0);
            join(C22, R, n/2, n/2);
        }
        /** return result **/    
        return R;
    }
	
    /** Funtion to sub two matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public int[][] sub3(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
	
    /** Funtion to add two matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public int[][] add3(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
	
    /** Funtion to split parent matrix into child matrices **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void split3(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
	
    /** Funtion to join child matrices intp parent matrix **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void join3(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    
	
    /** Main function **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void main3 (String[] args) 
    {
        scan = new Scanner(System.in);
        System.out.println("Strassen Multiplication Algorithm Test\n");
        /** Make an object of Strassen class **/

 
        System.out.println("Enter order n :");
        int N = scan.nextInt();
        /** Accept two 2d matrices **/
        System.out.println("Enter N order matrix 1\n");
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = scan.nextInt();
 
        System.out.println("Enter N order matrix 2\n");
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                B[i][j] = scan.nextInt();
 
        int[][] C = multiply(A, B);
 
        System.out.println("\nProduct of matrices A and  B : ");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(C[i][j] +" ");
            System.out.println();
        }
    }
	
	 /** Function to calculate all primes less than n **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    private boolean[] calcPrimes3(int limit)
    {
        /** initialize the sieve **/
        boolean[] prime = new boolean[limit + 1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));
 
        /** put in candidate primes: 
           integers which have an odd number of
           representations by certain quadratic forms **/
        for (int x = 1; x < root; x++)
        {
            for (int y = 1; y < root; y++)
            {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];
                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7)
                    prime[n] = !prime[n];
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }
        /** eliminate composites by sieving, omit multiples of its square **/
        for (int i = 5; i <= root; i++)
            if (prime[i])
                for (int j = i * i; j < limit; j += i * i)
                    prime[j] = false;
 
        return prime;
    }
	
    /** Function to get all primes **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void getPrimes3(int N)
    {
        boolean[] primes = calcPrimes(N);
        display(primes);
    }
	
    /** Function to display all primes **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void display3(boolean[] primes)
    {
        System.out.print("\nPrimes = ");
        for (int i = 2; i < primes.length; i++)
            if (primes[i])
                System.out.print(i +" ");
        System.out.println();
    }
	
    /** Main function **/
	@MetodoVisiblePorParser(enabled = true, priority = 1)
    public void mainSieveOfAtkin3(String[] args) 
    {
        scan = new Scanner(System.in);
        System.out.println("Sieve Of Atkin Prime Algorithm Test\n");
        /** Make an object of SieveOfAtkin class **/
        /** Accept n **/
        System.out.println("Enter number to find all primes less than the number\n");
        int n = scan.nextInt();
        getPrimes(n);        
    }
	

	private Scanner scan;
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public void initOptimalParanthesizationUsingDP3(int[] p)
    {
        n = p.length - 1; // how many matrices are in the chain
        m = new int[n + 1][n + 1]; // overallocate m, so that we don't use index
                                   // 0
        s = new int[n + 1][n + 1]; // same for s
        matrixChainOrder(p); // run the dynamic-programming algorithm
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    private void matrixChainOrder3(int[] p)
    {
        // Initial the cost for the empty subproblems.
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;
        // Solve for chains of increasing length l.
        for (int l = 2; l <= n; l++)
        {
            for (int i = 1; i <= n - l + 1; i++)
            {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                // Check each possible split to see if it's better
                // than all seen so far.
                for (int k = i; k < j; k++)
                {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                    {
                        // q is the best split for this subproblem so far.
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    private String printOptimalParens3(int i, int j)
    {
        if (i == j)
            return "A[" + i + "]";
        else
            return "(" + printOptimalParens(i, s[i][j])
                    + printOptimalParens(s[i][j] + 1, j) + ")";
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public String toString3()
    {
        return printOptimalParens(1, n);
    }
 
    @MetodoVisiblePorParser(enabled = true, priority = 1)
    public void mainOptimalParanthesizationUsingDP3(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out
                .println("Enter the array p[], which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]");
        System.out.println("Enter the total length: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the dimensions: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        initOptimalParanthesizationUsingDP(arr);
        System.out.println("Matrices are of order: ");
        for (int i = 1; i < arr.length; i++)
        {
            System.out.println("A" + i + "-->" + arr[i - 1] + "x" + arr[i]);
        }
        System.out.println(toString());
        sc.close();
    }

}
