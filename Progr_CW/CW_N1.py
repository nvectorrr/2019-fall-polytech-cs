import random

global xn
global xn_1

def main():
   
    a = random.randint(750, 1000)
    m = random.randint(200, 750)
    c = random.randint(100, 150)
    x0 = random.randint(1, 100)
    
    xn_1 = x0
    
    print('Input count of rand numbers: ')
    n = int(input())

    while n > 0:
        xn = (xn_1 * a + c) % m 
        print(xn)
        xn_1 = xn
        n = n - 1

main()

