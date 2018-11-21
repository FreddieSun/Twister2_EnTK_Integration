from sys import argv
import random

script, value = argv
file = open('output1.txt', 'w+')

for i in range(int(value)):
    file.write("%d\n" % 1)
file.close()
