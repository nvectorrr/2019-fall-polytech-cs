
def main():
    print('Count of teams: ')
    n = int(input())
    print('\nPrint 1 for first 3, or 2 for all: ')
    x = input()
    if  x == '1': 
        first3(n)
    if x == '2':
        all(n)
    if x != '1' and x != '2':
        print('Error')
        return 0


def first3(n):
    n = factorial(n) / factorial(n - 3)
    print('\nAnswer: ' + str(n))


def all(n):
    n = factorial(n)
    print('\nAnswer: ' + str(n))

def factorial(n):
    fac = 1
    while n > 1:
        fac *= n
        n -= 1
    return int(fac)

main()