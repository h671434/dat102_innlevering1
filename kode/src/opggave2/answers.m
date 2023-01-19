

> question 2a:
>> i: 4*n^2 + 50*n - 10 -> O(n^2)
>> ii: 10*n + 4* log_2(n) + 30 -> O(n)
>> iii: 13*n^3 22*n^2 + 50*n + 20 -> O(n^3)
>> 35 + 13*log_2(n) -> O(log(n))

> question 2b
given the follwing algorithm find O and the amount of times "=" is used:
```java
sum = 0;
 for (int i = n; i > 1; i = i/2) {
  sum = sum + i;
 }
```
In each iteration the iterator is halved, and the process will continue until the iterator is greater than 1.
Thus, to find the number of iterations we have to use log base 2 e.g. given that n is 8 then we have 3 iterations and "=" is assigned thrice.
log_2(8) = 3 (1 : 8, 2 : 4, 3 : 2 )
Therefore O(log(n))

>Question 2c
(Same as 2b) for the following code:
sum = 0;
 for (int i = 1; i <= n; i++) {
  for (int j = 1; j <= n; j = j * 2) {
   sum += i * j;
  }
 }
 for each iteration of i we loop through the nested for loop n times, and we loop through the outer loop n times too.
 Thus, we can find that in total we iterate n * n times.
 Such that if n is 3 we loop through the loop a total of 3^2 = 9 times
 O(n^2)


 >Question 2d

 Big O notation for the are and circumfrance of a circle:
        > double area = 2 * Math.PI * r^2;
        > double circumfrance = 2 * Math.PI * r;
 The expression of the area is quadratic or a second degree polynomial and follows hence O(n^2)
 While the expression of the circumfrance is linear, hence, O(n)