def main():
    print('Input cordinates of first: ')
    print('\nx1: ')
    x1 = float(input())
    print('\nx2: ')
    x2 = float(input())
    print('\ny1: ')
    y1 = float(input())
    print('\ny2: ')
    y2 = float(input())

    print('\nInput cordinates of second: ')
    print('\na1: ')
    a1 = float(input())
    print('\na2: ')
    a2 = float(input())
    print('\nb1: ')
    b1 = float(input())
    print('\nb2: ')
    b2 = float(input())

    x3 = x2
    y3 = y1
    x4 = x1
    y4 = y2

    a3 = a2
    b3 = b1
    a4 = a1
    b4 = b2

    n = 0
    
    if a1 > x3:
        print('Ok')
        n = n + 1
    if b1 > y4:
        print('Ok')
        n = n + 1
    if x1 > a3:
        print('Ok')
        n = n + 1
    if y1 > b4:
        print('Ok')
        n = n + 1
    if n == 0:
        print('Peresekayutsya')

main()