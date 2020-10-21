"""
Rangoli
https://en.wikipedia.org/wiki/Rangoli
"""
import string


def print_rangoli(size):
    strings = string.ascii_lowercase[0:size]

    for i in range(size-1, -size, -1):
        x = abs(i)
        if x >= 0:
            line = strings[size:x:-1]+strings[x:size]
            print ("--"*x+ '-'.join(line)+"--"*x)



if __name__ == '__main__':
    n = int(input())
    print_rangoli(n)