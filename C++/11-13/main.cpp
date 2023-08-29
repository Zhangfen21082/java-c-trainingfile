#include <iostream>
using namespace std;


template<class T1,class T2>
class Test
{
public:
    Test()
    {
        cout << "调用了原生模板" << endl;
    }

private:
    T1 _t1;
    T2 _t2;
};
template<>
class Test<int,double>//类模板的特丽华
{
public:
    Test()
    {
        cout << "调用了特化模板" << endl;
    }

private:
    int _t1;
    double _t2;
};

int main()
{
    Test<int, int> t1;
    Test<int, double> t2;
}
