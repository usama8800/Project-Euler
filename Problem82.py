import numpy as np
from heapq import *


def heapupdate(heap, s, i, j):
    for k in range(len(heap)):
        if k[1] == i and k[2] == j:
            heap[k] = (s, i, j)
    heapify(heap)


mat = np.loadtxt('p082_matrix.txt', delimiter=',')
# mat = np.asarray(
#     [
#         [131, 673, 234, 103, 18],
#         [201, 96, 342, 965, 150],
#         [630, 803, 746, 422, 111],
#         [537, 699, 497, 121, 956],
#         [805, 732, 524, 37, 331]
#     ]
# )

heap = []
for i, v in enumerate(mat):
    heap.append((v[0], i, 0))
heapify(heap)

opt = np.zeros(mat.shape)
while heap:
    _, i, j = heappop(heap)
    if j == 0:
        opt[i, j] = mat[i, j]
    try:
        s = mat[i, j+1] + opt[i, j]
        if opt[i, j+1] == 0 or s < opt[i, j+1]:
            if opt[i, j+1] == 0:
                heappush(heap, (s, i, j+1))
            else:
                heapupdate(heap, s, i, j+1)
            opt[i, j+1] = s
    except IndexError:
        pass
    try:
        s = mat[i+1, j] + opt[i, j]
        if opt[i+1, j] == 0 or s < opt[i+1, j]:
            if opt[i+1, j] == 0:
                heappush(heap, (s, i+1, j))
            else:
                heapupdate(heap, s, i+1, j)
            opt[i+1, j] = s
    except IndexError:
        pass
    try:
        s = mat[i-1, j] + opt[i, j]
        if opt[i-1, j] == 0 or s < opt[i-1, j]:
            if opt[i-1, j] == 0:
                heappush(heap, (s, i-1, j))
            else:
                heapupdate(heap, s, i-1, j)
            opt[i-1, j] = s
    except IndexError:
        pass
print(np.min(opt[:, -1]))
