
**Problem**: Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays

Error Cases
- Input-E1: num1=[] num2=[]
- Input-E2: num1=[] num2=[1]
- Input-E3: num1=[1] num2=[]
- Input-E4: num1=[] num2=[1,2]
- Input-E5: num1=[1,2] num2=[]


Happy Path
- Input-H1:
- Input-H2:

ALG-1: merge-sort, then find median
- Time Complexity : O(n+m)
- Space Complexity: O(n+m)

ALG-2: find ((m+n)/2)th element
- Time Complexity : O(n+m)
- Space Complexity: O(1)

if (m+n) is an odd number, 
then median_idx=(m+n)/2 in the merged array.  

Which element of num1 or num2 will be the 
median_idx element of merged array does not require merging arrays. 
Therefore, it is feasible to have O(1) space complexity. 

***
