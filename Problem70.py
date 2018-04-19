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


def perm(s1, s2):
	if len(s1) != len(s2):
		return False
	dic = {}
	for c in s1:
		if c not in dic:
			dic[c] = 1
		else:
			dic[c] += 1
	i = 0
	while True:
		if s2[i] not in dic:
			return False
		if dic[s2[i]] == 0:
			return False
		dic[s2[i]] -= 1
		if dic[s2[i]] == 0:
			del dic[s2[i]]
		if len(dic) == 0:
			return True
		i += 1
		if i == len(s2):
			i = 0


start = 87109
min_r = start
min_n = start
for n in range(start, 10 ** 7):
	order = phi(n)
	r = n / order
	if r < min_r and perm(str(order), str(n)):
		min_r = r
		min_n = n
	if n % 10000 == 0:
		print(n)
print(min_n)
