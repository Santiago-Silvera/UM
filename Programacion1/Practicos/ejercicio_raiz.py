# Santiago Silvera
import math

# Para la ecuacion de segundo grado ax^2 + bx + c = 0
def calcular_raiz_pos(a, b, c):
    return ((-b)+(math.sqrt(b**2 - 4*a*c)))/(2*a)
    
def calcular_raiz_neg(a, b, c):
    return ((-b)-(math.sqrt(b**2 - 4*a*c)))/(2*a)

print(calcular_raiz_pos(1, -2, 1))
print(calcular_raiz_neg(1, -2, 1))
print(calcular_raiz_pos(1, -7, 12))
print(calcular_raiz_neg(1, -7, 12))

