#ifndef INC_11_10_DATE_CLSS__DATE_H
#define INC_11_10_DATE_CLSS__DATE_H
#include <iostream>
using namespace std;
class Date{
public:
    //构造函数
    explicit Date(int year = 2000, int month = 1, int day = 1);
    //拷贝构造
    Date(const Date &d);

    //输出
    void print() const;

    //重载 =
    Date& operator=(const Date &d);
    //日期+=天数
    Date& operator+=(int day);
    //日期+天数
    Date operator+(int day);
    //日期-=天数
    Date& operator-=(int day);
    //日期-天数
    Date operator-(int day);

    //计算日期差值
    int operator-(const Date &d);

    //前置++
    Date& operator++();
    //后置++
    Date operator++(int);
    //前置--
    Date& operator--();
    //后置--
    Date operator--(int);

    //大于号 >
    bool operator>(const Date &d);
    //等于号 >=
    bool operator>=(const Date &d);
    //小于号 <
    bool operator<(const Date &d);
    //等于号 <=
    bool operator<=(const Date &d);
    //等于号 ==
    bool operator==(const Date &d);
    //不等于 !=
    bool operator!=(const Date &d);


private:
    int _year;
    int _month;
    int _day;
};

#endif //INC_11_10_DATE_CLSS__DATE_H
