"""
 * Python Tests
 *
 * Problem: SMIL
 * Link: https://open.kattis.com/problems/smil
 * @author  Thore Husfeldt
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/25/2020
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.06
 """
smil = input()

for i in range(len(smil) - 1):
    if smil[i] == ':' or smil[i] == ';':
        if smil[i+1] == ')':
            print(i)
        if i < len(smil)-2 and smil[i+1] == '-' and smil[i+2] == ')':
            print(i)