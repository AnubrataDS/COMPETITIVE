
public class binarySearch {
	static int a[] = { 5,3,3,3,2,2,1 };
	static boolean isIncreasing = false;

	static int fn(int pos) {
		return a[pos];
	}

	static int binarySearchBound(int start, int end, int key, boolean findUpperBound) {
		int ans = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int val = fn(mid);
			if (val == key) {
				ans = mid;
				if (findUpperBound)
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				if (isIncreasing) {
					if (start == end && ans == -1) {
						int insertPos = -1;
						if (val > key)
							insertPos = start;
						else
							insertPos = start + 1;
						ans = -insertPos - 1;
					}
					if (val > key) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				} else {

					if (start == end && ans == -1) {
						int insertPos = -1;
						if (val < key)
							insertPos = start;
						else
							insertPos = start + 1;
						ans = -insertPos - 1;
					}
					if (val < key) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		System.out.println(binarySearchBound(0, a.length - 1, 2,false));
	}
}
