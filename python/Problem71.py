min_n = n = 0
min_d = d = 1
min_r = min_n / min_d
max_n = 3
max_d = 7
max_r = max_n / max_d


while d <= 1000000:
	cur_r = n / d
	if cur_r <= min_r:
		n += 1
	elif cur_r >= max_r:
		d += 1
	else:
		min_n = n
		min_d = d
		min_r = cur_r
		
print(min_n, min_d, min_r)
