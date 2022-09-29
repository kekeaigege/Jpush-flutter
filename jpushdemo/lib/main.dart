import 'package:flutter/material.dart';
import 'package:jpush_flutter/jpush_flutter.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final JPush jpush = JPush();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    initJpush();
  }

  Future initJpush() async {
    jpush.applyPushAuthority(
        new NotificationSettingsIOS(sound: true, alert: true, badge: true));
    //获取注册的id
    jpush.getRegistrationID().then((rid) {
      //这里说一下 若别处需要使用rid 如此调用   await jpush.getRegistrationID()
      print("获取注册的id:$rid");
    });
    //初始化
    jpush.setup(
      appKey: "2256ff3a9699df46386eef47",
      channel: "thisChannel",
      production: false,
      debug: true, // 设置是否打印 debug 日志
    );
    try {
      //监听消息通知
      jpush.addEventHandler(
        // 接收通知回调方法。
        onReceiveNotification: (Map<String, dynamic> message) async {
          print("flutter onReceiveNotification: $message");
        },
        // 点击通知回调方法。
        onOpenNotification: (Map<String, dynamic> message) async {
          print("flutter onOpenNotification: $message");
        },
        // 接收自定义消息回调方法。
        onReceiveMessage: (Map<String, dynamic> message) async {
          print("flutter onReceiveMessage: $message");
        },
      );
    } catch (e) {
      print('极光sdk配置异常');
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: const Text("极光推送"),
        ),
        body: Container(
          child: Column(
            children: [
              FlatButton(
                  onPressed: () {
                    var fireDate = DateTime.fromMillisecondsSinceEpoch(
                        DateTime.now().millisecondsSinceEpoch + 2000);
                    var localNotification = LocalNotification(
                        id: 3,
                        title: '(验证码)',
                        buildId: 1,
                        content: '验证码，仅用于密码修改',
                        fireTime: fireDate,
                        subtitle: '验证码',
                        badge: 5,
                        extra: {"": ""});
                    jpush
                        .sendLocalNotification(localNotification)
                        .then((value) {
                      print(value);
                    });
                  },
                  child: Text("推送消息"))
            ],
          ),
        ),
      ),
    );
  }
}
