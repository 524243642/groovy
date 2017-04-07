import org.junit.Test

/**
 * Created by zhangbin on 17/4/6.
 */
class HelloGroovyTest {
    def varStr = "heollo groovy"
    def varInt = 1001

    def repeat(val) {
        for (i in 0..5) {
            println val
        }
    }

    def repeatBounder(val, repeat = 3) {
        for (i in 0..<repeat) {
            println("This is ${i}:${val}")
        }
    }

    @Test
    void testHelloGroovy() {
        println varStr
        println varStr.class
    }

    @Test
    void testVarInt() {
        println varInt
        println varInt.class
    }

    @Test
    void testRepeat() {
        repeat(varStr)
    }

    @Test
    void testGstring() {
        println "This is ${varStr}"
    }

    @Test
    void testForBounder() {
        repeatBounder(varInt)
    }

    @Test
    void testCollect() {
        def collect = ["a", "b", "c"]
        collect.add(1)
        collect << "come on"
        collect[collect.size()] = 100.0
        println collect[5]
        println collect[collect.size() - 1]
        println collect[-1]
        collect = collect + 5
        println collect[-1]
        collect = collect - collect[0..4]
        println collect[0]
    }

    @Test
    void testMap() {
        def map = ['name': 'john', 'age': 14, 'sex': 'boy']
        map = map + ['weight': 25]
        map.put('length', 1.27)
        map.father = 'Keller'
        println map['father']
        println map.length

        //testClosure
        map.each({ key, value -> println "$key:$value" })
        map.each { println it }
        map.each { println it.getKey() + "-->" + it.getValue() }
    }

    @Test
    void testClosure() {
        def say = { word -> println "Hi,$word!" }
        say('groovy')
        say.call('groovy&grails')
    }

    @Test
    void testIgnoreBracket() {
        def person1 = new Person()
        person1.setName 'kk'
        person1.setName('kk')
        person1.age = 20
//        person1.age(20)
        println person1

        def person2 = new Person(['name': 'gg', 'age': '18'])
        println person2

        def person3 = new Person('name':'ddd','age':18)
        println person3

    }

    @Test
    void testInterrogation() {
        def collect = ["a", "b", "c"]
        println collect.iterator()?.next()
    }

    int sum(int ... var) {
        def total = 0
        for (i in var) total += i
        return total
    }

    @Test
    void testVariable() {
        println sum(1, 2, 3, 5)
    }

    @Test
    void testEnum() {
        def today = Day.SATURDAY
        switch (today) {
            case [Day.SATURDAY, Day.SUNDAY]: println "Weekends are cool"
                break
            case Day.MONDAY..Day.FRIDAY: println "Boring word day"
                break
            default: println "error"

        }
    }

    @Test
    void testElvis() {
        def msg = "Hello!"
        println msg ?: 'cc'
        println null ?: 'kk'
    }

    @Test
    void testMetaClass() {
        def msg = "Hello!"
        println msg.metaClass
        String.metaClass.up = { delegate.toUpperCase() }
        println msg.up()

        msg.metaClass.methods.each { println it.name }
        println '------'
        msg.metaClass.properties.each { println it.name }

        msg.metaClass.respondsTo(msg, "up") ? println(msg.toUpperCase()) : null

        msg.metaClass.hasProperty(msg, 'bytes') ? println(msg.bytes.encodeBase64()) : null
    }

    /**
     * 强制转换测试
     */
    @Test
    void testLong2Int() {
        long id = 100;
        System.out.println((int) id);
    }


    class Person {
        def name
        def age

        String toString() {
            "$name,$age"
        }
    }

    enum Day {
        SUNDAY, MONDAY, TUESDAY, WENDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
}
