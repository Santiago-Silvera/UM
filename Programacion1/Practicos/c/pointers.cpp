#include <iostream>

int main()
{
    int n = 100;
    int *ptr = &n;
    printf("Value: %i \n", n);
    printf("Address: %i \n", ptr);    
    printf("Value again: %i \n", *ptr);
}