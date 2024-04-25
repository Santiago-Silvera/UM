def calcSumNPrimeros(a0, dif, n):
    sum = a0
    for i in range(n):
        sum += dif
    return sum


print(calcSumNPrimeros(8, 31, 100))