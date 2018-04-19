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


start = 10 ** 7 + 1
end = 10 ** 8
s = ''
f = open('totients.txt', 'a')
while start <= end:
	order = phi(start)
	if start % 10000 == 0:
		print(start)
	s += str(order) + '\n'
	if len(s) > 5000:
		f.write(s)
		s = ''
	start += 1

f.write(s)
f.close()
