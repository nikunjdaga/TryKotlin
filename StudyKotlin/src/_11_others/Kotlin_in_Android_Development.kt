package _11_others

/**
 * Created by ssyijiu on 2017/5/28.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

// https://mp.weixin.qq.com/s?__biz=MzI0NjIzNDkwOA==&mid=2247484064&idx=1&sn=4321c1b7da463f9c4953ab3e5482ad4d&chksm=e94328d3de34a1c5c70dde6d4c6aecc2d3cfdea5997be5f7a2c0a37ef6856740bab130264489&scene=0&key=fba291eaa28a5e78977ffade75254fb44333d69ad8457eeb7846485c93aab529591ff6092ed22884172249e619e0d22ca0f4ae6354a23432599d6f95ce51542b74098de3f1178d17eea4a9a32f80c910&ascene=0&uin=MTI1OTQxOTIyMQ%3D%3D&devicetype=iMac+MacBookPro11%2C4+OSX+OSX+10.12.4+build(16E195)&version=12020610&nettype=WIFI&fontScale=100&pass_ticket=BujqiJpAUdHWhLd3iOpsm7LuEYpy3LBMsORkiSKphqfDinaGel1HUrHwOQgUv0xb
// 多数是 Android 开发的

fun main(args: Array<String>) {
    for (it in 1..100) {
        println(Singleton.instance)
    }
}

// 单例，饿汉
object KotlinElvis {

}

// 单例，懒汉
class Singleton private constructor() {

    private object Holder {
        val INSTANCE = Singleton()
    }

    companion object {
        val instance : Singleton by lazy { Holder.INSTANCE }
    }
}