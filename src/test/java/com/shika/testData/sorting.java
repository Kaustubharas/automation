package com.shika.testData;

public class sorting {

	public static void main(String[] args) {

		int arr[] = { 10, 80, 20, 40, 90, 30 };

		int temp;

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {

					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

				}
			}

		}
		
		for(int a:arr) {
			
			System.out.println(a);
		}

	}

}
