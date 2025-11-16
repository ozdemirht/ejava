
**Category**: Dynamic Programming

**Problem**: There are n stairs, and a person standing at the bottom wants to climb stairs to reach the top.
The person can climb either 1 stair or 2 stairs at a time,
the task is to count the number of ways that a person can reach at the top.

**Solution**

Approach like Fibonacci

count(n) = count(n-1)+count(n-2)
<br>where base cases are 
 - count(0)=1
 - count(1)=1

**File**: [dp_p1_java](./dp_p1.java)

Solutions
  - memoization
  - tabulation, Space complexity: O(n)
    - count[0]=1
    - count[1]=1
    - for(i=2;i<=n;i++) 
      - count[i] = count[i-1]+count[i-2]
    - return count[n]
  - tabulation, space complexity: O(1)


***
