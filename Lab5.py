import random
import math
def get_t(l):
  if not l:
    return float('inf')
  return -math.log(random.random())/l


matrix = [[0, 0.5, 0.2, 0, 0],
          [1, 0, 0, 1, 3],
          [0, 1.5, 3, 1, 1],
          [1, 1, 2, 6, 4],
          [2, 1, 0, 4, 1]]


state = 1
t_count = [0 for _ in range(len(matrix))]

for i in range(1000):
  ts = [get_t(i) for i in matrix[state]]
  t_count[state] += min(ts)
  state = ts.index(min(ts))
print("Ймовірності")
print([i/sum(t_count) for i in t_count])