"""
 * Python Tests
 *
 * Problem: I've Been Everywhere, Man
 * Link: https://open.kattis.com/problems/everywhere
 * @author  Zachary Friggstad
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/27/2021
 * Status : Accepted
 * Runtime: 0.08
 """
trips = int(input())

results = list()
for i in range(trips):
    numberCities = int(input())
    uniqueCities = set()
    for j in range(numberCities):
        uniqueCities.add(input())
    results.append(len(uniqueCities))

for value in results:
    print(value)
