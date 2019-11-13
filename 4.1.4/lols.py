def longest_unique_substr(S):
  # This should be replaced by an array (size = alphabet size).
  last_occurrence = {} 
  longest_len_so_far = 0
  longest_pos_so_far = 0
  curr_starting_pos = 0
  curr_length = 0

  for k, c in enumerate(S):
    l = last_occurrence.get(c, -1)
    # If no repetition within window, no problems.
    if l < curr_starting_pos: 
        curr_length += 1
    else:
        # Check if it is the longest so far
        if curr_length > longest_len_so_far: 
            longest_pos_so_far = curr_starting_pos
            longest_len_so_far = curr_length
        # Cut the prefix that has repetition
        curr_length -= l - curr_starting_pos
        curr_starting_pos = l + 1
    # In any case, update last_occurrence
    last_occurrence[c] = k

  # Maybe the longest substring is a suffix
  if curr_length > longest_len_so_far:
    longest_pos_so_far = curr_starting_pos
    longest_len_so_far = curr_length

  return S[longest_pos_so_far:longest_pos_so_far + longest_len_so_far]


def tester(S, res, testId):
    if longest_unique_substr(S) == res:
        print("OK - Test " + str(testId))



def main():
    S1 = "aaaaasdfghjkkkkkiretuoe"
    tester(S1, "asdfghjk", 1)
    
    S2 = "moghgkkgopdk"
    tester(S2, "kgopd", 2)

    S3 = "iuydfssssssssssssssssssaopfjpo"
    tester(S3, "iuydfs", 3)

    S4 = "iiasdfii"
    tester(S4, "iasdf", 4)

    S5 = "r1u1tg1y1o"
    tester(S5, "u1tg", 5)

main()