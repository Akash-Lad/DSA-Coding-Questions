class MinimumDistance
{
	int minDist(int arr[], int n, int x, int y)
	{
		
	int i = 0, prev = -1, min_dist = Integer.MAX_VALUE;
	
	for(i=0 ; i<n ; i++)
	{
		if(arr[i] ==x || arr[i] == y)
		{
			if(prev != -1 && arr[i] != arr[prev])
				min_dist = Math.min(min_dist,i-prev);
		
			prev = i;
		}
	}

	if(min_dist == Integer.MAX_VALUE)
		return -1;

	return min_dist;
}


	public static void main(String[] args) {
		MinimumDistance min = new MinimumDistance();
		int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
		int n = arr.length;
		int x = 3;
		int y = 6;

		System.out.println("Minimum distance between " + x + " and " + y + " is " + min.minDist(arr, n, x, y));
	}
}
