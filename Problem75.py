import numpy as np


def gen_prim_pyth_trips(limit=None):
    u = np.mat(' 1  2  2; -2 -1 -2; 2 2 3')
    a = np.mat(' 1  2  2;  2  1  2; 2 2 3')
    d = np.mat('-1 -2 -2;  2  1  2; 2 2 3')
    uad = np.array([u, a, d])
    m = np.array([3, 4, 5])
    while m.size:
        m = m.reshape(-1, 3)
        if limit:
            m = m[np.sum(m, axis=1) < limit]
        yield from m
        m = np.dot(m, uad)


def gen_all_pyth_trips(limit):
    for prim in gen_prim_pyth_trips(limit):
        primk = prim
        i = 2
        while np.sum(primk) <= limit:
            yield primk
            primk = prim*i
            i += 1


limit = 1500000
# limit = 300
sums_got = [0 for _ in range(limit+1)]
for prim in gen_all_pyth_trips(limit):
    sums_got[np.sum(prim)] += 1
print(sum(filter(lambda x: x == 1, sums_got)))
