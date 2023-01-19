

> question 2a: 

   i: 4*n^2 + 50*n - 10 -> O(n^2)
   ii: 10*n + 4* log_2(n) + 30 -> O(n)
   iii: 13*n^3 22*n^2 + 50*n + 20 -> O(n^3)
   iv: 35 + 13*log_2(n) -> O(log(n))

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

> Question 2c

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
 
> Question 2e

Find big O and the number of iterations in the worst case

boolean harDuplikat(int tabell[], int n) {

for (int indeks = 0; indeks <= n - 2; indeks++) {
for (int igjen = indeks + 1; igjen <= n - 1; igjen++) {
if (tabell[indeks] == tabell[igjen]){
return true;
}
}
}
return false;
}

It's O(n^2) for the same reason as 2d is, even though there are less iterations of this loop as igjen is a higher value for each iteration
In the worst case the number of iterations is the sum of n + (n-1) + (n-2) + ... + 1 = (n^2 + n)/2.
This is becasue the iterator goes through the array less for each iteration 


> Question 2f

find big O for the following and rank them:
i. 𝑡_1(𝑛)=8𝑛+4𝑛^3 -> O(n^3)
ii. 𝑡_2(𝑛)=10*log(𝑛)+20 -> O(log(n))
iii. 𝑡_3(𝑛)=20𝑛+2𝑛log2𝑛+11 -> O(n*log(n))
iv. 𝑡_4(𝑛)=4log2𝑛+2𝑛 -> O(n)

in this case the second expression is the most effective. From best to worst:
1. t_2
2. t_4
3. t_3
4. t_1

> Question 2g

Don't understand this one
