package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class NoteModel {

	private Long id;

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static void main(String[] args) {
		int input = -2147483648;
		int output = reverse(input);
		System.out.println("output " + output);
	}
	
	 public static int reverse(int x) {
	        int synal = 1;
	        if (x<0) {
	        	if (x<=Integer.MIN_VALUE) return 0;
	            synal =-1;
	        }
	        int absX = Math.abs(x);
	        int absXHandle = absX;
	        int digit = 0;
	        while(absXHandle != 0) {
	            digit ++;
	            absXHandle = (int)absXHandle/10;
	        }
	        if (digit>10) return 0;
	        int i=(int)Math.pow(10,digit-1);
	       
	        int result = 0;
	        int count =0;
	        while(i>0) {
	        	long value = ((long)(absX/i))*((long)Math.pow(10,count));
				long check = result +value;
	        	if (check>Integer.MAX_VALUE){
	        		return 0;
	        	}
	        	result = (int)check;
	            absX = absX%i;
	            i = i/10;
	            count++;
	            
	        }
	        return result*synal;
	        
	    }

	public static int search(int[] nums, int target) {
		int minId = findMinId(nums);
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start+end)/2;
			int realMid = (mid+minId)%nums.length;
			if (target == nums[realMid])
				return realMid;
			if (target > nums[realMid]) {
				start =mid+1;
			}
			else{
				end = mid-1;
			}
		}
		return -1;
	}

	private static int findMinId(int[] a) {
		int start = 0;
		int end = a.length - 1;
		while (start < end) {

			int mid = (start + end) / 2;
			if (a[mid] < a[end]) {
				end = mid;
			} else if (a[mid] > a[end]) {
				start = mid + 1;
			}

		}
		return start;
	}

	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		if (!s.equals("")) {
			char[] c = s.toCharArray();
			int length = c.length;
			if (length == 1)
				return 1;
			Set<Character> check = new HashSet<>();
			int i = 0;
			int j = 0;
			int tempMax = 0;
			while (i < length && j < length) {
				if (!check.contains(c[j])) {
					check.add(c[j]);
					j++;
				} else {
					while (i < j && c[i] != c[j]) {
						check.remove(c[i]);
						i++;
					}
					check.remove(c[i]);
					i++;
				}
				tempMax = check.size();
				if (tempMax > max) {
					max = tempMax;
				}
			}
		}

		return max;

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> output = new HashSet<>();
		int numLength = nums.length;
		if (numLength >= 3) {
			Arrays.sort(nums);
			int i = 0;
			int j = numLength - 1;
			int k = 1;
			while (i < numLength - 1 && k < numLength - 1) {
				int a = nums[i];
				int remain = -a;
				if (nums[k] + nums[j] == remain) {
					output.add(Arrays.asList(a, nums[k], nums[j]));
					k++;
					j--;
				} else {
					if (nums[k] + nums[j] > remain) {
						j--;
					} else {
						k++;
					}
				}
				if (k >= j) {
					i++;
					k = i + 1;
					j = numLength - 1;
				}
			}
		}
		return new ArrayList<>(output);
	}

	private static List<Set<Integer>> findTriples(List<Integer> a) {
		int size = a.size();
		List<Integer> count = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			count.add(0);
		}
		Collections.sort(a);
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		for (int i = 0; i < size; i++) {
			if (count.get(i) == 0) {
				count.set(i, 1);
				int fIndex = i;
				Integer first = a.get(fIndex);
				Integer expectedSecond = first + 1;
				Integer expectedThird = first + 2;
				Set<Integer> triple = new HashSet<Integer>();
				triple.add(first);
				int moveIndex = fIndex + 1;

				while (moveIndex < size && a.get(moveIndex) <= expectedThird) {
					if ((a.get(moveIndex) == expectedSecond || a.get(moveIndex) == expectedThird)
							&& count.get(moveIndex) == 0 && !triple.contains(a.get(moveIndex))) {
						triple.add(a.get(moveIndex));
						count.set(moveIndex, 1);
					}
					if (triple.size() == 3) {
						result.add(triple);
						break;
					}
					moveIndex++;
				}

			}
		}

		return result;
	}

	private static void printResult(List<List<Integer>> a) {
		for (List<Integer> set : a) {
			for (Integer s : set) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
