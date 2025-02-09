digits = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000, 1000: 'M', 500: 'D',
          100: 'C', 50: 'L', 10: 'X', 5: 'V', 1: 'I'}
before = {'M': 'C', 'D': 'C', 'C': 'X', 'L': 'X', 'X': 'I', 'V': 'I'}


def roman_to_dec(roman):
    if len(roman) == 1:
        return digits[roman[0]]
    if digits[roman[0]] >= digits[roman[1]]:
        return digits[roman[0]] + roman_to_dec(roman[1:])
    return roman_to_dec(roman[1:]) - digits[roman[0]]


def dec_to_roman(dec):
    if dec == 0:
        return ''
    if dec in digits:
        return digits[dec]
    for d in 'MDCLXVI':
        if dec > digits[d]:
            return d + dec_to_roman(dec - digits[d])
        elif dec >= digits[d] - digits[before[d]]:
            return before[d] + d + dec_to_roman(dec - digits[d] + digits[before[d]])


f = open('p089_roman.txt', 'r')
romans = f.read().split('\n')
f.close()

diff = 0
for i in range(len(romans)):
    num = roman_to_dec(romans[i])
    roman = dec_to_roman(num)
    diff += len(romans[i]) - len(roman)
print(diff)
