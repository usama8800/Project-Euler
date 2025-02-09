import numpy as np

mat = np.loadtxt('p081_matrix.txt', delimiter=',')
# mat = np.asarray(
#     [
#         [131, 673, 234, 103, 18],
#         [201, 96, 342, 965, 150],
#         [630, 803, 746, 422, 111],
#         [537, 699, 497, 121, 956],
#         [805, 732, 524, 37, 331]
#     ]
# )
opt = np.zeros(mat.shape)

for i in range(len(opt)):
    for j in range(len(opt[0])):
        top = 0
        left = 0
        if i != 0 or j != 0:
            if i == 0:
                top = opt[i, j - 1]
                left = opt[i, j - 1]
            elif j == 0:
                top = opt[i - 1, j]
                left = opt[i - 1, j]
            else:
                top = opt[i - 1, j]
                left = opt[i, j - 1]
        opt[i, j] = min(top, left) + mat[i, j]
print(opt[-1, -1])
