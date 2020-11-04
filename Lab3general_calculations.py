import math
import random
A = 1
B = 1
def values(a, b):
    val = dict()
    val['Математичне очікування Х'] = 2*a/3  # математичне очікування Х
    val['Математичне очікування Y'] = 2*b/3 # математичне очікування Y
    val['Дисперсія X'] = a**2 /18  # диперсія X
    val['Дисперсія Y'] = b**2 /18  # диперсія Y
    val['Середньоквадратичне відхилення X'] = a/(3*math.sqrt(2))  # середньоквадратичне відхилення X
    val['Середньоквадратичне відхилення Y'] = b/(3*math.sqrt(2)) # середньоквадратичне відхилення Y
    val['Коваріація'] = -a*b/36
    val['Коефіцієнт кореляції'] = -1/2
    return val

a = values(A, B)
for i in a:
    print('%-35s'%i, a[i])
print()
x =[]
y =[]
for i in range(1000):
    r = random.random()
    l = random.random()
    x.append(A*math.sqrt(r))
    y.append(B-B*x[i]/A + l*(B*x[i]/A))
m_X = sum(x)/1000
m_Y = sum(y)/1000
print("Мат очікування X:",m_X)
print("Мат очікування Y:",m_Y)
D_X = sum([i**2 for i in x])/1000 - m_X**2
D_Y = sum([i**2 for i in y])/1000 - m_Y**2
print("Дисперсія X:", D_X)
print("Дисперсія Y:", D_Y)
print("Середньоквадратичне відхилення X:", math.sqrt(D_X))
print("Середньоквадратичне відхилення Y:", math.sqrt(D_Y))
cov = sum([x[i]*y[i] for i in range(1000)])/1000 - m_X*m_Y

print("Коваріація:", cov)
print("Коеф кореляції:", cov/math.sqrt(D_X*D_Y))
