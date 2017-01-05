# Robotium_Test

Step 1 ：在Module:app ---> 添加依赖  { androidTestCompile 'com.jayway.android.robotium:robotium-solo:5.4.0'
    androidTestCompile 'junit:junit:4.12'}
    
Step 2 : 在android Test分支下新建测试类 ，可以参考这仓库文件-》 路径：robotium->src->androidTest/java/......->MyApplicationTest

Step 3 ：菜单栏 Run->Edit configrations->Android Tests->指定 instrumentation runner 为 android.test.InstrumentationTestRunner

Step 4 ：编写完用例后在界面右键Run即可，在下面窗口可以看见运行结果.
