import random
import numpy as np


def die_roll(dice_sides):
    return random.randint(1, dice_sides), random.randint(1, dice_sides)


def get_roll(dice_sides):
    roll1, roll2 = die_roll(dice_sides)
    roll = roll1 + roll2
    if roll1 == roll2:
        roll3, roll4 = die_roll(dice_sides)
        roll += roll3 + roll4
        if roll3 == roll4:
            roll5, roll6 = die_roll(dice_sides)
            roll += roll5 + roll6
            if roll5 == roll6:
                roll = 0
    return roll


def simulate_monopoly(dice_sides):
    pos = 0
    turns = 100000
    counts = np.zeros(40)
    for _ in range(turns):
        counts[pos] += 1
        roll = get_roll(dice_sides)
        if roll == 0:
            pos = 10
            continue
        pos += roll
        pos %= 40
        if pos in [7, 22, 36]:  # Chance
            num = random.randint(1, 16)
            if num == 1:
                pos = 0
            if num == 2:
                pos = 10
            if num == 3:
                pos = 11
            if num == 4:
                pos = 24
            if num == 5:
                pos = 39
            if num == 6:
                pos = 5
            if num == 7 or num == 8:
                if pos == 7:
                    pos = 15
                if pos == 22:
                    pos = 25
                if pos == 36:
                    pos = 5
            if num == 9:
                if 12 <= pos <= 27:
                    pos = 28
                else:
                    pos = 12
            if num == 10:
                pos -= 3
        if pos in [2, 17, 33]:  # Community Chest
            num = random.randint(1, 16)
            if num == 1:
                pos = 0
            if num == 2:
                pos = 10
        if pos == 30:  # Go to Jail
            pos = 10
    probs = (counts / turns) * 100
    max_is = []
    for j in range(3):
        mmax = 0
        max_i = 0
        for i in range(len(probs)):
            if i in max_is:
                continue
            if probs[i] > mmax:
                mmax = probs[i]
                max_i = i
        max_is.append(max_i)
    return max_is


print(simulate_monopoly(4))
