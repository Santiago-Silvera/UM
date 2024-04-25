h = int(input("Ingrese la altura de piramide: "))

def imprimirPira(h):
    stringToPrint = ""
    chars = -1
    for i in range(1, h + 1):
        chars += 2
        asteriks = "*" * chars
        whitespaces = " " * (h-i)
        stringToPrint = whitespaces + asteriks
        print(stringToPrint)

imprimirPira(h)