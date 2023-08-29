#include <iostream>
#include <string>
using namespace std;

class A
{
public:
    void fun()
    {
        cout << "fun()" << endl;
    }
};

class B : public A
{
public:
    void fun(int i)
    {
        cout << "fun(int i)" << endl;
    }
};

int main()
{
    B b;
    b.fun(10);//调用b的
    b.A::fun();//调用A的

}