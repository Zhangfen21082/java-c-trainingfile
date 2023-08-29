#include "test.h"

void Person::showInit(int number, int age) {
    this->_number = number;
    this->_age = age;

    cout << this->_number << " " << this->_age << endl;

}


