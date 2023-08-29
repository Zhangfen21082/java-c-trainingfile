#include <iostream>
using namespace std;

class Date;
class Time
{
    friend ostream& operator<<(ostream& out, const Date &d); //输出
    friend istream& operator>>(istream& in, Date &d); //输出
    friend class Date; //友元类
public:
    Time(int hour, int minute, int second)
            :_hour(hour)
            ,_minute(minute)
            ,_second(second)
    {}
private:
    int _hour;
    int _minute;
    int _second;
};


class Date
{
    friend ostream& operator<<(ostream& out, const Date &d); //输出
    friend istream& operator>>(istream& in, Date &d); //输出

public:
    Date(int year, int month, int day, int hour, int minute, int second)
            :_year(year)
            ,_month(month)
            ,_day(day)
            ,_t(hour, minute, second)
    {}

private:
    int _year;
    int _month;
    int _day;

    Time _t;
};
// 输出
ostream& operator<<(ostream& out, const Date &d){
    out << d._year << "年" << d._month << "月" << d._day << "日" <<
        " " << d._t._hour << "时" << d._t._minute << "分" << d._t._second << "秒";//输出
    return out;
}

// 输入
istream& operator>>(istream& in, Date &d){
    in >> d._year >> d._month >> d._day >> d._t._hour >> d._t._minute >> d._t._second;
    return in;
}

int main()
{
    Date d1(2000, 1, 1, 10, 20, 25);
    cout << d1 << endl;
    cin >> d1;
    cout << d1 << endl;

}