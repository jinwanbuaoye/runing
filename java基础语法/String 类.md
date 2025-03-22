# **String** **类**

#### 1. String类的重要性

在C语言中已经涉及到字符串了，但是在C语言中要表示字符串只能使用字符数组或者字符指针，可以使用标准库提供的字符串系列函数完成大部分操作，但是这种将数据和操作数据方法分离开的方式不符合面相对象的思想，而字符串应用又非常广泛，因此Java语言专门提供了String类。

------

#### **2.** **常用方法**

###### **2.1** **字符串构造**

```
public static void main(String[] args) {
    // 使用常量串构造
    String s1 = "hello bit";
    System.out.println(s1);
    
    // 直接newString对象
    String s2 = new String("hello bit");
    System.out.println(s1);
    
    // 使用字符数组进行构造
    char[] array = {'h','e','l','l','o','b','i','t'};
    String s3 = new String(array);
    System.out.println(s1);
}
```

![image-20230401100008915](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401100008915.png)

![image-20230401100553255](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401100553255.png)

2. 在Java中“”引起来的也是String类型对象。

```
// 打印"hello"字符串(String对象)的长度

System.out.println("hello".length());
```

------

###### 2.2 String对象的比较

**1.==比较是否引用同一个对象**

注意：对于内置类型，==比较的是变量中的值；对于引用类型==比较的是引用中的地址。

```
public static void main(String[] args) {
    int a = 10;
    int b = 20;
    int c = 10;
    
    // 对于基本类型变量，==比较两个变量中存储的值是否相同
    System.out.println(a == b); // false
    System.out.println(a == c); // true
    
    // 对于引用类型变量，==比较两个引用变量引用的是否为同一个对象
    String s1 = new String("hello");
    String s2 = new String("hello");
    String s3 = new String("world");
    String s4 = s1;
    System.out.println(s1 == s2); // false
    System.out.println(s2 == s3); // false
    System.out.println(s1 == s4); // true
}
```

**2. boolean equals(Object anObject)** **方法：按照字典序比较**

字典序：字符大小的顺序

String类重写了父类Object中equals方法，Object中equals默认按照==比较，String重写equals方法后，按照

如下规则进行比较，比如： s1.equals(s2)

```
public boolean equals(Object anObject) {
  // 1. 先检测this 和 anObject 是否为同一个对象比较，如果是返回true
  if (this == anObject) {
    return true;
  }
  
  
  // 2. 检测anObject是否为String类型的对象，如果是继续比较，否则返回false
  if (anObject instanceof String) {
  // 将anObject向下转型为String类型对象
    String anotherString = (String)anObject;
    int n = value.length;
    
    
  // 3. this和anObject两个字符串的长度是否相同，是继续比较，否则返回false
  if (n == anotherString.value.length) {
    char v1[] = value;
    char v2[] = anotherString.value;
    int i = 0;
    
    
  // 4. 按照字典序，从前往后逐个字符进行比较
    while (n-- != 0) {
      if (v1[i] != v2[i])
        return false;
      i++;
    }
    return true;
  }
}
return false；
```

```
public static void main(String[] args) {
  String s1 = new String("hello");
  String s2 = new String("hello");
  String s3 = new String("Hello");
  
// s1、s2、s3引用的是三个不同对象，因此==比较结果全部为false
  System.out.println(s1 == s2); // false
  System.out.println(s1 == s3); // false
  
// equals比较：String对象中的逐个字符
// 虽然s1与s2引用的不是同一个对象，但是两个对象中放置的内容相同，因此输出true
// s1与s3引用的不是同一个对象，而且两个对象中内容也不同，因此输出false
  System.out.println(s1.equals(s2)); // true
  System.out.println(s1.equals(s3)); // false
}
```

**3. int compareTo(String s)** **方法:按照字典序进行比较**

与equals不同的是，equals返回的是boolean类型，而compareTo返回的是int类型。具体比较方式：

1. 先按照字典次序大小比较，如果出现不等的字符，直接返回这两个字符的大小差值

2. 如果前k个字符相等(k为两个字符长度最小值)，返回值两个字符串长度差值

```
public static void main(String[] args) {
  String s1 = new String("abc");
  String s2 = new String("ac");
  String s3 = new String("abc");
  String s4 = new String("abcdef");
  System.out.println(s1.compareTo(s2)); // 不同输出字符差值-1
  System.out.println(s1.compareTo(s3)); // 相同输出 0
  System.out.println(s1.compareTo(s4)); // 前k个字符完全相同，输出长度差值 -3
}
```

4. int compareToIgnoreCase(String str) 方法：与compareTo方式相同，但是忽略大小写比较

