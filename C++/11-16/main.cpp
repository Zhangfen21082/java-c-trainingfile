#include <iostream>
#include <set>
using namespace std;

int main()
{
    int array[] = { 19,11,3,3,3,5,5,7,9 };
    set<int> test_set(array, array + sizeof(array) / sizeof(array[0]));
    cout << "set中有效元素个数为" << test_set.size() << endl;

    auto it = test_set.begin();
    while (it != test_set.end())
    {
        cout << *it << " ";
        ++it;
    }
    cout << endl;

    cout << "set中3出现了" << test_set.count(3) << "次" << endl;
}