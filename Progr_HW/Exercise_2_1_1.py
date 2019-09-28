def main():
	print('Count of id-s: ')
	n = int(input())
	id = [None] * n
	for i in range (0, n):
		id[i] = int(input())

	id = sorted(id)

	print('\nSorted mass: ')
	for k in range (0, n):
		print('\n' + str(id[k]))

	for j in range (0, n):
		result = binarySearch(id, 0, len(id) - 1, id[j])
		if result != j:
			if result == -1:
				print('\nFor index ' + str(j) + ' no same id-s')
			else:
				if j < result:
					print('\nFor index ' + str(j) + ' same id at index ' + str(result))
				else:
					print('\nFor index ' + str(result) + ' same id at index ' + str(j))

	
def binarySearch(id, l, r, x):
	if r >= l: 
		mid = l + (r - l) // 2
		if id[mid] == x: 
			return mid
		elif id[mid] > x:
			return binarySearch(id, l, mid-1, x)
		else: 
			return binarySearch(id, mid + 1, r, x)
	else:
		return -1

main()



	
	
