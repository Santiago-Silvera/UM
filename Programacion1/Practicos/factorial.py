number = int(input("enter a number to calculate the factorial: "))
factorial = 1
tmp_fac = factorial
for i in range(number):
    factorial *= tmp_fac
    tmp_fac += 1

print(factorial)