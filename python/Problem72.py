def phi(n):
	result = n
	p = 2
	while p * p <= n:
		if n % p == 0:
			while n % p == 0:
				n = n // p
			result = result * (1.0 - (1.0 / float(p)))
		p = p + 1
	if n > 1:
		result = result * (1.0 - (1.0 / float(n)))
	
	return int(result)


total = 0
d = 2
# while d <= 10:

while d <= 1000000:
	if d % 1000 == 0:
		print(d)
	total += phi(d)
	d += 1
print(total)
