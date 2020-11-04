import random
import math

length = 1000
# значення a and b
a = 1
b = 1

# задаємо порожні x y
x = []
y = []
counter = 0
for i in range(length):
    r = random.random()
    l = random.random()
    x.append(a*math.sqrt(r))
    y.append(b-b*x[i]/a + l*(b*x[i]/a))
    if x[-1] < 0.5:
        counter +=1

m_X = sum(x)/length
m_Y = sum(y)/length
print("Математичне очікування X:",m_X)
print("Математичне очікування Y:",m_Y)

D_X = sum([i**2 for i in x])/length - m_X**2
D_Y = sum([i**2 for i in y])/length - m_Y**2
print("Дисперсія X:", D_X)
print("Дисперсія Y:", D_Y)

print("Середньоквадратичне відхилення X:", math.sqrt(D_X))
print("Середньоквадратичне відхилення Y:", math.sqrt(D_Y))

cov = sum([x[i]*y[i] for i in range(length)])/length - m_X*m_Y
print("Коваріація:", cov)

print("Коефіцієнт кореляції:", cov/math.sqrt(D_X*D_Y))
print("p = ", counter/length)


