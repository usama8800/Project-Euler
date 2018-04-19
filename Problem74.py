import math


def factorial_chain(chain_range, req_len):
    """solves any problem in the form of pr74 from EulerProject, input is required range and required chain length"""
    total_chains = 0
    chain_dict = {1: 0}
    for i in range(1, chain_range + 1):
        if i % 1000 == 0:
            print(i)
        if i in chain_dict:
            if chain_dict[i] == req_len:
                total_chains += 1
        else:
            temp_length = chain_len(i, chain_dict)
            chain_dict[i] = temp_length
            if temp_length == req_len:
                total_chains += 1
    return total_chains


def chain_len(n, chain_dict):
    """a helper function for factorial_chain that finds the chain length for a number n"""
    chain = [n]
    last_num = chain[-1]
    while last_num not in chain[:-1]:
        temp_num = 0
        for j in range(len(str(last_num))):
            temp_num += math.factorial(int(str(last_num)[j]))
        if temp_num in chain_dict:
            return len(chain) + chain_dict[temp_num]
        chain.append(temp_num)
        last_num = chain[-1]
    return len(chain) - 1


print(factorial_chain(10 ** 6, 60))
