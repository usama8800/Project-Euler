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
            m = m[m[:, 0] <= limit * 2]
            m = m[m[:, 1] <= limit * 2]
        yield from m
        m = np.dot(m, uad)


def gen_all_pyth_trips(limit):
    for prim in gen_prim_pyth_trips(limit):
        primk = prim
        i = 2
        while primk[0] <= limit * 2 and primk[1] <= limit * 2:
            yield primk
            primk = prim*i
            i += 1


def sums(a, b, m):
    greater = max(a, b)
    lesser = a + b - greater
    diff = greater - lesser
    ret = 0
    if greater <= m:
        ret += lesser // 2
    if lesser <= m and diff <= lesser:
        ret += lesser - (greater + 1) // 2 + 1
    return ret


def num_shortest_int_paths(m):
    ret = 0
    for p in gen_all_pyth_trips(m):
        a, b, _ = p
        ret += sums(a, b, m)
    return ret


for i in range(1500, 2000):
    paths = num_shortest_int_paths(i)
    if paths > 1e6:
        print(i)
        break
