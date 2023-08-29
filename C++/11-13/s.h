#ifndef INC_11_13_S_H
#define INC_11_13_S_H

#include <iostream>
using namespace std;

template<class T, size_t N = 100>
class Stack
{
public:
    Stack()
            :_arr(new T[N])
            ,_top(0)
            ,_capacity(0)
    {}

    ~Stack()
    {
        delete[] _arr;
        _arr = nullptr;
        _capacity=_top = 0;
    }

    //入栈操作
    void push(const T &arr);

private:
    T* _arr;
    int _top;
    int	_capacity;
};

#endif //INC_11_13_S_H
