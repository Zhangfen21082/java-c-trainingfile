#include "date.h"
//获取某月天数
inline int getMonthDay(int year, int month) {
    //建立一个月份数组，2月默认为28天
    int month_days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //如果是闰年，2月将会被设定为29天
    if((year % 4 == 0 && year % 100 !=0) || year % 400 == 0){
        month_days[month-1] = 29;
    }
    return month_days[month-1];
}

//输出
void Date::print() const{
    cout << _year << " 年 " << _month << " 月 " << _day << " 日 " << endl;
}

//构造函数
Date::Date(int year, int month, int day) {
    //year不能为负数
    //month只能在区间[0, 12]
    //day必须为正数，且要在对应月份的天数范围内
    if(year >= 0 && month > 0 && month < 13 && day > 0 && day < getMonthDay(year, month))
    {
        _year = year;
        _month = month;
        _day = day;
    }else{
        cout << "非法输入" << endl;
        return;
    }
}

//拷贝构造
Date::Date(const Date &d) {
    _year = d._year;
    _month = d._month;
    _day = d._day;
}

//重载 =
Date& Date::operator=(const Date &d) {
    if(this != &d){
        _year = d._year;
        _month = d._month;
        _day = d._day;
    }
    return *this;
}

//日期+=天数
Date& Date::operator+=(int day) {
    _day = _day + day;
    while(_day > getMonthDay(_year, _month)){
        _day -= getMonthDay(_year, _month);
        _month++;
        if(_month == 13){
            _month = 1;
            _year++;
        }
    }
    return (*this);
}

//日期+天数
Date Date::operator+(int day) {
    Date res(*this);
    res += day;
    return res;
}

//日期-=天数
Date& Date::operator-=(int day) {
    _day = _day - day;
    while(_day < 0){
        _month--;
        _day = _day + getMonthDay(_year, _month);
        if(_month == 0){
            _year--;
            _month = 13; //注意不重要设置为12，否则下次循环直接会变为11
        }
    }
    return (*this);
}

//日期-天数
Date Date::operator-(int day){
    Date res(*this);
    res -= day;
    return res;
}

//前置++
Date& Date::operator++(){
    (*this) += 1;
    return (*this);
}
//后置++
Date Date::operator++(int){
    Date res(*this);
    (*this) += 1;
    return res;
}

//前置--
Date& Date::operator--(){
    (*this) -= 1;
    return (*this);
}
//后置--
Date Date::operator--(int){
    Date res(*this);
    (*this) -= 1;
    return res;
}

//等于号 ==
bool Date::operator==(const Date &d){
    return _year == d._year && _month == d._month && _day == d._day;
}
//不等于 !=
bool Date::operator!=(const Date &d){
    return !((*this) == d);
}

//大于号 >
bool Date :: operator>(const Date &d){
    if(_year > d._year){
        return true;
    }else if(_year == d._year){
        if(_month > d._month) {
            return true;
        }else if(_month == d._month){
            if(_day > d._day){
                return true;
            }
            return false;
        }
        return false;
    }
    return false;
}

//等于号 >=
bool Date::operator>=(const Date &d){
    return (*this) == d && (*this) > d;
}
//小于号 <
bool Date::operator<(const Date &d){
    return !(*(this) >= d);
}
//等于号 <=
bool Date::operator<=(const Date &d){
    return !((*this) > d);
}

//计算日期差值
int Date::operator-(const Date &d){
    Date Max = (*this);
    Date Min = d;

    int gap = 0;
    while (Min != Max){
        Min++;
        gap++;
    }
    return gap;
}