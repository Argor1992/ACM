"""
 * Python Tests
 *
 * Problem: Reverse
 * Link: https://open.kattis.com/problems/ofugsnuid
 * @author Ómar Högni Guðmarsson
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/27/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.18
 """
amount = int(input())
numbers = []

for i in range(amount):
    numbers.append(input())

for number in reversed(numbers):
    print(number)