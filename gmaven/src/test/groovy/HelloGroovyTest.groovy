import org.junit.Test

/**
 * Created by zhangbin on 17/4/6.
 */
class HelloGroovyTest {
    def varStr = "heollo groovy"
    def varInt = 1001
    def repeat(val){
        for(i in 0..5){
            println val
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
    void testRepeat(){
        repeat(varStr)
    }

    @Test
    void testGstring(){
        println "This is ${varStr}"
    }


}
