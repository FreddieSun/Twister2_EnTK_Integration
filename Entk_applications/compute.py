from sys import argv
from functools import reduce

script, file = argv

with open(file) as f:
    my_list = [int(i) for i in f]

sum_of_all_numbers = reduce(lambda q, p: p + q, my_list)
f.close()

k = open('compute_output1.txt', 'w+')
print(sum_of_all_numbers)
k.write("%d\n" % sum_of_all_numbers)
k.close()

