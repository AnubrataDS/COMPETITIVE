
public class ncrmodpmemoiz {

	// use this for more queries
	// precompute constant = O(max size)
	// per query : O(1)
	// m queries : O(max + m)
	//caution : memory overhead large
	final static int maxSize = 1000001;
	static int p = 1000000007;
	static long numInverse[] = new long[maxSize + 10];
	static long facInverse[] = new long[maxSize + 10];
	static long fact[] = new long[maxSize+10];
	static void preCompute() {
		numInverse[0] = 1 ;
		numInverse[1] = 1 ;
		for(int i = 2;i<= maxSize;i++) {
			numInverse[i] = (numInverse[(p%i)] * (p - p/i)) %p	;
		}
		facInverse[0] = 1 ;
		facInverse[1] = 1 ;
		for(int i = 2;i<= maxSize;i++) {
			facInverse[i] = (numInverse[i] * facInverse[i-1])%p ;
		}
		fact[0] = 1 ;
		fact[1] = 1 ;
		for (int i = 1 ;i <= maxSize; i++) 
            fact[i] = fact[i-1] * i % p; 
		numInverse = new long[1] ;	//GC original numInverse
	}
	static long nCrModPFermat(int n, int r) {

		// Base case
		if (r == 0)
			return 1;
		return (fact[n] * facInverse[r] % p * facInverse[n - r] % p) % p;
	}
	
	public static void main(String args[]) {
		preCompute();
		System.out.println(nCrModPFermat(15,4));
	}
	
}
