#include <stdio.h>

int power(int base, unsigned int exponent) {
    int resultado = base;
    for (int i = 0; i < exponent-1; i++) {
        resultado *= base;
    }
    return resultado;
}

int main() {
    int input_num;
    printf("Introduzca un numero: ");
    scanf("%d", &input_num);
    int cube = power(input_num, 3);
    printf("El cubo del numero ingresado es %d\n", cube);
    int lowered_num = input_num - (input_num % 2);
    for (int i = 2; i <= 6; i+=2) {
        printf("El cubo del siguente numero[%d] es %d\n", lowered_num+i, power(lowered_num+i, 3));
    }
}
