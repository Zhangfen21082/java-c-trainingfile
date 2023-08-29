#define _CRT_SECURE_NO_WARNINGS 1
#include <iostream>
#include "this.h"
#include <vector>

using namespace std;

//extern "C" int add(int left, int right)
//{
//	return left + right;
//}
//extern "C" double add(double left, double right)
//{
//	return left + right;
//}
//
//int main()
//{
//	int add_int = add(10, 20);
//	double add_double = add(3.14, 7.92);
//	printf("%d\n", add_int);
//	printf("%f\n", add_double);
//	return 0;
//}

//
//int main()
//{
//	int a = 10;
//	int& b = a;
//	cout << "a:" << a << endl << "b:" << b << endl;
//	cout << &a << endl << &b << endl;
//
//}


class NumArray {
public:
    vector<int> _nums;
    NumArray(vector<int>& nums)
    {
        _nums = nums;
    }

    int sumRange(int left, int right)
    {
        int ret = 0;
        for (int i = left; i <= right; i++)
        {
            ret += _nums[i];
        }
        return ret;
    }
};


//void Swap(int& x, int& y)
//{
//    int temp = x;
//    x = y;
//    y = temp;
//}

//函数做引用

//int& Sum(int x, int y)
//{
//    int ret = x + y;
//    return ret;
//}
//int main()
//{
//    int a = Sum(1, 2);
//    cout << a << endl;
//    cout << "Hello!" << endl;
//    cout << a << endl;
//}









    //const int a = 10;
    //int& b = a;

    //const int& a = 1;//常引用

    //double a = 3.14;
    //int b = a;//隐式转换

    //int& c = a;//错误
    //const int& d = a;//正确


inline int add(int x, int y) {
    return x + y;
}

int main()
{
    int arr[] = { 1, 2, 3, 4, 5 };
    for (auto e : arr)
    {
        cout << e << endl;
    }

}