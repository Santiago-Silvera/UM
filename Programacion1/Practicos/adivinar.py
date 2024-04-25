# SANTIAGO SILVERA - GRUPO 2

import random

# Variables
intentos = 5
toGuess = random.randint(1,100)

# DEBUG, NEED TO ERASE
print(toGuess)
# ---------------------

# Inicio un bucle
for i in range(intentos):
    guess = int(input("Adivina el numero entre 0 y 100: "))
    if guess == toGuess:
        print("Has adivinado!")
        break
    else:
        print(f"Lo siento, no has acertado. Te quedan {intentos - i - 1} intentos. ", end="")
        if (toGuess > guess):
            print("El numero a adivinar es mayor")
        else:
            print("El numero a adivinar es menor")
else:             
    print(f"Has perdido. El numero era {toGUess}")
