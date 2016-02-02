
public class Sort {
	int[] nums={20,49,7,50,45,25,36};
	public Sort(){

	}
	public void swap(int a,int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
	public void numstoString(){
		for(int a=0;a<nums.length;a++)
			System.out.print(nums[a]+" ");
		System.out.println();
	}
	public boolean bubbleUp(int a, int b){
		boolean sorted=true;
		for(int index=b; index>a ; index--){
			if(nums[index] > nums[index-1]){
				swap(index,index-1);

			}
		}
		return sorted;
	}
	public void shortBubble(){
		int current=0;
		boolean sorted = false;
		while((current<nums.length-1) && !sorted){
			sorted=bubbleUp(current,nums.length-1);
			current++;
		}

	}
	public  int selectKth(int k) {
		k=nums.length-k;		 
		int from = 0, to = nums.length - 1;

		// if from == to we reached the kth element
		while (from < to) {
			int r = from, w = to;
			int mid = nums[(r + w) / 2];

			// stop if the reader and writer meets
			while (r < w) {

				if (nums[r] >= mid) { // put the large values at the end
					swap(w,r);
					w--;
				} else { // the value is smaller than the pivot, skip
					r++;
				}
			}

			// if we stepped up (r++) we need to step one down
			if (nums[r] > mid)
				r--;

			// the r pointer is on the end of the first k elements
			if (k <= r) {
				to = r;
			} else {
				from = r + 1;
			}
		}

		return nums[k];
	}
	public void bubbleup2(int a, int b){
		for(int index=b;index>a;index--){
			if(nums[index] > nums[index-1])
				swap(index,index-1);
		}
	}
	public int findKth(int k){
		int current=0;
		while(current < k){
			bubbleup2(current,nums.length-1);
			current++;
		}

		return nums[k-1];
	}


}
