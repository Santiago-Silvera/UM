def isLeapYear(year):
    if ((year % 4 == 0 and year % 100 != 0) or (year % 4 == 0 and year % 400 == 0)):
        return True
    else:
        return False
print(isLeapYear(2100))