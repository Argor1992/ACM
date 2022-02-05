"""
 * Python Tests
 *
 * Problem: Bela
 * Link: https://open.kattis.com/problems/bela
 * @author Branimir Filipović
 * @author Thorsten Zieres, 1297197
 * @version 1.0, 10/27/2021
 * Status : Accepted
 * Runtime: 0.06
 """
init = input().split()
hands = int(init[0])
dominant = init[1].lower()

result = 0
for i in range(hands*4):
    card = input()
    number = card[0].lower()
    suit = card[1].lower()

    if number == 'a':
        result += 11
    elif number == 'k':
        result += 4
    elif number == 'q':
        result += 3
    elif number == 'j':
        result += 20 if (suit == dominant) else 2
    elif number == 't':
        result += 10
    elif number == '9':
        result += 14 if (suit == dominant) else 0
    elif number == '8':
        result += 0
    elif number == '7':
        result += 0

print(result)