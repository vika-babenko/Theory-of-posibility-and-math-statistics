m = 0
n = 0
for i in range(10000, 99999):
    n +=1
    if "8" in str(i):
        m +=1

print("Кількість підходящих варіантів: ", m)
print("Загальна кількість 5-розрядних чисел: ", n)
print("Ймовірність р = ", m/n)