```
public static void main(String[] args) {
  String s1 = new String("abc");
  String s2 = new String("ac");
  String s3 = new String("ABc");
  String s4 = new String("abcdef");
  System.out.println(s1.compareToIgnoreCase(s2)); // 不同输出字符差值-1
  System.out.println(s1.compareToIgnoreCase(s3)); // 相同输出 0
  System.out.println(s1.compareToIgnoreCase(s4)); // 前k个字符完全相同，输出长度差值 -3
}
```

------

###### 2.3 字符查找

| **方法**                                   | **功能**                                                     |
| :----------------------------------------- | :----------------------------------------------------------- |
| char charAt(int index)                     | 返回index位置上字符，如果index为负数或者越界，抛出IndexOutOfBoundsException异常 |
| int indexOf(int ch)                        | 返回ch第一次出现的位置，没有返回-1                           |
| int indexOf(int ch, int fromIndex)         | 从fromIndex位置开始找ch第一次出现的位置，没有返回-1          |
| int indexOf(String str)                    | 返回str第一次出现的位置，没有返回-1                          |
| int indexOf(String str, int fromIndex)     | 从fromIndex位置开始找str第一次出现的位置，没有返回-1         |
| int lastIndexOf(int ch)                    | 从后往前找，返回ch第一次出现的位置，没有返回-1               |
| int lastIndexOf(int ch, int fromIndex)     | 从fromIndex位置开始找，从后往前找ch第一次出现的位置，没有返回-1 |
| int lastIndexOf(String str)                | 从后往前找，返回str第一次出现的位置，没有返回-1              |
| int lastIndexOf(String str, int fromIndex) | 从fromIndex位置开始找，从后往前找str第一次出现的位置，没有返 |

```
public static void main(String[] args) {
  String s = "aaabbbcccaaabbbccc";
  System.out.println(s.charAt(3)); // 'b'
  System.out.println(s.indexOf('c')); // 6
  System.out.println(s.indexOf('c', 10)); // 15
  System.out.println(s.indexOf("bbb")); // 3
  System.out.println(s.indexOf("bbb", 10)); // 12
  System.out.println(s.lastIndexOf('c')); // 17
  System.out.println(s.lastIndexOf('c', 10)); // 8
  System.out.println(s.lastIndexOf("bbb")); // 12
  System.out.println(s.lastIndexOf("bbb", 10)); // 3
```

注意：上述方法都是实例方法。

------

###### 2.4 转化

1.**数值和字符串转化**

```
public static void main(String[] args) {
// 数字转字符串
  String s1 = String.valueOf(1234);
  String s2 = String.valueOf(12.34);
  String s3 = String.valueOf(true);
  String s4 = String.valueOf(new Student("Hanmeimei", 18));
  System.out.println(s1);
  System.out.println(s2);
  System.out.println(s3);
  System.out.println(s4);
  System.out.println("=================================");
  // 字符串转数字
  // 注意：Integer、Double等是Java中的包装类型，这个后面会讲到
  int data1 = Integer.parseInt("1234");
  double data2 = Double.parseDouble("12.34");
  System.out.println(data1);
  System.out.println(data2);
}
```

2.大小写转换

```
public static void main(String[] args) {
  String s1 = "hello";
  String s2 = "HELLO";
  // 小写转大写
  System.out.println(s1.toUpperCase());
  // 大写转小写
  System.out.println(s2.toLowerCase());
}
```

3.字符串转数组

```
public static void main(String[] args) {
  String s = "hello";
  // 字符串转数组
  char[] ch = s.toCharArray();
  for (int i = 0; i < ch.length; i++) {
    System.out.print(ch[i]);
  }
  System.out.println();
  // 数组转字符串
  String s2 = new String(ch);
  System.out.println(s2);
}
```

4.格式化

```
public static void main(String[] args) {
  String s = String.format("%d-%d-%d", 2019, 9,14);
  System.out.println(s);
}
```

------

###### 2.5 字符串替换

使用一个指定的新的字符串替换掉已有的字符串数据，可用的方法如下：

| 方法                                                  | 功能               |
| ----------------------------------------------------- | ------------------ |
| String replaceAll(String regex, String replacement)   | 替换所有的指定内容 |
| String replaceFirst(String regex, String replacement) | 替换首个内容       |

![image-20230401133757560](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401133757560.png)

**注意事项**:由于字符串是不可变对象, 替换不修改当前字符串, 而是产生一个新的字符串.

------

###### 2.6 字符串拆分

可以将一个完整的字符串按照指定的分隔符划分为若干个子字符串。

| 功能                                | 方法                                    |
| ----------------------------------- | --------------------------------------- |
| 将字符串全部拆分                    | String[] split(String regex)            |
| 将字符串以指定的格式，拆分为limit组 | String[] split(String regex, int limit) |

