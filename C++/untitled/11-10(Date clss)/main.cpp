#include "date.h"

int main(){
    Date birth(1998, 12, 20);
    Date destroy(2020, 6, 15);
    Date date(2022, 12, 13);

    cout << (date - birth) << endl;
    cout << (date - destroy) << endl;

}
