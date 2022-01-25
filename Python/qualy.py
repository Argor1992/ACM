"""
 * Python Tests
 *
 * Problem: Quality-Adjusted Life-Year
 * Link: https://open.kattis.com/problems/qaly
 * @author Howard Cheng
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/27/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.6
 """

numberOfPeriods = int(input())

result = 0
for x in range(numberOfPeriods):
    values = input().split()
    result += float(values[0]) * float(values[1])

print(result)