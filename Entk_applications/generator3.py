from sys import argv
import random

script, value = argv
file = open('output3.txt', 'w+')

for i in range(int(value)):
    a = random.randint(1, 10)
    file.write("%d\n" % a)
file.close()
