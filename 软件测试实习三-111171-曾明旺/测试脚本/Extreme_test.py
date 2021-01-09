# -*- coding: utf-8 -*- 
# 上面那句是为了支持中文注释。文件请保存 utf-8 格式免得出问题
#引入模块
from com.android.monkeyrunner import MonkeyRunner,MonkeyDevice,MonkeyImage
import time
import os

#连接设备
device=MonkeyRunner.waitForConnection() 
#启动Activity（此处为启动模拟器的浏览器）
mPackageName = "com.zhihu.android"
mActivityName = "com.zhihu.android.app.ui.activity.MainActivity"
mRunComponent = mPackageName + "/" + mActivityName

#获取时间
def getNowTimeUnderline():
    return time.strftime("_%H_%M_%S",time.localtime(time.time()))
 
#获取日期
def getToday():
    return time.strftime("%Y_%m_%d",time.localtime(time.time()))

#截图并保存
def shotPhoto():
 newimage = device.takeSnapshot()
 newimage.writeToFile ("ImageFile/" + getToday() + getNowTimeUnderline() + ".png" , "png")
 time.sleep(1.0)

#创建存储截图的文件夹
def mkdirPath(path):
    if not os.path.exists(path):
        os.mkdir(path)

#创建文件夹
mkdirPath("ImageFile")

#启动应用
device.startActivity(component =  mRunComponent)
time.sleep(3.0)#启动Acticity的时间

for slipCount in range(1,3):#迭代1到3之间，相当于循环两次。
 device.drag( (385,1032), (385,700), 1.0, 10 )#向上滑动
 time.sleep(0.01)
 shotPhoto()

device.touch(400, 170, "DOWN_AND_UP")#单击该坐标（搜索框）
time.sleep(0.01)
shotPhoto()

device.type('ansdkjasnbdhasndjasbhdashdjbashdbsahdbsabhdjadbasjhdbasdbhsadjabdjadbasjdbsajhdsad')         #键盘中输入关键字，例如人工智能
time.sleep(1.0)
device.press('KEYCODE_ENTER', MonkeyDevice.DOWN_AND_UP)#enter 确认跳转
time.sleep(0.01)
shotPhoto()

device.touch(220, 673, "DOWN_AND_UP")#点击第一篇文章
time.sleep(0.01)
shotPhoto()