```
public static void main(String[] args) {
        String str = "hello world hello bit" ;
        String[] result = str.split(" ") ; // 按照空格拆分
        for(String s: result) {
            System.out.println(s+" ");
        }
        System.out.println("========================");

        String str1 = "hello world hello bit" ;
        String[] result1 = str1.split(" ",2) ;
        for(String s: result1) {
            System.out.println(s+" ");
        }
        
        String str2 = "192.168.1.1" ;
        String[] result2 = str2.split("\\.") ;
        for(String s1: result2) {
            System.out.println(s1);
        }
    }
```

![image-20230401135858905](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401135858905.png)

**注意事项**:

1. 字符"|","*","+"都得加上转义字符，前面加上 "\\" .

2. 而如果是 "\" ，那么就得写成 "\\\\" .

3. 如果一个字符串中有多个分隔符，可以用"|"作为连字符.

![image-20230401140207221](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401140207221.png)

------

###### 2.7 字符串截取

从一个完整的字符串之中截取出部分内容

| 方法                                           | 功能                 |
| ---------------------------------------------- | -------------------- |
| String substring(int beginIndex)               | 从指定索引截取到结尾 |
| String substring(int beginIndex, int endIndex) | 截取部分内容         |

```
public static void main(String[] args) {  //字符串截取
        String str = "helloworld" ;
        System.out.println(str.substring(5));
        System.out.println(str.substring(0, 5));
    }
    最后输出：
        world
        hello
```

**注意事项:**

1. 索引从0开始

2. 注意前闭后开区间的写法, substring(0, 5) 表示包含 0 号下标的字符, 不包含 5 号下标

------

###### 2.8 其他方法

| 方法                 | 功能                                |
| -------------------- | ----------------------------------- |
| String trim()        | 去掉字符串中的左右空格,保留中间空格 |
| String toUpperCase() | 字符串转大写                        |
| String toLowerCase() | 字符串转小写                        |

![image-20230401141143833](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401141143833.png)

trim 会去掉字符串开头和结尾的空白字符(空格, 换行, 制表符等).

![image-20230401141452351](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401141452351.png)

这两个函数只转换字母。

------

###### 2.9 字符串的不可变性

String是一种不可变对象. 字符串中的内容是不可改变。字符串不可被修改

1. **String类在设计时就是不可改变的，String类实现描述中已经说明了**

![image-20230401161542441](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401161542441.png)

**String类中的字符实际保存在内部维护的value字符数组中**，该图还可以看出：

\1. String类被final修饰，表明该类不能被继承

\2. value被修饰被final修饰，表明value自身的值不能改变，即不能引用其它字符数组，但是其引用空间中

的内容可以修改。

**2.所有涉及到可能修改字符串内容的操作都是创建一个新对象，改变的是新对象**

比如 replace 方法

![image-20230401161756324](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401161756324.png)

【**纠正**】网上有些人说：字符串不可变是因为其内部保存字符的数组被fifinal修饰了，因此不能改变。

这种说法是错误的，不是因为String类自身，或者其内部value被final修饰而不能被修改。

**final修饰类表明该类不想被继承，final修饰引用类型表明该引用变量不能引用其他对象，但是其引用对象中的内**

**容是可以修改的**。

**为什么** **String** **要设计成不可变的****?**(不可变对象的好处是什么?) (选学)

1. 方便实现字符串对象池. 如果 String 可变, 那么对象池就需要考虑写时拷贝的问题了.

2. 不可变对象是线程安全的.

3. 不可变对象更方便缓存 hash code, 作为 key 时可以更高效的保存到 HashMap 中.

------

###### 2.10 字符串修改

**注意：尽量避免直接对String类型对象进行修改，因为String类是不能修改的，所有的修改都会创建新对象，效率非常低下。**

![image-20230401162306160](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401162306160.png)

```
public static void main(String[] args) {
  long start = System.currentTimeMillis();
  String s = "";
  for(int i = 0; i < 10000; ++i){
    s += i;
  }
  long end = System.currentTimeMillis();
  System.out.println(end - start);
  start = System.currentTimeMillis();
  StringBuffer sbf = new StringBuffer("");
  for(int i = 0; i < 10000; ++i){
    sbf.append(i);
  }
  end = System.currentTimeMillis();
  System.out.println(end - start);
  start = System.currentTimeMillis();
  StringBuilder sbd = new StringBuilder();
  for(int i = 0; i < 10000; ++i){
    sbd.append(i);
  }
  end = System.currentTimeMillis();
  System.out.println(end - start);
}
```

可以看待在对String类进行修改时，效率是非常慢的，因此：尽量避免对String的直接需要，如果要修改建议尽量

使用StringBuffer或者StringBuilder。

![image-20230401171223920](C:\Users\c'k\AppData\Roaming\Typora\typora-user-images\image-20230401171223920.png)
