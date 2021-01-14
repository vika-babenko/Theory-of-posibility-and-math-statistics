import math
import scipy.stats

x1 = [12, 11, 9, 16, 10, 6, 7, 14, 5]

x = sorted(x1)
average_value_of_x = sum(x)/len(x)


an = [2.06, 2.32, 2.55, 2.7, 2.8, 2.95, 3.1]
#print(average_value_of_x)
if len(x) <= 10:
    for i in range(len(an)):
        j = len(x) - 4
    sigma = (x[-1] - x[0]) / an[j]
print(an[j])
d = 0
if len(x) > 10:
    for i in range(len(x)):
        d += ((x[i] - average_value_of_x) ** 2)
        dispersion = d / (len(x) - 1)
    sigma = math.sqrt(dispersion)

if x[2] != x[3]:
    limit_1 = (x[2] + x[3])/2

else:
    limit_1 = (x[4] + x[5])/2


if x[6] != x[7]:
    limit_2 = (x[6] + x[7])/2
interval_1 = x[0:3]

print(interval_1)
interval_2 = x[3:7]
print(interval_2)
interval_3 = x[7:]
print(interval_3)

m1 = len(interval_1)
m2 = len(interval_2)
m3 = len(interval_3)


p_1 = scipy.stats.norm(average_value_of_x,sigma).cdf(limit_1)
p_2 = scipy.stats.norm(average_value_of_x, sigma).cdf(limit_2) - scipy.stats.norm(average_value_of_x,sigma).cdf(limit_1)
p_3 = 1 - p_1 - p_2

hi_1 = 0
m = [m1, m2, m3]
p_list = [p_1, p_2, p_3]
for k in range(len(m)):
    hi_1 += ((m[k]) ** 2) / (len(x) * p_list[k])
hi = hi_1 - len(x)


print("Середньоквадратичне відхилення: ", sigma)
print("Математичне очікування: ", average_value_of_x)
print("Ймовірність для першого інтервалу = ", p_1)
print("Ймовірність для другого інтервалу = ", p_2)
print("Ймовірність для третього інтервалу = ", p_3)
print("Критерій хі квадрат = ", hi)

