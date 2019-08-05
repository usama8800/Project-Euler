import numpy as np


def gen_primes():
    D = {}
    q = 2
    while True:
        if q not in D:
            yield q
            D[q * q] = [q]
        else:
            for p in D[q]:
                D.setdefault(p + q, []).append(p)
            del D[q]
        q += 1


def ans(limit):
    limit = int(limit)
    xi = 0
    yi = 0
    zi = 0
    gen = gen_primes()
    primes = [next(gen)]
    x = primes[xi]
    y = primes[yi]
    z = primes[zi]
    lst = np.zeros(limit+1)
    while True:
        num1 = x ** 2 + y ** 3 + z ** 4
        num2 = x ** 2 + y ** 4 + z ** 3
        num3 = x ** 3 + y ** 2 + z ** 4
        num4 = x ** 3 + y ** 4 + z ** 2
        num5 = x ** 4 + y ** 2 + z ** 3
        num6 = x ** 4 + y ** 3 + z ** 2
        # print(x, y, z, ":", num1, num2, num3, num4, num5, num6)
        if num1 < limit:
            lst[num1] = 1
        if num2 < limit:
            lst[num2] = 1
        if num3 < limit:
            lst[num3] = 1
        if num4 < limit:
            lst[num4] = 1
        if num5 < limit:
            lst[num5] = 1
        if num6 < limit:
            lst[num6] = 1
        if num1 > limit and num2 > limit and num3 > limit and num4 > limit and num5 > limit and num6 > limit:
            if xi == yi and yi == zi:
                # for i in range(len(lst)):
                #     if lst[i]:
                #         print(i)
                return int(np.sum(lst))
            if zi == yi:
                xi += 1
                yi = xi
                x = primes[xi]
            else:
                yi += 1
            y = primes[yi]
            zi = yi
        else:
            zi += 1
        if zi >= len(primes):
            primes.append(next(gen))
        z = primes[zi]


print(ans(50e6))
