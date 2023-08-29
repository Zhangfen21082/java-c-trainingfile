function Student(name, age, content) {
    this.name = name;
    this.age = age;
    this.say = function (){
        console.log(this.name, content);
    }
}

var obj1 = new Student("张三", 18, "你好");
var obj2 = new Student("李四", 28, "拜拜");
var obj3 = new Student("王五", 21, "好的");

console.log(obj1);
obj1.say();