#include "stdio.h"
#include <stdlib.h>

void int_to_binary(int x, char *output)
{
    for (int i = 32*sizeof(char)-1; i>=0; i--)
    {
        output[i] = (x % 2) ? '1':'0';
        x /= 2;
    }
    printf("output: %s\n", output);
}

int main()
{
    int number = 123999;
    char *binary = (char*) calloc(32, sizeof(char));
    int_to_binary(number, binary);
    free(binary);
    return 0;
}