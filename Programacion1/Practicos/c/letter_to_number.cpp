#include <iostream>
#include <string>

int main()
{
    while (true)
    {
        std::string txt;
        std::cout << "Input text to convert: ";
        std::cin >> txt;
        for (int i=0; i<txt.length(); i++)
        {
            std::cout << int(txt[i]) << std::endl;
        }
    }
}